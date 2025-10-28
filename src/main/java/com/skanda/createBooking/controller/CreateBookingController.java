package com.skanda.createBooking.controller;

import com.skanda.createBooking.entity.CreateBookingRequest;
import com.skanda.createBooking.entity.CreateBookingResponse;
import com.skanda.createBooking.service.CreateBookingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookings")
public class CreateBookingController {

    @Autowired
    public CreateBookingServiceImpl createBookingService;

    @PostMapping("/create")
    public ResponseEntity<CreateBookingResponse> createBooking(@RequestBody CreateBookingRequest createBookingRequest)
    {
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
