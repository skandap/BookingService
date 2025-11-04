package com.skanda.inquireBookingDetails.entity;

import com.skanda.util.entity.TrainSummary;
import com.skanda.util.entity.UserSummary;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.mapstruct.control.NoComplexMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoComplexMapping
@AllArgsConstructor
@Builder
@ToString
public class InquireBookingDetailsResponse {
    private Long bookingId;
    private UserSummary user;
    private TrainSummary train;
    private LocalDate travelDate;
    private Integer numberOfSeats;
    private Double totalFare;
    private String paymentMode;
    private String bookingStatus;
    private String classType;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
