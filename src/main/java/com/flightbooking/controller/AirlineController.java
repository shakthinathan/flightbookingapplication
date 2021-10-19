package com.flightbooking.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.flightbooking.entities.Airline;
import com.flightbooking.service.AirlineService;

@RestController
@RequestMapping("/api/v1.0/flight/airline")
public class AirlineController {

	@Autowired
	AirlineService airlineservice;
	
	@PostMapping("/addairline")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Airline> addAirline(@RequestBody Airline airline) 
	{
		
		Airline al=airlineservice.addAirline(airline);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest()
					.path("{airlineId}")
					.buildAndExpand(al.getAirlineId())
					.toUri();
		return ResponseEntity.created(location).body(al);
	}
	@PutMapping("/updateairline")
	public Airline updateAirline(@RequestBody Airline airline)
	{
		return airlineservice.updateAirline(airline);
	}
	@DeleteMapping("/deleteairline")
	public Airline deleteAirline(@RequestBody Airline airline)
	{
		return airlineservice.deleteAirline(airline);
	}
	@GetMapping("/getall")
	public List<Airline> viewallAirline()
	{
		return airlineservice.viewallAirline();
	}
}
