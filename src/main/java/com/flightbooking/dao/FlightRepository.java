package com.flightbooking.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.flightbooking.entities.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Integer> {

	@Query("SELECT u from Flight u where u.flightCode=:flightCode")
	public List<Flight> viewallflightdetails(@Param(value="flightCode")String flightCode);
	
	
	
}
