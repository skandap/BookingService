package com.skanda.inquireUserBookings.service;

import com.skanda.inquireUserBookings.entity.InquireUserBookingResponse;
import com.skanda.util.client.TrainServiceClient;
import com.skanda.util.client.UserServiceClient;
import com.skanda.util.entity.BookingEntity;
import com.skanda.util.entity.BookingSummary;
import com.skanda.util.entity.TrainSummary;
import com.skanda.util.entity.UserSummary;
import com.skanda.util.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class InquireUserBookingServiceImpl implements InquireUserBookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserServiceClient userServiceClient;

    @Autowired
    private TrainServiceClient trainServiceClient;

    @Override
    public InquireUserBookingResponse fetchUserBookings(Long userId) {
        List<BookingEntity> bookings = bookingRepository.findAllByUserId(userId);
        UserSummary userSummary = userServiceClient.fetchUser(userId);
        return mapToResponse(bookings, userSummary);
    }

    private InquireUserBookingResponse mapToResponse(List<BookingEntity> bookings, UserSummary userSummary) {
        return InquireUserBookingResponse.builder()
                .userId(userSummary.getUserId())
                .userName(userSummary.getName())
                .email(userSummary.getEmail())
                .bookings(mapToBookings(bookings))
                .build();
    }

    private List<BookingSummary> mapToBookings(List<BookingEntity> bookingEntities) {
        return bookingEntities.stream()
                .map(e -> {
                    TrainSummary trainSummary = trainServiceClient.fetchTrainSummary(e.getTrainId());
                    return BookingSummary.builder()
                            .bookingId(e.getBookingId())
                            .train(trainSummary)
                            .travelDate(e.getTravelDate())
                            .numberOfSeats(e.getNumberOfSeats())
                            .totalFare(e.getTotalFare())
                            .paymentMode("UPI")
                            .bookingStatus("PENDING")
                            .createdAt(LocalDateTime.now())
                            .build();
                })
                .toList();
    }
}
