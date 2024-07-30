package com.infosys.jpaqueries.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.jpaqueries.domain.Customer;
import com.infosys.jpaqueries.repository.CustomerRepository;


@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerRepository customer;

	@Override
	public Iterable<Customer> getByEmail(String email) {
		List<Customer> customersByEmail = customer.findByEmail(email);
		return customersByEmail;
	}

	@Override
	public Iterable<Customer> getByActiveTrue() {
		List<Customer> customersByActive = customer.findByActiveTrue();
		return customersByActive;
	}

	@Override
	public Iterable<Customer> getByCreditpointsRange(int point) {
		return customer.findByCreditpointsGreaterThanEqual(point);
	}

	@Override
	public Iterable<Customer> getByCreditpointsBetween(int point1, int point2) {
		return customer.findByCreditpointsBetween(point1, point2);
	}

	@Override
	public Iterable<Customer> getByLastnameOrderByFirstname(String lastname) {
		return customer.findByLastnameOrderByFirstnameAsc(lastname);
	}

	@Override
	public Iterable<Customer> getByEmailAndContactNo(String email, String contactNo) {
		return customer.findByEmailAndContactNo(email, contactNo);
	}

}
