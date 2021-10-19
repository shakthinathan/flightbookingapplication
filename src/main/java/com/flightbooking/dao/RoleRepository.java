package com.flightbooking.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightbooking.entities.Role;
import com.flightbooking.entities.Roles;

public interface RoleRepository extends JpaRepository<Role,Integer> {

	Optional<Role> findByRoleName(Roles role);
}
