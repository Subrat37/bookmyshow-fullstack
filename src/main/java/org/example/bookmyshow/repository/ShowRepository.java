package org.example.bookmyshow.repository;

import org.example.bookmyshow.entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ShowRepository extends JpaRepository<Show,Integer> {
    List<Show> findByMovieId(Integer MovieId);
    List<Show> findByScreenId(Integer ScreenId);
    List<Show> findByMovieIdAndShowDate(Integer MovieId, LocalDate ShowDate);
    List<Show> findByScreenIdAndShowDate(Integer ScreenId, LocalDate ShowDate);
}
