package com.skanda.createBooking.service;

import com.skanda.createBooking.entity.CreateBookingRequest;
import com.skanda.createBooking.entity.CreateBookingResponse;
import com.skanda.util.client.TrainServiceClient;
import com.skanda.util.client.UserServiceClient;
import com.skanda.util.entity.*;
import com.skanda.util.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CreateBookingServiceImpl implements CreateBookingService {

    @Autowired
    public BookingRepository bookingRepository;

    @Autowired
    public UserServiceClient userServiceClient;

    @Autowired
    public TrainServiceClient trainServiceClient;

    @Override
    public CreateBookingResponse bookTrain(CreateBookingRequest createBookingRequest) {
        BookingEntity bookingEntity = mapToEntity(createBookingRequest);
        bookingRepository.save(bookingEntity);
        return mapToResponse(bookingEntity);
    }

    public BookingEntity mapToEntity(CreateBookingRequest createBookingRequest) {

        return BookingEntity.builder().
                userId(createBookingRequest.getUserId())
                .trainId(createBookingRequest.getTrainId())
                .bookingStatus("Pending")
                .travelDate(createBookingRequest.getTravelDate())
                .numberOfSeats(createBookingRequest.getNumberOfSeats())
                .totalFare(100.00)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .classType(createBookingRequest.getClassType())
                .paymentMode(createBookingRequest.getPaymentMode().toString())
                .build();
    }

    public CreateBookingResponse mapToResponse(BookingEntity bookingEntity) {
        UserSummary userSummary = userServiceClient.fetchUser(bookingEntity.getUserId());
        TrainSummary trainSummary = trainServiceClient.fetchTrainSummary(bookingEntity.getTrainId());
        return CreateBookingResponse.builder()
                .bookingId(bookingEntity.getBookingId())
                .user(userSummary)
                .train(trainSummary)
                .travelDate(bookingEntity.getTravelDate())
                .numberOfSeats(bookingEntity.getNumberOfSeats())
                .totalFare(bookingEntity.getTotalFare())
                .paymentMode(PaymentMode.UPI)
                .bookingStatus(BookingStatus.PENDING)
                .classType(bookingEntity.getClassType())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
