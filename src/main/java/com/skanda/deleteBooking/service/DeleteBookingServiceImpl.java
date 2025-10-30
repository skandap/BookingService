package com.skanda.deleteBooking.service;

import com.skanda.deleteBooking.entity.DeleteBookingResponse;
import com.skanda.util.entity.BookingEntity;
import com.skanda.util.repository.BookingRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Transactional
@Service
public class DeleteBookingServiceImpl implements DeleteBookingService {

    @Autowired
    public BookingRepository bookingRepository;

    @Override
    public DeleteBookingResponse cancelBooking(Long bookingId) {
        BookingEntity bookingEntity = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found for ID: " + bookingId));

        bookingRepository.delete(bookingEntity);

        return mapToResponse(bookingEntity);
    }

    private DeleteBookingResponse mapToResponse(BookingEntity bookingEntity) {
        return DeleteBookingResponse.builder()
                .bookingId(bookingEntity.getBookingId())
                .message("Booking cancelled successfully")
                .timestamp(LocalDateTime.now())
                .build();
    }
}
