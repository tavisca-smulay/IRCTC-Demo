package com.trctc.app.repository;

import com.trctc.app.model.Booking;
import com.trctc.app.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
//    public List<Booking>

//    @Query("delete from booking b where b.")
//    Integer deleteByUserIdAndBookingId(@Param("userId") int userId,@Param("bookingId") int bookingId);

}
