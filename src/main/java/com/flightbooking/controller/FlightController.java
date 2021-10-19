package com.flightbooking.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.flightbooking.entities.Flight;
import com.flightbooking.service.FlightService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1.0/flight/airline/info")
public class FlightController {

	@Autowired
	FlightService Flightservice;
	
	@PostMapping("/addflight")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Flight> addFlight(@RequestBody Flight flight) 
	{
		Flight fl=Flightservice.addFlight(flight);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest()
				.path("{flightid}")
				.buildAndExpand(fl.getFlightId())
				.toUri();
		return ResponseEntity.created(location).body(fl);
	}
	@PutMapping("/updateflight")
	public Flight updateFlight(@RequestBody Flight flight)
	{
		return Flightservice.updateFlight(flight);
	}
	@DeleteMapping("/deleteflight")
	public Flight deleteFlight(@RequestBody Flight flight)
	{
		return Flightservice.deleteFlight(flight);
	}
	@GetMapping("/getall")
	public List<Flight> viewallflightdetails(String FlightCode)
	{
		return Flightservice.viewallflightdetails(FlightCode);
	}
	
}
