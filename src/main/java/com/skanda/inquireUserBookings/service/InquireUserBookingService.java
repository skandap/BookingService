package com.skanda.inquireUserBookings.service;

import com.skanda.inquireUserBookings.entity.InquireUserBookingResponse;

public interface InquireUserBookingService {

    InquireUserBookingResponse fetchUserBookings(Long userId);
}
