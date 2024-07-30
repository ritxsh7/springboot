package com.infosys.spring_jpa_transactions.service;

import java.util.List;

import com.infosys.spring_jpa_transactions.domain.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();
	public void updateCustomerById(int creditpoint, int id);
	public void deleteCustomer(int id);
	List<Customer> getByEmail(String email);
	public List<Customer> getCustomerByCity(String city);
}
