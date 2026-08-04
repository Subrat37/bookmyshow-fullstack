package org.example.bookmyshow.service;

import lombok.RequiredArgsConstructor;
import org.example.bookmyshow.entity.Movie;
import org.example.bookmyshow.entity.Theater;
import org.example.bookmyshow.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;

    public Movie addMovie(Movie movie){
        return movieRepository.save(movie);
    }

    public List<Movie> getAllMovie(){
        return movieRepository.findAll();
    }

    public Movie getMovieById(Integer id){
        return movieRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Movie not found with id: "+id));
    }

    public List<Movie> searchByTitle(String title){
        return movieRepository.findByTitleContainingIgnoreCase(title);
    }

    public List<Movie> getByGenre(String genre){
        return movieRepository.findByGenre(genre);
    }

    public List<Movie> getByLanguage(String language){
        return movieRepository.findByLanguage(language);
    }

    public Movie updateMovie(Integer id,Movie movie){
        Movie exitingMovie = movieRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Movie not found by id: "+id));
        exitingMovie.setTitle(movie.getTitle());
        exitingMovie.setDescription(movie.getDescription());
        exitingMovie.setGenre(movie.getGenre());
        exitingMovie.setLanguage(movie.getLanguage());
        exitingMovie.setDurationMinutes(movie.getDurationMinutes());
        exitingMovie.setRating(movie.getRating());
        exitingMovie.setReleaseDate(movie.getReleaseDate());
        exitingMovie.setPosterUrl(movie.getPosterUrl());

        return movieRepository.save(exitingMovie);
    }

    public void deleteMovie(Integer id) {
        movieRepository.deleteById(id);

    }
}
