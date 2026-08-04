package org.example.bookmyshow.controller;

import lombok.RequiredArgsConstructor;
import org.example.bookmyshow.dto.ShowRequest;
import org.example.bookmyshow.entity.Show;
import org.example.bookmyshow.service.ShowService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/shows")
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequiredArgsConstructor
public class ShowController {
    private final ShowService showService;

    @PostMapping("/add")
    public ResponseEntity<Show> addShow(@RequestBody ShowRequest request){
        return ResponseEntity.ok(showService.addShow(request));
    }
    @GetMapping
    public ResponseEntity<List<Show>> getAllShow(){
        return ResponseEntity.ok(showService.getAllShow());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Show> getShowById(@PathVariable Integer id){
        return ResponseEntity.ok(showService.getShowById(id));
    }

    @GetMapping("/movie/{movieId}")
    public ResponseEntity<List<Show>> getShowByMovie(@PathVariable Integer movieId){
        return ResponseEntity.ok(showService.getShowByMovie(movieId));
    }
    @GetMapping("/movie/{movieId}/date")
    public ResponseEntity<List<Show>> getShowByMovieAndDate
            (@PathVariable Integer movieId, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
        return ResponseEntity.ok(showService.getShowByMovieAndDate(movieId,date));
    }
}
