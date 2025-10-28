package com.skanda.modifyBookings.entity;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ModifyBookingRequest {
    private LocalDate travelDate;
    private Integer numberOfSeats;
}
