package com.skanda.inquireUserBookings.service;

import com.skanda.inquireUserBookings.entity.InquireUserBookingResponse;

import java.util.List;

public interface InquireUserBookingService {

    InquireUserBookingResponse fetchUserBookings(Long userId);
}
