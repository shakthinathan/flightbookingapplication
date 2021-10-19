package com.flightbooking.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightbooking.entities.User;

public interface UserRepository extends JpaRepository<User,Integer>{

	public User findByUserName(String userName);
	public boolean existsByUserName(String userName);
}
