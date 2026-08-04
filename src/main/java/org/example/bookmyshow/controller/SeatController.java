package org.example.bookmyshow.controller;

import lombok.RequiredArgsConstructor;
import org.example.bookmyshow.dto.SeatRequest;
import org.example.bookmyshow.entity.Seat;
import org.example.bookmyshow.service.SeatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seats")
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequiredArgsConstructor
public class SeatController {
    private final SeatService seatService;

    @PostMapping("/add")
    public ResponseEntity<Seat> addSeat(@RequestBody Seat seat){
        return ResponseEntity.ok(seatService.addSeat(seat));
    }
    @GetMapping("/screen/{screenId}")
    public ResponseEntity<List<Seat>> getSeatByScreen(@PathVariable Integer screenId){
        return ResponseEntity.ok(seatService.getSeatByScreen(screenId));
    }
    @GetMapping("{id}")
    public ResponseEntity<Seat> getSeatById(@PathVariable Integer id){
        return ResponseEntity.ok(seatService.getSeatById(id));
    }
}
