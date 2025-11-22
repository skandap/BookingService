package com.skanda.inquireBookingDetails.service;

import com.skanda.inquireBookingDetails.behaviours.DetailsBookingNotFoundEx;
import com.skanda.inquireBookingDetails.entity.InquireBookingDetailsResponse;
import com.skanda.util.client.ReferenceCodesClient;
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

    @Autowired
    ReferenceCodesClient referenceCodesClient;


    @Override
    public InquireBookingDetailsResponse fetchBookingDetails(Long bookingId) {
        BookingEntity bookingEntity = bookingRepository.findById(bookingId).orElseThrow(() -> new DetailsBookingNotFoundEx("Booking not found for ID: " + bookingId));
        return mapToResponse(bookingEntity);
    }

    public InquireBookingDetailsResponse mapToResponse(BookingEntity bookingEntity) {
        UserSummary userSummary = userServiceClient.fetchUser(bookingEntity.getUserId());
        TrainSummary trainSummary = trainServiceClient.fetchTrainSummary(bookingEntity.getTrainId());
       ReferenceCodes bookingStatus= referenceCodesClient.fetchRefCodes(bookingEntity.getBookingStatus());
        ReferenceCodes paymentMode= referenceCodesClient.fetchRefCodes(bookingEntity.getPaymentMode());
        ReferenceCodes classType= referenceCodesClient.fetchRefCodes(bookingEntity.getClassType());
        return InquireBookingDetailsResponse.builder()
                .bookingId(bookingEntity.getBookingId())
                .user(userSummary)
                .train(trainSummary)
                .travelDate(bookingEntity.getTravelDate())
                .numberOfSeats(bookingEntity.getNumberOfSeats())
                .totalFare(bookingEntity.getTotalFare())
                .paymentMode(paymentMode)
                .classType(classType)
                .bookingStatus(bookingStatus)
                .createdAt(LocalDateTime.now())
                .updatedAt(bookingEntity.getUpdatedAt())
                .build();
    }
}

