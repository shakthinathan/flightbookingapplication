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

import com.flightbooking.entities.Booking;
import com.flightbooking.service.BookingService;

@RestController
@RequestMapping("/flight/booking")
public class BookingController {
	
	@Autowired
	BookingService bookingservice;
	
	@PostMapping("/register")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Booking> addBooking(@RequestBody Booking booking)
	{
		Booking bk=bookingservice.addBooking(booking);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest()
				.path("{bookingId}")
				.buildAndExpand(bk.getBookingId())
				.toUri();
		return ResponseEntity.created(location).body(bk);
	}
	@PutMapping("/updatebooking")
	public Booking updateBooking(@RequestBody Booking booking)
	{
		return bookingservice.updateBooking(booking);
	}
	@DeleteMapping("/deletebooking")
	public Booking deleteBooking(@RequestBody Booking booking)
	{
		return bookingservice.deleteBooking(booking);
	}
	@GetMapping("/getall")
	public List<Booking>viewallBookings()
	{
		return bookingservice.viewallBookings();
	}

}
