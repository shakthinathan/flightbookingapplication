package com.flightbooking.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.*;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.flightbooking.dao.UserRepository;
import com.flightbooking.entities.Role;
import com.flightbooking.entities.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository userrepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("In Authentication" + userName);
		User user=userrepository.findByUserName(userName);
		if(user!=null)
		{
			System.out.println("In Authentication-- if"+user.getUserName());
		return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(),createSimpleGrantedAuthorities(user.getRoles()));
		}
		else {
        	System.out.println("In Authentication+ ELSE PART" );
            throw new UsernameNotFoundException("User with "
                    + "user name "+ userName + " not found");
        }
	}
	private static List<SimpleGrantedAuthority> createSimpleGrantedAuthorities(Set<Role> roles){
		 List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		 authorities = roles.stream()
             .map(role -> new SimpleGrantedAuthority(role.getRoleName().name()))
             .collect(Collectors.toList());
		 return authorities;
	}
	
}
