package com.flightbooking.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.flightbooking.entities.Airplane;
import com.flightbooking.service.AirplaneService;

@RestController
@RequestMapping("/api/v1.0/flight")
public class AirplaneController {

	@Autowired
	AirplaneService airplaneservice;
	
	@PostMapping("/addairplane")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Airplane> addAirplane(@RequestBody Airplane airplane) {
		Airplane pl=airplaneservice.addAirplane(airplane);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest()
					.path("{airplaneid}")
					.buildAndExpand(pl.getAirplaneId())
					.toUri();
		return ResponseEntity.created(location).body(pl);
	}
	@PutMapping("/updateairplane")
	public Airplane updateAirplane(@RequestBody Airplane airplane) 
	{
		return airplaneservice.updateAirplane(airplane);
	}
	@DeleteMapping("/deleteairplane")
	public Airplane deleteAirplane(@RequestBody Airplane airline)
	{
		return airplaneservice.deleteAirplane(airline);
	}
	@GetMapping("/info/{airplaneId}")
	public List<Airplane> viewallAirplaneById(@PathVariable Integer airplaneId)
	{
		return airplaneservice.viewallAirplaneById(airplaneId);
	}
}
