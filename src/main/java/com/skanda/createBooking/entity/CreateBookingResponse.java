package com.skanda.createBooking.entity;


import com.skanda.util.entity.BookingStatus;
import com.skanda.util.entity.PaymentMode;
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
public class CreateBookingResponse {
    private Long bookingId;
    private UserSummary user;
    private TrainSummary train;
    private LocalDate travelDate;
    private Integer numberOfSeats;
    private Double totalFare;
    private PaymentMode paymentMode;
    private BookingStatus bookingStatus;
    private String classType;
    private LocalDateTime createdAt;
}
