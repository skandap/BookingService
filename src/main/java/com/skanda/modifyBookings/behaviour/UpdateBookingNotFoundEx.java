package com.skanda.modifyBookings.behaviour;

public class UpdateBookingNotFoundEx extends RuntimeException {
    public UpdateBookingNotFoundEx(String msg) {
        super(msg);
    }
}
