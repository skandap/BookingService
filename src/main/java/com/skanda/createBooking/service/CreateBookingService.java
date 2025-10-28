package com.skanda.createBooking.service;

import com.skanda.createBooking.entity.CreateBookingRequest;
import com.skanda.createBooking.entity.CreateBookingResponse;

public interface CreateBookingService {

    CreateBookingResponse bookTrain(CreateBookingRequest createBookingRequest);
}
