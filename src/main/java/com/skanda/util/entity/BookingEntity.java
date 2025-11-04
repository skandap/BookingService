package com.skanda.util.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name="booking_service")
public class BookingEntity {

    @Id
    private Long bookingId;

    private Long userId; // fetched from UserService
    private Long trainId; // fetched from TrainService

    private String bookingStatus; // CONFIRMED, CANCELLED, PENDING
    private LocalDate travelDate;
    private Integer numberOfSeats;
    private Double totalFare;
    private String classType;
    private String paymentMode;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    public void assignBookingId() {
        if (bookingId == null) {
            bookingId = Math.abs(UUID.randomUUID().getMostSignificantBits());
        }
    }
}
