package com.skanda.modifyBookings.entity;

import com.skanda.util.entity.ReferenceCodes;
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
public class ModifyBookingResponse {
    private Long bookingId;
    private UserSummary user;
    private TrainSummary train;
    private LocalDate oldTravelDate;
    private LocalDate newTravelDate;
    private Integer oldSeatCount;
    private Integer newSeatCount;
    private Double totalFare;
    private ReferenceCodes bookingStatus;
    private ReferenceCodes classType;
    private LocalDateTime updatedAt;
}
