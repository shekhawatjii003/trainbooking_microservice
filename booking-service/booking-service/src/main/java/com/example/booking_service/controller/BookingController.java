package com.example.booking_service.controller;

import com.example.booking_service.entity.Booking;
import com.example.booking_service.entity.BookingStatus;
import com.example.booking_service.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(
            BookingService bookingService
    ) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public ResponseEntity<Booking> createBooking(
            @RequestBody Booking booking
    ) {

        return ResponseEntity.ok(
                bookingService.createBooking(booking)
        );
    }

    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings() {

        return ResponseEntity.ok(
                bookingService.getAllBookings()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(
            @PathVariable Long id
    ) {

        return ResponseEntity.ok(
                bookingService.getBookingById(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Booking> updateBooking(
            @PathVariable Long id,
            @RequestBody Booking booking
    ) {

        return ResponseEntity.ok(
                bookingService.updateBooking(
                        id,
                        booking
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Booking> cancelBooking(
            @PathVariable Long id
    ) {

        return ResponseEntity.ok(
                bookingService.cancelBooking(id)
        );
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Booking>> getBookingsByUser(
            @PathVariable Long userId
    ) {

        return ResponseEntity.ok(
                bookingService.getBookingsByUser(userId)
        );
    }

    @GetMapping("/journey/{journeyId}")
    public ResponseEntity<List<Booking>> getBookingsByJourney(
            @PathVariable Long journeyId
    ) {

        return ResponseEntity.ok(
                bookingService.getBookingsByJourney(journeyId)
        );
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Booking>> getBookingsByStatus(
            @PathVariable BookingStatus status
    ) {

        return ResponseEntity.ok(
                bookingService.getBookingsByStatus(status)
        );
    }

    @GetMapping("/user/{userId}/status/{status}")
    public ResponseEntity<List<Booking>> getBookingsByUserAndStatus(
            @PathVariable Long userId,
            @PathVariable BookingStatus status
    ) {

        return ResponseEntity.ok(
                bookingService.getBookingsByUserAndStatus(
                        userId,
                        status
                )
        );
    }

    @GetMapping("/journey/{journeyId}/status/{status}")
    public ResponseEntity<List<Booking>> getBookingsByJourneyAndStatus(
            @PathVariable Long journeyId,
            @PathVariable BookingStatus status
    ) {

        return ResponseEntity.ok(
                bookingService.getBookingsByJourneyAndStatus(
                        journeyId,
                        status
                )
        );
    }
}