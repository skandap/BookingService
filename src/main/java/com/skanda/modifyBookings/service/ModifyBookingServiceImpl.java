package com.skanda.modifyBookings.service;

import com.skanda.modifyBookings.entity.ModifyBookingRequest;
import com.skanda.modifyBookings.entity.ModifyBookingResponse;
import org.springframework.stereotype.Service;

@Service
public class ModifyBookingServiceImpl implements ModifyBookingService{
    @Override
    public ModifyBookingResponse updateDetails(ModifyBookingRequest modifyBookingRequest,String bookingId) {
        return null;
    }
}
