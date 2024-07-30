package com.infosys.jpql.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.jpql.domain.Customer;
import com.infosys.jpql.dto.CustomerDTO;
import com.infosys.jpql.repository.CustomerRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerRepository customer;

	@Override
	public List<CustomerDTO> getCustomers() {
		return customer.getCustomers();
	}

	@Override
	public List<Object[]> getCustomerFirstnameAndEmail() {
		return customer.getCustomerFirstNameAndEmail();
	}

	@Override
	public List<Object[]> getCustomerFullName() {
		return customer.getCustomerFullName();
	}

	@Override
	public Customer getCustomerById(int id) {
		return customer.getCustomerById(id);
	}

	@Override
	public List<Customer> getFullCustomerDetails() {
		return customer.getFullCustomerDetails();
	}

	@Override
	public Integer updateCustomerCity(Integer id, String city) {
		return customer.updateCustomerCity(id, city);
	}

	@Override
	public Integer deleteCustomerByEmail(String email) {
		return customer.deleteCustomerByEmail(email);
	}

	@Override
	public List<Object[]> getCustomerCountByCity(String city) {
		return customer.getCustomerCountByCity(city);
	}

}
