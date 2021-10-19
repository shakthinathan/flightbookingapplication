package com.flightbooking.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightbooking.entities.Airport;

@Repository
public interface AirportRepository extends JpaRepository<Airport,Integer> {

}
