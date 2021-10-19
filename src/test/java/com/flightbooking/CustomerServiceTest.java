package com.flightbooking;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.flightbooking.dao.CustomerRepository;
import com.flightbooking.entities.Customer;
import com.flightbooking.service.CustomerServiceImpl;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

	@Mock
	private CustomerRepository repository;
	
	@InjectMocks
	private CustomerServiceImpl customerserviceimpl;
	
	@Test
	@Order(2)
	void addCustomer()
	{
		Customer cust=new Customer();
		cust.setCustomerId(1);
		cust.setFirstName("Raghu");
		cust.setLastName("Ram");
		cust.setEmail("raghuram6@yahoo.com");
		when(repository.save(cust)).thenReturn(cust);
		Customer savedcust=customerserviceimpl.addCustomer(cust);
		assertThat(savedcust).isNotNull();
		assertEquals("Ram",savedcust.getLastName());
	}
	@Test
	void getallCustomers()
	{
		List<Customer>list=new ArrayList<>();
		Customer cust=new Customer();
		cust.setCustomerId(1);
		cust.setFirstName("Raghu");
		cust.setLastName("Ram");
		cust.setEmail("raghuram6@yahoo.com");
		list.add(cust);
		cust.setCustomerId(2);
		cust.setFirstName("prem");
		cust.setLastName("kumar");
		cust.setEmail("premkumar@gmail.com");
		list.add(cust);
		when(repository.findAll()).thenReturn(list);
		List<Customer>showallcustomerdetails=customerserviceimpl.viewallCustomers();
		assertEquals(2,showallcustomerdetails.size());
	}
//	@Test
//	void UpdateCustomer()
//	{
//		Customer customer =new Customer();
//		customer.setCustomerId(3);
//		customer.setFirstName("priya");
//		Customer newcustomer=new Customer();
//		newcustomer.setFirstName("Renu");
//		when(repository.findById(customer.getCustomerId())).thenReturn(Optional.of(customer));
//		customerserviceimpl.updateCustomer(newcustomer);
//		verify(repository).save(newcustomer);
//		verify(repository).findById(customer.getCustomerId());
//	}
}
