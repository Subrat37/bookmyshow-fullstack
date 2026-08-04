package org.example.bookmyshow.service;

import lombok.RequiredArgsConstructor;
import org.example.bookmyshow.dto.ShowRequest;
import org.example.bookmyshow.entity.Movie;
import org.example.bookmyshow.entity.Screen;
import org.example.bookmyshow.entity.Show;
import org.example.bookmyshow.repository.ShowRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShowService {
    private final ShowRepository showRepository;
    private final MovieService movieService;
    private final ScreenService screenService;

    public Show addShow(ShowRequest request){
        Movie movie = movieService.getMovieById(request.getMovieId());
        Screen screen = screenService.getScreenById(request.getScreenId());
        Show show = Show.builder()
                .movie(movie)
                .screen(screen)
                .showDate(request.getShowDate())
                .startTime(request.getStartTime())
                .endTime(request.getEndTime())
                .ticketPrice(request.getTicketPrice())
                .build();
        return showRepository.save(show);
    }

    public List<Show> getAllShow(){
        return showRepository.findAll();
    }

    public Show getShowById(Integer id){
        return showRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Show not found with id: "+id));
    }

    public List<Show> getShowByMovie(Integer movieId){
        return showRepository.findByMovieId(movieId);
    }

    public List<Show> getShowByMovieAndDate(Integer movieId, LocalDate date){
        return showRepository.findByMovieIdAndShowDate(movieId,date);
    }

    public List<Show> getShowByScreenIdAndShowDate(Integer ScreenId, LocalDate ShowDate){
        return showRepository.findByScreenIdAndShowDate(ScreenId,ShowDate);
    }
}
