package com.skanda.inquireUserBookings.behaviour;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class UserGlobalExceptionHandler {

    @ExceptionHandler(UserBookingNotFoundEx.class)
    public ResponseEntity<Map<String, Object>> handleValidationErrors(UserBookingNotFoundEx ex) {

        Map<String, Object> errors = new HashMap<>();
        errors.put("status", HttpStatus.BAD_REQUEST.value());
        errors.put("error", "Booking_Not_Found");
        errors.put("message",ex.getMessage() );
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
