package com.flightbooking.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.flightbooking.entities.Customer;
import com.flightbooking.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerservice;
	
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer)
	{
		Customer c=customerservice.addCustomer(customer);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest()
					.path("{customerId}")
					.buildAndExpand(customer.getCustomerId())
					.toUri();
		return ResponseEntity.created(location).body(c);
	}
	@PutMapping("/update")
	public Customer updateCustomer(@RequestBody Customer customer)
	{
		return customerservice.updateCustomer(customer);
	}
	@DeleteMapping("/delete")
	public Customer deleteCustomer(@RequestBody Customer customer)
	{
		return customerservice.deleteCustomer(customer);
	}
	@GetMapping("/getall")
	public List<Customer> viewallCustomers()
	{
		return customerservice.viewallCustomers();
	}
	
	
}
