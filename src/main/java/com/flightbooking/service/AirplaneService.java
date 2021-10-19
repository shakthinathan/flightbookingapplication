package com.flightbooking.service;

import java.util.List;

import com.flightbooking.entities.Airplane;



public interface AirplaneService {

	public List<Airplane> viewallAirplaneById(Integer airplaneId);
	public Airplane addAirplane(Airplane airplane);
	public Airplane updateAirplane(Airplane airplane);
	public Airplane deleteAirplane(Airplane airline);
}
