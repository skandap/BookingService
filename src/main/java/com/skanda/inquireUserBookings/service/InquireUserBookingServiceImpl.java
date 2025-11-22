package com.skanda.inquireUserBookings.service;

import com.skanda.inquireUserBookings.behaviour.UserBookingNotFoundEx;
import com.skanda.inquireUserBookings.entity.InquireUserBookingResponse;
import com.skanda.util.client.ReferenceCodesClient;
import com.skanda.util.client.TrainServiceClient;
import com.skanda.util.client.UserServiceClient;
import com.skanda.util.entity.*;
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

    @Autowired
    private ReferenceCodesClient referenceCodesClient;

    @Override
    public InquireUserBookingResponse fetchUserBookings(Long userId) {
        List<BookingEntity> bookings = bookingRepository.findAllByUserId(userId);
        if (bookings.isEmpty()) {
            throw new UserBookingNotFoundEx("userId not found for ID: " + userId);
        }
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
                    ReferenceCodes bookingStatus= referenceCodesClient.fetchRefCodes(e.getBookingStatus());
                    ReferenceCodes paymentMode= referenceCodesClient.fetchRefCodes(e.getPaymentMode());
                    ReferenceCodes classType= referenceCodesClient.fetchRefCodes(e.getClassType());
                    return BookingSummary.builder()
                            .bookingId(e.getBookingId())
                            .train(trainSummary)
                            .travelDate(e.getTravelDate())
                            .numberOfSeats(e.getNumberOfSeats())
                            .totalFare(e.getTotalFare())
                            .paymentMode(paymentMode)
                            .bookingStatus(bookingStatus)
                            .classType(classType)
                            .createdAt(LocalDateTime.now())
                            .build();
                })
                .toList();
    }
}
