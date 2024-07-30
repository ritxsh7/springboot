package com.infosys.jpaqueries.service;

import java.util.List;

import com.infosys.jpaqueries.domain.Customer;

public interface CustomerService {
	public Iterable<Customer> getByEmail(String email);
	public Iterable<Customer> getByActiveTrue();
	public Iterable<Customer> getByCreditpointsRange(int point);
	public Iterable<Customer> getByCreditpointsBetween(int point1, int point2);
	public Iterable<Customer> getByLastnameOrderByFirstname(String lastname);
	public Iterable<Customer> getByEmailAndContactNo(String email, String contactNo);
}
