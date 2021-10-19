package com.flightbooking.service;

import java.util.List;

import com.flightbooking.entities.Customer;

public interface CustomerService {

	public Customer addCustomer(Customer customer);
	public Customer updateCustomer(Customer customer);
	public Customer deleteCustomer(Customer customer);
	public List<Customer> viewallCustomers();
	
}
