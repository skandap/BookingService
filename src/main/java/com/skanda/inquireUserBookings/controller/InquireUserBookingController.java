package com.skanda.inquireUserBookings.controller;

import com.skanda.inquireUserBookings.entity.InquireUserBookingResponse;
import com.skanda.inquireUserBookings.service.InquireUserBookingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookings")
public class InquireUserBookingController {

    @Autowired
    public InquireUserBookingServiceImpl inquireUserBookingService;

    @GetMapping("/bookings/{userId}")
    public ResponseEntity<InquireUserBookingResponse> fetchUserBookings(@PathVariable Long userId)
    {
        return new ResponseEntity<>(inquireUserBookingService.fetchUserBookings(userId),HttpStatus.OK);
    }
}
