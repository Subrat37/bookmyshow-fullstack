package org.example.bookmyshow.service;

import lombok.RequiredArgsConstructor;
import org.example.bookmyshow.dto.TheaterRequest;
import org.example.bookmyshow.entity.City;
import org.example.bookmyshow.entity.Theater;
import org.example.bookmyshow.repository.TheaterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TheaterService {
    private final TheaterRepository theaterRepository;
    private final CityService cityService;

    public Theater addTheater(TheaterRequest request){
        City city = cityService.getCityById(request.getCityId());
        Theater theater = Theater.builder()
                .name(request.getName())
                .address(request.getAddress())
                .city(city)
                .build();
        return theaterRepository.save(theater);
    }

    public List<Theater> getAllTheater(){
        return theaterRepository.findAll();
    }

    public Theater getTheaterById(Integer id){
        return theaterRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Theater not found with id: "+id));
    }

    public List<Theater> getTheaterByCityId(Integer cityId){
        return theaterRepository.findByCityId(cityId);
    }
}
