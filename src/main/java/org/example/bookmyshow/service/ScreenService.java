package org.example.bookmyshow.service;

import lombok.RequiredArgsConstructor;
import org.example.bookmyshow.entity.Screen;
import org.example.bookmyshow.entity.Theater;
import org.example.bookmyshow.repository.ScreenRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScreenService {
    private final ScreenRepository screenRepository;
    private final TheaterService theaterService;

    public Screen addScreen(Screen screen){
        return screenRepository.save(screen);
    }
    public List<Screen> getAllScreen(){
        return screenRepository.findAll();
    }
    public Screen getScreenById(Integer id){
        return screenRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Screen not found with id: "+id));
    }

    public List<Screen> getScreenByTheater(Integer theaterId){
        return screenRepository.findByTheaterId(theaterId);
    }
}
