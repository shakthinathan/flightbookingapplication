package com.flightbooking.service;

import java.util.List;

import com.flightbooking.entities.Booking;

public interface BookingService {

	public Booking addBooking(Booking booking);
	public Booking updateBooking(Booking booking);
	public Booking deleteBooking(Booking booking);
	public List<Booking>viewallBookings();
}
