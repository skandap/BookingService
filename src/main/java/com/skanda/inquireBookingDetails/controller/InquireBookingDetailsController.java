package com.skanda.inquireBookingDetails.controller;


import com.skanda.inquireBookingDetails.entity.InquireBookingDetailsResponse;
import com.skanda.inquireBookingDetails.service.InquireBookingServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookings")
public class InquireBookingDetailsController {

    @Autowired
    public InquireBookingServiceImpl inquireBookingService;

    @GetMapping("/{bookingId}")
    public ResponseEntity<InquireBookingDetailsResponse> fetchBookingDetails(@Valid @PathVariable Long bookingId)
    {
        return new ResponseEntity<>(inquireBookingService.fetchBookingDetails(bookingId),HttpStatus.OK);
    }
}
