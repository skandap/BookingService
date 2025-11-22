package com.skanda.util.entity;

import com.skanda.util.client.ReferenceCodesClient;
import lombok.*;

import java.sql.Ref;
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
    private ReferenceCodes paymentMode;
    private ReferenceCodes bookingStatus;
    private ReferenceCodes classType;
    private LocalDateTime createdAt;
}
