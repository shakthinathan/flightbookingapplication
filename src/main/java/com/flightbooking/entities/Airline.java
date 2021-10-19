package com.flightbooking.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name="airlines")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Airline implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="airline_id")
	private Integer airlineId;
	
	@Column(name="airline_name")
	@NotNull
	private String airlineName;
	
	@Column(name="airline_contactno")
	@NotNull
	private String airlineContact;
	
	@Column(name="airline_address")
	@NotNull
	private String airlineAddress;
	@JsonIgnore
	@OneToMany(mappedBy="airline",fetch=FetchType.LAZY)
	private Set<Airplane>airplanes;
	
	
	public Integer getAirlineId() {
		return airlineId;
	}
	public void setAirlineId(Integer airlineId) {
		this.airlineId = airlineId;
	}
	public String getAirlineName() {
		return airlineName;
	}
	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}
	public String getAirlineContact() {
		return airlineContact;
	}
	public void setAirlineContact(String airlineContact) {
		this.airlineContact = airlineContact;
	}
	public String getAirlineAddress() {
		return airlineAddress;
	}
	public void setAirlineAddress(String airlineAddress) {
		this.airlineAddress = airlineAddress;
	}
	public Set<Airplane> getAirplanes() {
		return airplanes;
	}
	public void setAirplanes(Set<Airplane> airplanes) {
		this.airplanes = airplanes;
	}
	
	
	
	
	
}
