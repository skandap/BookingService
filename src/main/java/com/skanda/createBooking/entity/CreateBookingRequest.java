package com.skanda.createBooking.entity;

import com.skanda.util.entity.PaymentMode;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class CreateBookingRequest {

    @NotNull
    private Long userId;
    @NotNull
    private Long trainId;
    @NotNull
    private LocalDate travelDate;
    @NotNull
    private Integer numberOfSeats;
    @NotNull
    private PaymentMode paymentMode;
    @NotNull
    private String classType;

}
