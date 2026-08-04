package org.example.bookmyshow.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.bookmyshow.enums.SeatType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SeatRequest {
    private String seatNumber;
    private String row;
    private String col;
    private SeatType seatType;
    private Integer screenId;
}