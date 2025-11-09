package com.skanda.trainAvailability.behaviour;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class TrainGlobalExceptionHandler {

    @ExceptionHandler(TrainBookingNotFoundEx.class)
    public ResponseEntity<Map<String, Object>> handleValidationErrors(TrainBookingNotFoundEx ex) {

        Map<String, Object> errors = new HashMap<>();
        errors.put("status", HttpStatus.BAD_REQUEST.value());
        errors.put("errors", "Train_id_mot_found");
        errors.put("message", ex.getMessage());
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

}
