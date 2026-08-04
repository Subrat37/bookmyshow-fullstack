package org.example.bookmyshow.repository;

import org.example.bookmyshow.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Integer> {
    List<Seat> findByScreenId(Integer ScreenId);
}
