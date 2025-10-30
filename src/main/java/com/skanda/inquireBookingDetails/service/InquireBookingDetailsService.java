package com.skanda.inquireBookingDetails.service;

import com.skanda.inquireBookingDetails.entity.InquireBookingDetailsResponse;

public interface InquireBookingDetailsService {

    InquireBookingDetailsResponse fetchBookingDetails(Long bookingId);
}
