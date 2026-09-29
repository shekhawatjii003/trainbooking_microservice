package com.example.booking_service.controller;

import com.example.booking_service.entity.Passenger;
import com.example.booking_service.entity.PassengerStatus;
import com.example.booking_service.service.PassengerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/passengers")
public class PassengerController {

    private final PassengerService passengerService;

    public PassengerController(
            PassengerService passengerService
    ) {
        this.passengerService = passengerService;
    }

    @PostMapping
    public ResponseEntity<Passenger> createPassenger(
            @RequestBody Passenger passenger
    ) {

        return ResponseEntity.ok(
                passengerService.createPassenger(passenger)
        );
    }

    @GetMapping
    public ResponseEntity<List<Passenger>> getAllPassengers() {

        return ResponseEntity.ok(
                passengerService.getAllPassengers()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Passenger> getPassengerById(
            @PathVariable Long id
    ) {

        return ResponseEntity.ok(
                passengerService.getPassengerById(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Passenger> updatePassenger(
            @PathVariable Long id,
            @RequestBody Passenger passenger
    ) {

        return ResponseEntity.ok(
                passengerService.updatePassenger(
                        id,
                        passenger
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Passenger> cancelPassenger(
            @PathVariable Long id
    ) {

        return ResponseEntity.ok(
                passengerService.cancelPassenger(id)
        );
    }

    @GetMapping("/booking/{bookingId}")
    public ResponseEntity<List<Passenger>> getPassengersByBooking(
            @PathVariable Long bookingId
    ) {

        return ResponseEntity.ok(
                passengerService.getPassengersByBooking(
                        bookingId
                )
        );
    }

    @GetMapping("/booking/{bookingId}/status/{status}")
    public ResponseEntity<List<Passenger>>
    getPassengersByBookingAndStatus(
            @PathVariable Long bookingId,
            @PathVariable PassengerStatus status
    ) {

        return ResponseEntity.ok(
                passengerService
                        .getPassengersByBookingAndStatus(
                                bookingId,
                                status
                        )
        );
    }

    @GetMapping("/seat/{seatId}")
    public ResponseEntity<List<Passenger>> getPassengersBySeat(
            @PathVariable Long seatId
    ) {

        return ResponseEntity.ok(
                passengerService.getPassengersBySeat(
                        seatId
                )
        );
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Passenger>> getPassengersByStatus(
            @PathVariable PassengerStatus status
    ) {

        return ResponseEntity.ok(
                passengerService.getPassengersByStatus(
                        status
                )
        );
    }
}