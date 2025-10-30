package com.skanda.inquireBookingDetails.service;

import com.skanda.inquireBookingDetails.entity.InquireBookingDetailsResponse;
import com.skanda.util.client.TrainServiceClient;
import com.skanda.util.client.UserServiceClient;
import com.skanda.util.entity.*;
import com.skanda.util.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class InquireBookingServiceImpl implements InquireBookingDetailsService {

    @Autowired
    public BookingRepository bookingRepository;
    @Autowired
    public UserServiceClient userServiceClient;

    @Autowired
    public TrainServiceClient trainServiceClient;


    @Override
    public InquireBookingDetailsResponse fetchBookingDetails(Long bookingId) {
        BookingEntity bookingEntity = bookingRepository.findById(bookingId).orElseThrow(() -> new RuntimeException("No booking id found"));
        return mapToResponse(bookingEntity);
    }

    public InquireBookingDetailsResponse mapToResponse(BookingEntity bookingEntity) {
        UserSummary userSummary = userServiceClient.fetchUser(bookingEntity.getUserId());
        TrainSummary trainSummary = trainServiceClient.fetchTrainSummary(bookingEntity.getTrainId());
        return InquireBookingDetailsResponse.builder()
                .bookingId(bookingEntity.getBookingId())
                .user(userSummary)
                .train(trainSummary)
                .travelDate(bookingEntity.getTravelDate())
                .numberOfSeats(bookingEntity.getNumberOfSeats())
                .totalFare(bookingEntity.getTotalFare())
                .paymentMode("UPI")
                .bookingStatus("PENDING")
                .createdAt(LocalDateTime.now())
                .build();
    }
}

