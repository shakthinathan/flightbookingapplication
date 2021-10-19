package com.flightbooking.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightbooking.dao.BookingRepository;
import com.flightbooking.entities.Booking;

@Service
public class BookingServiceImpl implements BookingService{

	@Autowired
	BookingRepository repository;
	@Override
	public Booking addBooking(Booking booking) {
		// TODO Auto-generated method stub
		return repository.save(booking);
	}

	@Override
	public Booking updateBooking(Booking booking) {
		// TODO Auto-generated method stub
		Booking bk=repository.findById(booking.getBookingId()).orElseThrow(
				()->new EntityNotFoundException("No Booking is Done!"));
		bk.setBookingDate(booking.getBookingDate());
		return repository.save(bk);
	}

	@Override
	public Booking deleteBooking(Booking booking) {
		// TODO Auto-generated method stub
		Optional<Booking>optional=repository.findById(booking.getBookingId());
		if(optional.isPresent())
		{
			repository.delete(booking);
		}
		return optional.get();
	}

	@Override
	public List<Booking> viewallBookings() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	
}
