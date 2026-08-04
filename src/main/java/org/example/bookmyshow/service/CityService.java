package org.example.bookmyshow.service;

import lombok.RequiredArgsConstructor;
import org.example.bookmyshow.entity.City;
import org.example.bookmyshow.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService {
    private final CityRepository cityRepository;

    public City addCity(City city){
        return cityRepository.save(city);
    }

    public List<City> getAllCities(){
        return cityRepository.findAll();
    }

    public City getCityById(Integer id){
        return cityRepository.findById(id)
                .orElseThrow(()->new RuntimeException("City not found with id: "+id));
    }
}
