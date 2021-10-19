package com.flightbooking.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.flightbooking.entities.Airplane;

@Repository
public interface AirplaneRepository extends JpaRepository<Airplane,Integer> {

	@Query("SELECT u from Airplane u where u.airplaneId=:airplaneId")
	public List<Airplane> viewallAirplaneById(@Param(value="airplaneId")Integer airplaneId);
}
