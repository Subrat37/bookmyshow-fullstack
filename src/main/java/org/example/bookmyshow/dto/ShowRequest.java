package org.example.bookmyshow.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShowRequest {
    private Integer movieId;
    private Integer screenId;
    private LocalDate showDate;
    private LocalDate startDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private Double ticketPrice;

}
