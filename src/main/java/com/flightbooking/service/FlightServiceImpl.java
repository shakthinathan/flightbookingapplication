package com.flightbooking.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightbooking.dao.FlightRepository;
import com.flightbooking.entities.Flight;

@Service
public class FlightServiceImpl implements FlightService{

	@Autowired
	FlightRepository repository;
	
	@Override
	public Flight addFlight(Flight flight) {
		// TODO Auto-generated method stub
		return repository.save(flight);
	}

	@Override
	public Flight updateFlight(Flight flight) {
		// TODO Auto-generated method stub
		Flight fl=repository.findById(flight.getFlightId()).orElseThrow(
				()->new EntityNotFoundException("No flight is there for boarding!"));
		fl.setFlightCode(flight.getFlightCode());
		return repository.save(fl);
	}

	@Override
	public Flight deleteFlight(Flight flight) {
		// TODO Auto-generated method stub
		Optional<Flight>optional=repository.findById(flight.getFlightId());
		if(optional.isPresent())
		{
			repository.delete(flight);
		}
		return optional.get();
	}

	@Override
	public List<Flight> viewallflightdetails(String flightCode) {
		// TODO Auto-generated method stub
		return repository.viewallflightdetails(flightCode);
	}

	
}
