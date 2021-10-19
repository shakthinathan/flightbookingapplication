package com.flightbooking.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightbooking.dao.RoleRepository;
import com.flightbooking.dao.UserRepository;
import com.flightbooking.entities.Role;
import com.flightbooking.entities.Roles;
import com.flightbooking.entities.User;
import com.flightbooking.model.SignUpRequest;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserRepository userrepository;
	
	@Autowired
	RoleRepository rolerepository;
	
	@Autowired
	PasswordEncoder encoder;
	
	@PostMapping("/signup")
	public ResponseEntity<?>UserSignup(@RequestBody SignUpRequest signuprequest)
	{
		if(userrepository.existsByUserName(signuprequest.getUserName()))
		{
			return ResponseEntity.badRequest().body("Username is already taken");
		}
		User user=new User();
		Set<Role>roles=new HashSet<>();
		user.setUserName(signuprequest.getUserName());
		user.setPassword(encoder.encode(signuprequest.getPassword()));
		
		String[] roleArr = signuprequest.getRoles();
	    
	    if(roleArr == null) {
	      roles.add(rolerepository.findByRoleName(Roles.ROLE_USER).get());
	    }
	    for(String role: roleArr) {
	      switch(role) {
	        case "admin":
	          roles.add(rolerepository.findByRoleName(Roles.ROLE_ADMIN).get());
	          break;
	        case "user":
	          roles.add(rolerepository.findByRoleName(Roles.ROLE_USER).get());
	          break;  
	        default:
	          return ResponseEntity.badRequest().body("Specified role not found");
	      }
	    }
	    user.setRoles(roles);
	    userrepository.save(user);
	    return ResponseEntity.ok("User signed up successfully");
	}
	
	
}
