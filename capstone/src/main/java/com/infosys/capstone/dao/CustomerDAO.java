package com.infosys.capstone.dao;

import java.util.List;

import com.infosys.capstone.model.Customer;

public interface CustomerDAO {
	public List<Customer> displayCustomers();
	public Customer getCustomerFromFlightID(String Id);
	public boolean update(Customer customer);
}
