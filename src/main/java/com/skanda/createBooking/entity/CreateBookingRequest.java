package com.skanda.createBooking.entity;

import com.skanda.util.entity.enums.ClassType;
import com.skanda.util.entity.enums.PaymentMode;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class CreateBookingRequest {

    @NotNull(message = "User ID is mandatory")
    @Positive(message = "User ID must be positive")
    private Long userId;

    @NotNull(message = "Train ID is mandatory")
    @Positive(message = "Train ID must be positive")
    private Long trainId;

    @NotNull(message = "Travel date is required")
    @Future(message = "Travel date must be in the future")
    private LocalDate travelDate;

    @NotNull(message = "Number of seats is required")
    @Min(value = 1, message = "Minimum 1 seat required")
    @Positive
    private Integer numberOfSeats;

    @NotNull(message = "Payment mode is required")
    private PaymentMode paymentMode;

    @NotNull(message = "Class type is required")
    private ClassType classType;
}
