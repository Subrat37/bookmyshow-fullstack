package org.example.bookmyshow.controller;

import lombok.RequiredArgsConstructor;
import org.example.bookmyshow.entity.Movie;
import org.example.bookmyshow.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @PostMapping("/add")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie){
        return ResponseEntity.ok(movieService.addMovie(movie));
    }
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovie(){
        return ResponseEntity.ok(movieService.getAllMovie());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Integer id){
        return ResponseEntity.ok(movieService.getMovieById(id));
    }
    @GetMapping("/search")
    public ResponseEntity<List<Movie>> searchMovies(@RequestParam String title){
        return ResponseEntity.ok(movieService.searchByTitle(title));
    }
    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<Movie>> getByLanguage(@PathVariable String genre){
        return ResponseEntity.ok(movieService.getByGenre(genre));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Integer id, @RequestBody Movie movie){
        return ResponseEntity.ok(movieService.updateMovie(id,movie));
    }
    @DeleteMapping("/delete/{id}")
    public void deleteMovie(@PathVariable Integer id){
        movieService.deleteMovie(id);
    }
}
