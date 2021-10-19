package com.flightbooking.service;

import java.util.List;

import com.flightbooking.entities.Airline;

public interface AirlineService {

	public List<Airline> viewallAirline();
	public Airline addAirline(Airline airline);
	public Airline updateAirline(Airline airline);
	public Airline deleteAirline(Airline airline);
}
