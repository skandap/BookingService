package com.skanda.trainAvailability.entity;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class TrainAvlResponse {
    private Long trainId;
    private String trainNumber;
    private String trainName;
    private String sourceStation;
    private String destinationStation;
    private LocalDate travelDate;
    private Integer totalSeats;
    private Integer bookedSeats;
    private Integer availableSeats;
    private String status; //"CLOSED","NOT_SCHEDULED","WAITLIST","CANCELLED","FULL","AVAILABLE"
    private LocalDateTime lastUpdated;
}
