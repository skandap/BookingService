package com.skanda.modifyBookings.service;

import com.skanda.modifyBookings.entity.ModifyBookingRequest;
import com.skanda.modifyBookings.entity.ModifyBookingResponse;
import com.skanda.util.client.TrainServiceClient;
import com.skanda.util.client.UserServiceClient;
import com.skanda.util.entity.BookingEntity;
import com.skanda.util.entity.TrainSummary;
import com.skanda.util.entity.UserSummary;
import com.skanda.util.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Service
public class ModifyBookingServiceImpl implements ModifyBookingService {

    @Autowired
    public BookingRepository bookingRepository;

    @Autowired
    public UserServiceClient userServiceClient;

    @Autowired
    public TrainServiceClient trainServiceClient;

    @Override
    public ModifyBookingResponse updateDetails(ModifyBookingRequest modifyBookingRequest, Long bookingId) {
        BookingEntity bookingEntity = bookingRepository.findById(bookingId).orElseThrow(() -> new RuntimeException("No bookingId found"));
        return mapToResponse(bookingEntity, modifyBookingRequest);
    }

    public ModifyBookingResponse mapToResponse(BookingEntity bookingEntity, ModifyBookingRequest modifyBookingRequest) {
        LocalDate oldTravelDate = bookingEntity.getTravelDate();
        int oldSeatCount = bookingEntity.getNumberOfSeats();
        UserSummary userSummary = userServiceClient.fetchUser(bookingEntity.getUserId());
        TrainSummary trainSummary = trainServiceClient.fetchTrainSummary(bookingEntity.getTrainId());

        if (bookingEntity.getTravelDate() != modifyBookingRequest.getTravelDate()) {
            bookingEntity.setTravelDate(modifyBookingRequest.getTravelDate());
        }
        if (!Objects.equals(bookingEntity.getNumberOfSeats(), modifyBookingRequest.getNumberOfSeats())) {
            bookingEntity.setNumberOfSeats(modifyBookingRequest.getNumberOfSeats());
        }
        bookingRepository.save(bookingEntity);
        return ModifyBookingResponse.builder()
                .bookingId(bookingEntity.getBookingId())
                .user(userSummary)
                .train(trainSummary)
                .oldTravelDate(oldTravelDate)
                .newTravelDate(bookingEntity.getTravelDate())
                .oldSeatCount(oldSeatCount)
                .newSeatCount(bookingEntity.getNumberOfSeats())
                .totalFare(bookingEntity.getTotalFare())
                .bookingStatus("PENDING")
                .updatedAt(LocalDateTime.now())
                .build();
    }
}
