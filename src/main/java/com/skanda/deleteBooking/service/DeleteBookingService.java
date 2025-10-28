package com.skanda.deleteBooking.service;

import com.skanda.deleteBooking.entity.DeleteBookingResponse;

public interface DeleteBookingService {

    DeleteBookingResponse cancelBooking(String bookingId);
}
