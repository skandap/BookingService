package com.skanda.deleteBooking.entity;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class DeleteBookingResponse {
    private Long bookingId;
    private String message;
    private LocalDateTime timestamp;

}
