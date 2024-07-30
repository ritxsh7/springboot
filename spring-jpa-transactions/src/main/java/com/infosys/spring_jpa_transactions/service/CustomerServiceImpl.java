package com.infosys.spring_jpa_transactions.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.spring_jpa_transactions.domain.Customer;
import com.infosys.spring_jpa_transactions.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepository customer;
	
	@Override
	public void updateCustomerById(int creditpoint, int id) {
		customer.updateCustomerById(creditpoint, id);
	}

	@Override
	public List<Customer> getCustomers() {
		return customer.findAll();
	}

	@Override
	public void deleteCustomer(int id) {
		customer.deleteCustomer(id);
	}

	@Override
	public List<Customer> getByEmail(String email) {
		return customer.findByEmail(email);
	}

	@Override
	public List<Customer> getCustomerByCity(String city) {
		return customer.findCustomerByCity(city);
	}

}
