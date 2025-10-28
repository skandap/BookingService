package com.skanda.util.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name="booking_service")
public class CreateBookingEntity {

    @Id
    private Long bookingId;

    private Long userId; // fetched from UserService
    private Long trainId; // fetched from TrainService

    private String bookingStatus; // CONFIRMED, CANCELLED, PENDING
    private LocalDate travelDate;
    private Integer numberOfSeats;
    private Double totalFare;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
