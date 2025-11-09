package com.skanda.modifyBookings.entity;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ModifyBookingRequest {
    @NotNull(message = "Travel date is mandatory")
    @Future(message = "Date must be future")
    private LocalDate travelDate;
    @NotNull(message = "Number of seats are mandatory")
    @Positive
    @Min(value = 1,message = "Minimun 1 seat is required for booking")
    private Integer numberOfSeats;
}
