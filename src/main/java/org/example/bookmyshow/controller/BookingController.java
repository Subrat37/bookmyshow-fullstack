package org.example.bookmyshow.controller;

import lombok.RequiredArgsConstructor;
import org.example.bookmyshow.dto.BookingRequest;
import org.example.bookmyshow.entity.Booking;
import org.example.bookmyshow.entity.Seat;
import org.example.bookmyshow.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequiredArgsConstructor
public class BookingController {
    private final BookingService bookingService;
    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody BookingRequest request){
        return ResponseEntity.ok(bookingService.createBooking(request));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Integer id){
        return ResponseEntity.ok(bookingService.getBookingById(id));
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Booking>> getBookingByUserId(@PathVariable Integer userId){
        return ResponseEntity.ok(bookingService.getBookingByUser(userId));
    }
    @PutMapping("/{id}/cancel")
    public ResponseEntity<Booking> cancelBooking(@PathVariable Integer id){
        return ResponseEntity.ok(bookingService.cancelBooking(id));
    }
    @GetMapping("/show/{showId}/available-seats")
    public ResponseEntity<List<Seat>> getAvailableSeats(@PathVariable Integer showId) {
        return ResponseEntity.ok(bookingService.getAvailableSeats(showId));
    }
}
