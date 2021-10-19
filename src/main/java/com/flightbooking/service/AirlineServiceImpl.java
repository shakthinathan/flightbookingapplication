package com.flightbooking.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightbooking.dao.AirlineRepository;
import com.flightbooking.entities.Airline;

@Service
public class AirlineServiceImpl implements AirlineService {

	@Autowired 
	AirlineRepository repository;
	
	@Override
	public Airline addAirline(Airline airline) {
		// TODO Auto-generated method stub
		return repository.save(airline);
	}

	@Override
	public Airline updateAirline(Airline airline) {
		// TODO Auto-generated method stub
		Airline al=repository.findById(airline.getAirlineId()).orElseThrow(
				()->new EntityNotFoundException("No airline is available"));
		al.setAirlineName(airline.getAirlineName());
		return repository.save(al);
	}

	@Override
	public Airline deleteAirline(Airline airline) {
		// TODO Auto-generated method stub
		Optional<Airline>optional=repository.findById(airline.getAirlineId());
		if(optional.isPresent())
		{
			repository.delete(airline);
		}
		return optional.get();
	}

	@Override
	public List<Airline> viewallAirline() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	
	
}
