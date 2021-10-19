package com.flightbooking.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.*;
import java.time.*;
import javax.persistence.*;
@Entity
@Table(name="bookings")
public class Booking {

	@Id
	@Column(name="booking_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer bookingId;
	
	@Column(name="booking_date_time")
	@NotBlank(message="Booking date is mandatory")
	private LocalDateTime bookingDate;
	
	@Enumerated(EnumType.STRING)
	@Column(name="status")
	private Status status;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="flight_id",referencedColumnName="flight_id")
	private Flight flight;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="customer_id",referencedColumnName="customer_id")
	private Customer customer;

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public LocalDateTime getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDateTime bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
}
