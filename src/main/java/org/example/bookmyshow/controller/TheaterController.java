package org.example.bookmyshow.controller;

import lombok.RequiredArgsConstructor;
import org.example.bookmyshow.dto.TheaterRequest;
import org.example.bookmyshow.entity.Theater;
import org.example.bookmyshow.service.TheaterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/theaters")
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequiredArgsConstructor
public class TheaterController {
    private final TheaterService theaterService;

    @PostMapping("/add")
    public ResponseEntity<Theater> addTheater(@RequestBody TheaterRequest request){
        return ResponseEntity.ok(theaterService.addTheater(request));
    }
    @GetMapping
    public ResponseEntity<List<Theater>> getAllTheater(){
        return ResponseEntity.ok(theaterService.getAllTheater());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Theater> getTheaterById(@PathVariable Integer id){
        return ResponseEntity.ok(theaterService.getTheaterById(id));
    }

    @GetMapping("/city/{cityId}")
    public ResponseEntity<List<Theater>> getTheaterByCityId(@PathVariable Integer cityId){
        return ResponseEntity.ok(theaterService.getTheaterByCityId(cityId));
    }
}
