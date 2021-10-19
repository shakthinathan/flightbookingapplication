package com.flightbooking.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="airports")
@NoArgsConstructor
@ToString
public class Airport {

	@Id
	@Column(name="airport_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer airportId;
	
	@Column(name="airport_name")
	@NotNull
	private String airportName;
	
	@Column(name="airport_location")
	@NotNull
	private String airportLocation;
	
	@JsonIgnore
	@OneToMany(mappedBy="airport",fetch=FetchType.LAZY)
	private Set<Airplane>airplanes;

	public Integer getAirportId() {
		return airportId;
	}

	public void setAirportId(Integer airportId) {
		this.airportId = airportId;
	}

	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	public String getAirportLocation() {
		return airportLocation;
	}

	public void setAirportLocation(String airportLocation) {
		this.airportLocation = airportLocation;
	}

	public Set<Airplane> getAirplanes() {
		return airplanes;
	}

	public void setAirplanes(Set<Airplane> airplanes) {
		this.airplanes = airplanes;
	}
	
	
	
	
}
