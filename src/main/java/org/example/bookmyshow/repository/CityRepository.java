package org.example.bookmyshow.repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.example.bookmyshow.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Integer> {
}
