package com.flightbooking.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightbooking.dao.CustomerRepository;
import com.flightbooking.entities.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository repository;
	
	@Override
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return repository.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Customer c=repository.findById(customer.getCustomerId()).orElseThrow(
				()->new EntityNotFoundException("No Customer Found!"));
		c.setFirstName(customer.getFirstName());
		c.setLastName(customer.getLastName());
		c.setEmail(customer.getEmail());
		return repository.save(c);
	}

	@Override
	public Customer deleteCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Optional<Customer>optional=repository.findById(customer.getCustomerId());
		if(optional.isPresent())
		{
			repository.delete(customer);
		}
		return optional.get();
	}

	@Override
	public List<Customer> viewallCustomers() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	
}
