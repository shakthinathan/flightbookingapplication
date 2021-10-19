package com.flightbooking;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.flightbooking.dao.AirlineRepository;
import com.flightbooking.entities.Airline;
import com.flightbooking.service.AirlineServiceImpl;

@ExtendWith(MockitoExtension.class)
public class AirlineServiceTest {

	@Mock
	private AirlineRepository repository;
	
	@InjectMocks
	private AirlineServiceImpl airlineserviceimpl;
	
	
	@Test
	void addAirline()
	{
		Airline airline=new Airline();
		airline.setAirlineId(2);
		airline.setAirlineName("AirIndia");
		airline.setAirlineAddress("32nd west street Nungambakkam Chennai");
		airline.setAirlineContact("8967534578");
		when(repository.save(airline)).thenReturn(airline);
		Airline savedairline=airlineserviceimpl.addAirline(airline);
		assertThat(savedairline).isNotNull();
		assertEquals("AirIndia",savedairline.getAirlineName());
	}
	@Test
	void getallAirline()
	{
		List<Airline>list=new ArrayList<>();
		Airline airline=new Airline();
		airline.setAirlineId(2);
		airline.setAirlineName("AirIndia");
		airline.setAirlineAddress("32nd west street Nungambakkam Chennai");
		airline.setAirlineContact("8967534578");
		list.add(airline);
		when(repository.findAll()).thenReturn(list);
		List<Airline>showallairlinedetails=airlineserviceimpl.viewallAirline();
		assertEquals(1,showallairlinedetails.size());
	}
}
