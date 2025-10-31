package com.skanda.modifyBookings.service;

import com.skanda.modifyBookings.entity.ModifyBookingRequest;
import com.skanda.modifyBookings.entity.ModifyBookingResponse;

public interface ModifyBookingService {

    ModifyBookingResponse updateDetails(ModifyBookingRequest modifyBookingRequest,Long bookingId);
}
