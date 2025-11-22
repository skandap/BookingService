package com.skanda.inquireBookingList.entity;

import com.skanda.util.entity.ReferenceCodes;
import com.skanda.util.entity.TrainSummary;
import com.skanda.util.entity.UserSummary;
import lombok.*;

import java.sql.Ref;
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
    private ReferenceCodes paymentMode;
    private ReferenceCodes bookingStatus;
    private ReferenceCodes classType;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
