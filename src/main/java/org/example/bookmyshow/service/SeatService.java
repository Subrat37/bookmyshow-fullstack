package org.example.bookmyshow.service;

import lombok.RequiredArgsConstructor;
import org.example.bookmyshow.entity.Seat;
import org.example.bookmyshow.repository.SeatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SeatService {
    private final SeatRepository seatRepository;

    public Seat addSeat(Seat seat){
        return seatRepository.save(seat);
    }

    public List<Seat> getSeatByScreen(Integer screenId){
        return seatRepository.findByScreenId(screenId);
    }
    public Seat getSeatById(Integer id){
        return seatRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Seat not found with id: "+id));
    }
}
