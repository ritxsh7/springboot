package com.infosys.spring_rest.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.infosys.spring_rest.entity.Customer;

import jakarta.annotation.PostConstruct;

@Repository
public class CustomerRepository {
	
	List<Customer> customers = new ArrayList<>();

	@PostConstruct
	public void intializer() {
		Customer customer = new Customer();
		customer.setPhoneNo(987654321L);
		customer.setAge(20);
		customer.setName("Ritesh");
		customer.setGender('M');
		customer.setEmail("ritesh@gmail.com");
		customers.add(customer);
	}
	
	public List<Customer> fetchCustomers(){
		return customers;
	}
	
	public void createCustomer(Customer customer) {
		customers.add(customer);
	}
	
	public void deleteCustomer(Customer cust) {
		customers.remove(cust);
	}
	
}
