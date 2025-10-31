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

import java.awt.print.Book;
import java.time.LocalDateTime;
import java.util.ArrayList;
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

    private InquireUserBookingResponse mapToResponse(List<BookingEntity> booking, UserSummary userSummary) {

        InquireUserBookingResponse inquireUserBookingResponse = new InquireUserBookingResponse();
        inquireUserBookingResponse.setUserId(userSummary.getUserId());
        inquireUserBookingResponse.setUserName(userSummary.getName());
        inquireUserBookingResponse.setEmail(userSummary.getEmail());
        inquireUserBookingResponse.setBookings(mapToBookings(booking));
        return inquireUserBookingResponse;

    }

    public List<BookingSummary> mapToBookings(List<BookingEntity> bookingEntities) {
        List<BookingSummary> bookingSummaries = new ArrayList<>();
        for (BookingEntity e : bookingEntities) {
            TrainSummary trainSummary = trainServiceClient.fetchTrainSummary(e.getTrainId());
            BookingSummary bookingSummary = new BookingSummary();
            bookingSummary.setBookingId(e.getBookingId());
            bookingSummary.setTrain(trainSummary);
            bookingSummary.setTravelDate(e.getTravelDate());
            bookingSummary.setNumberOfSeats(e.getNumberOfSeats());
            bookingSummary.setTotalFare(e.getTotalFare());
            bookingSummary.setPaymentMode("UPI");
            bookingSummary.setBookingStatus("PENDING");
            bookingSummary.setCreatedAt(LocalDateTime.now());
            bookingSummaries.add(bookingSummary);
        }
        return bookingSummaries;
    }
}
