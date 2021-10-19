package com.flightbooking.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightbooking.dao.AirplaneRepository;
import com.flightbooking.entities.Airplane;

@Service
public class AirplaneServiceImpl implements AirplaneService {

	@Autowired
	AirplaneRepository repository;
	
	

	@Override
	public Airplane addAirplane(Airplane airplane) {
		// TODO Auto-generated method stub
		return repository.save(airplane);
	}

	@Override
	public Airplane updateAirplane(Airplane airplane) {
		// TODO Auto-generated method stub
		Airplane pl=repository.findById(airplane.getAirplaneId()).orElseThrow(
				()->new EntityNotFoundException("No airplane is available"));
		pl.setAirplaneName(airplane.getAirplaneName());
		return repository.save(pl);
	}

	@Override
	public Airplane deleteAirplane(Airplane airplane) {
		// TODO Auto-generated method stub
		Optional<Airplane>optional=repository.findById(airplane.getAirplaneId());
		if(optional.isPresent())
		{
			repository.delete(airplane);
		}
		return optional.get();
	}

	@Override
	public List<Airplane> viewallAirplaneById(Integer airplaneId) {
		// TODO Auto-generated method stub
		return repository.viewallAirplaneById(airplaneId);
	}

}
