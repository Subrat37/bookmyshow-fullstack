package org.example.bookmyshow.controller;

import lombok.RequiredArgsConstructor;
import org.example.bookmyshow.entity.Screen;
import org.example.bookmyshow.entity.Seat;
import org.example.bookmyshow.service.ScreenService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/screens")
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequiredArgsConstructor
public class ScreenController {
    private final ScreenService screenService;

    @PostMapping("/add")
    public ResponseEntity<Screen> addScreen(@RequestBody Screen screen){
        return ResponseEntity.ok(screenService.addScreen(screen));
    }
    @GetMapping("{id}")
    public ResponseEntity<Screen> getScreenById(@PathVariable Integer id){
        return ResponseEntity.ok(screenService.getScreenById(id));
    }
    @GetMapping
    public ResponseEntity<List<Screen>> getAllScreen(){
        return ResponseEntity.ok(screenService.getAllScreen());
    }
    @GetMapping("/theater/{theaterId}")
    public ResponseEntity<List<Screen>> getScreenByTheater(@PathVariable Integer theaterId){
        return ResponseEntity.ok(screenService.getScreenByTheater(theaterId));
    }
}
