package com.skanda.deleteBooking.controller;

import com.skanda.deleteBooking.entity.DeleteBookingResponse;
import com.skanda.deleteBooking.service.DeleteBookingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookings")
public class DeleteBookingController {

    @Autowired
    public DeleteBookingServiceImpl deleteBookingService;

    @DeleteMapping("/cancel/{bookingId}")
    public ResponseEntity<DeleteBookingResponse> cancelBooking(@PathVariable Long bookingId)
    {
        return new ResponseEntity<>(deleteBookingService.cancelBooking(bookingId),HttpStatus.OK);
    }
}
