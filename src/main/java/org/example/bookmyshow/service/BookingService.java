package org.example.bookmyshow.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.bookmyshow.dto.BookingRequest;
import org.example.bookmyshow.entity.Booking;
import org.example.bookmyshow.entity.Seat;
import org.example.bookmyshow.entity.Show;
import org.example.bookmyshow.entity.User;
import org.example.bookmyshow.enums.BookingStatus;
import org.example.bookmyshow.repository.BookingRepository;
import org.example.bookmyshow.repository.SeatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final BookingRepository bookingRepository;
    private final SeatRepository seatRepository;
    private final UserService userService;
    private final ShowService showService;

    @Transactional
    public Booking createBooking(BookingRequest request) {
        User user = userService.getUserById(request.getUserId());
        Show show = showService.getShowById(request.getShowId());

        //check if any of the requested seat are already booked.
        List<Integer> alreadyBookedSeat = bookingRepository.findBookedSeatIdsByShowId(show.getId());
        for (Integer seatId : request.getSeatIds()) {
            if (alreadyBookedSeat.contains(seatId)) {
                throw new RuntimeException("Seat with id " + seatId + " is already Booked");
            }
        }

        List<Seat> seats = seatRepository.findAllById(request.getSeatIds());
        if (seats.size() != request.getSeatIds().size()) {
            throw new RuntimeException("Some seats are Invalid");
        }

        double totalPrice = seats.size() * show.getTicketPrice();
        Booking booking = Booking.builder()
                .user(user)
                .show(show)
                .seats(seats)
                .totalPrice(totalPrice)
                .bookingStatus(BookingStatus.CONFIRMED)
                .build();

        return bookingRepository.save(booking);
    }

    public Booking getBookingById(Integer id){
        return bookingRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Booking not found with this id: "+id));
    }

    public List<Booking> getBookingByUser(Integer userId){
        return bookingRepository.findByUserId(userId);
    }
    @Transactional
    public Booking cancelBooking(Integer bookingId){
        Booking booking = getBookingById(bookingId);
        booking.setBookingStatus(BookingStatus.CANCELLED);
        return bookingRepository.save(booking);
    }

    public List<Seat> getAvailableSeats(Integer showId){
        Show show = showService.getShowById(showId);
        List<Seat> allSeat = seatRepository.findByScreenId(show.getScreen().getId());
        List<Integer> bookingSeatIds = bookingRepository.findBookedSeatIdsByShowId(showId);
        return allSeat.stream()
                .filter(seat -> !bookingSeatIds.contains(seat.getId()))
                .toList();
    }
}
