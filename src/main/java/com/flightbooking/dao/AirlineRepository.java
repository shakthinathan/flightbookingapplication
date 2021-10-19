package com.flightbooking.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightbooking.entities.Airline;

@Repository
public interface AirlineRepository extends JpaRepository<Airline,Integer> {

	
}
