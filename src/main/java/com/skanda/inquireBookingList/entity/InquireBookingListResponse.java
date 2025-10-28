package com.skanda.inquireBookingList.entity;

import com.skanda.util.entity.TrainSummary;
import com.skanda.util.entity.UserSummary;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class InquireBookingListResponse {
    private Long bookingId;
    private UserSummary user;
    private TrainSummary train;
    private LocalDate travelDate;
    private Integer numberOfSeats;
    private Double totalFare;
    private String paymentMode;
    private String bookingStatus;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
