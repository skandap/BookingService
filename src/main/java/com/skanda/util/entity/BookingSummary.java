package com.skanda.util.entity;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class BookingSummary {
    private Long bookingId;
    private TrainSummary train;
    private LocalDate travelDate;
    private Integer numberOfSeats;
    private Double totalFare;
    private String paymentMode;
    private String bookingStatus;
    private LocalDateTime createdAt;
}
