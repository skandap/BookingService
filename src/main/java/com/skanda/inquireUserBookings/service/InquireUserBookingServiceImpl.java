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
    public List<InquireUserBookingResponse> fetchUserBookings(Long userId) {
        List<BookingEntity> bookings = bookingRepository.findAllByUserId(userId);

        return bookings.stream()
                .map(this::mapToResponse)
                .toList();
    }

    private InquireUserBookingResponse mapToResponse(BookingEntity booking) {
        // Fetch external data
        UserSummary userSummary = userServiceClient.fetchUser(booking.getUserId());
        TrainSummary trainSummary = trainServiceClient.fetchTrainSummary(booking.getTrainId());

        // Create booking summary
        BookingSummary bookingSummary = new BookingSummary();
        bookingSummary.setBookingId(booking.getBookingId());
        bookingSummary.setTrain(trainSummary);
        bookingSummary.setTravelDate(booking.getTravelDate());
        bookingSummary.setNumberOfSeats(booking.getNumberOfSeats());
        bookingSummary.setTotalFare(booking.getTotalFare());
        bookingSummary.setPaymentMode("UPI");
        bookingSummary.setBookingStatus("PENDING");
        bookingSummary.setCreatedAt(LocalDateTime.now());

        // Return final response
        InquireUserBookingResponse response = new InquireUserBookingResponse();
        response.setUserId(userSummary.getUserId());
        response.setUserName(userSummary.getName());
        response.setEmail(userSummary.getEmail());
        response.setBookings(List.of(bookingSummary));

        return response;
    }
}
