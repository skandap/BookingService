package com.skanda.modifyBookings.controller;

import com.skanda.modifyBookings.entity.ModifyBookingRequest;
import com.skanda.modifyBookings.entity.ModifyBookingResponse;
import com.skanda.modifyBookings.service.ModifyBookingServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookings")
public class ModifyBookingController {

    @Autowired
    public ModifyBookingServiceImpl modifyBookingService;

    @PutMapping("/update/{bookingId}")
    public ResponseEntity<ModifyBookingResponse> updateDetails(@Valid @RequestBody ModifyBookingRequest modifyBookingRequest, @PathVariable Long bookingId)
    {
        return new ResponseEntity<>(modifyBookingService.updateDetails(modifyBookingRequest,bookingId),HttpStatus.CREATED);
    }
}
