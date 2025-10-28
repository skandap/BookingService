package com.skanda.inquireBookingList.controller;

import com.skanda.inquireBookingList.entity.InquireBookingListResponse;
import com.skanda.inquireBookingList.service.InquireBookingListServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("bookings")
public class InquireBookingListController {

    @Autowired
    public InquireBookingListServiceImpl inquireBookingListService;

    @GetMapping("/bookings")
    public ResponseEntity<List<InquireBookingListResponse>> createBooking()
    {
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
