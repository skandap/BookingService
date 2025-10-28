package com.skanda.trainAvailability.controller;

import com.skanda.trainAvailability.entity.TrainAvlResponse;
import com.skanda.trainAvailability.service.TrainAvlServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookings")
public class TrainAvlController {

    @Autowired
    public TrainAvlServiceImpl trainAvlService;

    @GetMapping("/availability/{trainId}")
    public ResponseEntity<TrainAvlResponse> trainAvlCheck(@PathVariable String trainId)
    {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
