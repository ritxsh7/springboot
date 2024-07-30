package com.infosys.jpql.service;

import java.util.List;

import com.infosys.jpql.domain.Customer;
import com.infosys.jpql.dto.CustomerDTO;


public interface CustomerService {
	public List<CustomerDTO> getCustomers();
	public List<Object[]> getCustomerFirstnameAndEmail();
	public List<Object[]> getCustomerFullName();
	public Customer getCustomerById(int id);
	public List<Customer> getFullCustomerDetails();
	public Integer updateCustomerCity(Integer id, String city);
	public Integer deleteCustomerByEmail(String email);
	public List<Object[]> getCustomerCountByCity(String city);
}
