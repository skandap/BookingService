package com.skanda.inquireUserBookings.entity;

import com.skanda.util.entity.BookingSummary;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class InquireUserBookingResponse {
    private Long userId;
    private String userName;
    private String email;
    private List<BookingSummary> bookings;
}
