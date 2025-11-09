package com.skanda.deleteBooking.behaviour;

public class BookingNotFoundEx extends RuntimeException {
    public BookingNotFoundEx(String msg) {
        super(msg);
    }
}
