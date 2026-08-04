package org.example.bookmyshow.controller;

import lombok.RequiredArgsConstructor;
import org.example.bookmyshow.entity.City;
import org.example.bookmyshow.service.CityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequiredArgsConstructor
public class CityController {
    private final CityService cityService;

    @PostMapping("/add")
    public ResponseEntity<City> addCity(@RequestBody City city){
        return ResponseEntity.ok(cityService.addCity(city));
    }
    @GetMapping
    public ResponseEntity<List<City>> getAllCity(){
        return ResponseEntity.ok(cityService.getAllCities());
    }
    @GetMapping("/{id}")
    public ResponseEntity<City> getCityById(@PathVariable Integer id){
        return ResponseEntity.ok(cityService.getCityById(id));
    }
}
