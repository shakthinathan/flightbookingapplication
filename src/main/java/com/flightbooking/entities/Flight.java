package com.flightbooking.entities;

import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="flights")
public class Flight {

	@Id
	@Column(name="flight_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer flightId;
	
	@Column(name="flight_code",nullable=false)
	@NotBlank
	private String flightCode;
	
	@JoinColumn(name="schedule_id",referencedColumnName="schedule_id")
	@OneToOne(cascade=CascadeType.ALL)
	private Schedule schedule;
	
	@OneToMany(mappedBy="flight",cascade=CascadeType.ALL)
	private List<Booking>bookings;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="airplane_id",referencedColumnName="airplane_id")
	private Airplane airplane;
	
	@Column(name="fare")
	@NotBlank
	private Float fare;
	
	@Column(name="available_seat")
	@NotNull
	private Integer availableseat;
	
	@Column(name="capacity",nullable=false)
	@NotNull
	private Integer Capacity;
	
	@Column(name="status",nullable=false)
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name="customers_flights",
				inverseJoinColumns= {@JoinColumn(name="customer_id",referencedColumnName="customer_id")},
				joinColumns= {@JoinColumn(name="flight_id",referencedColumnName="flight_id")}
	)
	private Set<Customer>customers;
	

	public Flight(Integer flightId, String flightCode, Schedule schedule, List<Booking> bookings, Airplane airplane,
			Float fare, Integer availableseat, Integer capacity, Status status, Set<Customer> customers) {
		super();
		this.flightId = flightId;
		this.flightCode = flightCode;
		this.schedule = schedule;
		this.bookings = bookings;
		this.airplane = airplane;
		this.fare = fare;
		this.availableseat = availableseat;
		Capacity = capacity;
		this.status = status;
		this.customers = customers;
	}
	public Flight()
	{
		
	}

	public Integer getFlightId() {
		return flightId;
	}

	public void setFlightId(Integer flightId) {
		this.flightId = flightId;
	}

	public String getFlightCode() {
		return flightCode;
	}

	public void setFlightCode(String flightCode) {
		this.flightCode = flightCode;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public Airplane getAirplane() {
		return airplane;
	}

	public void setAirplane(Airplane airplane) {
		this.airplane = airplane;
	}

	public Float getFare() {
		return fare;
	}

	public void setFare(Float fare) {
		this.fare = fare;
	}

	public Integer getAvailableseat() {
		return availableseat;
	}

	public void setAvailableseat(Integer availableseat) {
		this.availableseat = availableseat;
	}

	public Integer getCapacity() {
		return Capacity;
	}

	public void setCapacity(Integer capacity) {
		Capacity = capacity;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Set<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}
	
	
	
}
