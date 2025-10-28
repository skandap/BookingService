package com.skanda.createBooking.entity;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class CreateBookingRequest {

    private Long userId;
    private Long trainId;
    private LocalDate travelDate;
    private Integer numberOfSeats;
    private String paymentMode;
    private String classType;

}
