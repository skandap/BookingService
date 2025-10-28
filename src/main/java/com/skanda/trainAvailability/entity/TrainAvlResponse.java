package com.skanda.trainAvailability.entity;

import lombok.*;

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
    private String travelDate;
    private Integer totalSeats;
    private Integer bookedSeats;
    private Integer availableSeats;
    private String status;
    private LocalDateTime lastUpdated;
}
