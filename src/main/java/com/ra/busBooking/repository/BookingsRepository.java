package com.ra.busBooking.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ra.busBooking.model.Bookings;

@Repository
public interface BookingsRepository extends JpaRepository<Bookings, Integer> {

	List<Bookings> findByUserId(int userId);
	
}
