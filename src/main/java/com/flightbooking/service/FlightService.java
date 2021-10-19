package com.flightbooking.service;

import java.util.List;

import com.flightbooking.entities.Flight;

public interface FlightService {

	public Flight addFlight(Flight flight);
	public Flight updateFlight(Flight flight);
	public Flight deleteFlight(Flight flight);
	public List<Flight> viewallflightdetails(String flightCode);
}
