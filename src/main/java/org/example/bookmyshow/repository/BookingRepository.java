package org.example.bookmyshow.repository;

import org.example.bookmyshow.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
    List<Booking> findByUserId(Integer userId);
    List<Booking> findByShowId(Integer showId);
    @Query("""
       SELECT s.id
       FROM Booking b
       JOIN b.seats s
       WHERE b.show.id = :showId
       AND b.bookingStatus = org.example.bookmyshow.enums.BookingStatus.CONFIRMED
       """)
    List<Integer> findBookedSeatIdsByShowId(@Param("showId") Integer showId);


}
