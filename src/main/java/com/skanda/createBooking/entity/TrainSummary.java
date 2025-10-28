package com.skanda.createBooking.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class TrainSummary {
    private Long trainId;
    private String trainName;
    private String trainNumber;
    private String sourceStation;
    private String destinationStation;
}
