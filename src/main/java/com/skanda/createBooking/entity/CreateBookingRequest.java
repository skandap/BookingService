package com.skanda.createBooking.entity;

import com.skanda.util.entity.PaymentMode;
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
    private PaymentMode paymentMode;
    private String classType;

}
