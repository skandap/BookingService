package com.skanda.inquireUserBookings.behaviour;

public class UserBookingNotFoundEx extends RuntimeException {
    public UserBookingNotFoundEx(String msg) {
        super(msg);
    }
}
