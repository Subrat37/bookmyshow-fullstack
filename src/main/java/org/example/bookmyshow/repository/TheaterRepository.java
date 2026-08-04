package org.example.bookmyshow.repository;

import org.example.bookmyshow.entity.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TheaterRepository extends JpaRepository<Theater,Integer> {
    List<Theater> findByCityId(Integer cityId);
}
