package com.flightbooking;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.flightbooking.dao.BookingRepository;
import com.flightbooking.dao.FlightRepository;
import com.flightbooking.entities.Booking;
import com.flightbooking.entities.Flight;
import com.flightbooking.service.BookingServiceImpl;
import com.flightbooking.service.FlightServiceImpl;
import java.util.*;

@ExtendWith(MockitoExtension.class)
public class FlightServiceTest {

	@Mock
	private FlightRepository flightrepository;
	
	@Mock 
	BookingRepository bookingrepository;
	
	@InjectMocks
	private FlightServiceImpl flightserviceimpl;
	
	@InjectMocks
	private BookingServiceImpl bookingserviceimpl;
	
	@Test
	void addFlight()
	{
		Flight flight=new Flight();
		flight.setFlightId(4);
		flight.setFlightCode("B735");
		flight.setCapacity(500);
		flight.setAvailableseat(100);
		flight.setFare((float) 2500.00);
		when(flightrepository.save(flight)).thenReturn(flight);
		Flight savedflight=flightserviceimpl.addFlight(flight);
		assertThat(savedflight).isNotNull();
		assertEquals("B735",savedflight.getFlightCode());
	}
	@Test
	void addBooking()
	{
		Booking booking=new Booking();
		booking.setBookingId(1);
		booking.setBookingDate(java.time.LocalDateTime.of(2021,10,4,15,46,59,331));
		when(bookingrepository.save(booking)).thenReturn(booking);
		Booking savedbooking=bookingserviceimpl.addBooking(booking);
		assertThat(savedbooking).isNotNull();
	}
	@Test
	void viewallbookingdetails()
	{
		List<Booking>list=new ArrayList<>();
		Booking book=new Booking();
		book.setBookingId(1);
		book.setBookingDate(java.time.LocalDateTime.of(2021,10,4,15,46,59,331));
		list.add(book);
		book.setBookingId(2);
		book.setBookingDate(java.time.LocalDateTime.of(2021,10,6,16,20,39,234));
		list.add(book);
		when(bookingrepository.findAll()).thenReturn(list);
		List<Booking>showbookingdetails=bookingserviceimpl.viewallBookings();
		assertEquals(2,showbookingdetails.size());
		
		
	}
	
}
