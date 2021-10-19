package com.flightbooking.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.time.*;
@Entity
@Table(name="schedule")
public class Schedule {

	@Id
	@Column(name="schedule_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer scheduleId;
	
	@Column(name="source_airport")
	@NotNull
	private String srcAirport;
	
	@Column(name="destination_airport")
	@NotNull
	private String dstnAirport;
	
	@Column(name="departure_date")
	@NotNull
	private LocalDateTime departureDateTime;
	
	@Column(name="arrival_date")
	@NotNull
	private LocalDateTime arrDateTime;

	public Integer getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(Integer scheduleId) {
		this.scheduleId = scheduleId;
	}
	public LocalDateTime getDepartureDateTime() {
		return departureDateTime;
	}

	public void setDepartureDateTime(LocalDateTime departureDateTime) {
		this.departureDateTime = departureDateTime;
	}

	public LocalDateTime getArrDateTime() {
		return arrDateTime;
	}

	public void setArrDateTime(LocalDateTime arrDateTime) {
		this.arrDateTime = arrDateTime;
	}

	public String getSrcAirport() {
		return srcAirport;
	}

	public void setSrcAirport(String srcAirport) {
		this.srcAirport = srcAirport;
	}

	public String getDstnAirport() {
		return dstnAirport;
	}

	public void setDstnAirport(String dstnAirport) {
		this.dstnAirport = dstnAirport;
	}
	
	
}
