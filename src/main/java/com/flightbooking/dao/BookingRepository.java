package com.flightbooking.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightbooking.entities.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Integer> {

}
