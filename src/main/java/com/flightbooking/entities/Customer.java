package com.flightbooking.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@Entity
@Table(name="customers")
public class Customer
{
	@Id
	@Column(name="customer_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer customerId;
	
	@NotNull
	@Column(name="first_name",nullable=false)
	private String firstName;
	
	@NotNull
	@Column(name="last_name",nullable=false)
	private String lastName;
	
	@NotNull
	@Size(min=2,max=20,message="Email should not be empty")
	@Column(name="email",nullable=false,unique=true)
	private String email;
	
	@JsonIgnore
	@OneToMany(mappedBy="customer")
	private Set<Booking>bookings;
	
	@JsonIgnore
	@ManyToMany(mappedBy="customers")
	private Set<Flight>flights;

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}

	public Set<Flight> getFlights() {
		return flights;
	}

	public void setFlights(Set<Flight> flights) {
		this.flights = flights;
	}
	
	
	
	
}
