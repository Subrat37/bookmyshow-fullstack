package org.example.bookmyshow.repository;

import org.example.bookmyshow.entity.Screen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScreenRepository extends JpaRepository<Screen, Integer> {
    List<Screen> findByTheaterId(Integer TheaterId);
}
