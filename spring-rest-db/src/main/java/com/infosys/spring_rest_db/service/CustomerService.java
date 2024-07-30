package com.infosys.spring_rest_db.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.spring_rest_db.entity.Customer;
import com.infosys.spring_rest_db.exceptions.CustomerException;
import com.infosys.spring_rest_db.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customer;

	public List<Customer> getAllCustomers() {
		return customer.findAll();
	}

	public String createCustomer(Customer cust) {
		customer.save(cust);
		return "Customer " + cust.getCust_name() + " saved";
	}

	public Customer findById(Integer id) throws CustomerException{
		if(customer.findById(id).isPresent()) {
			return customer.findById(id).get();
		}
		throw new CustomerException("Customer with Id " + id + " is not present");
	}

	public void deleteById(Integer id) {
		customer.deleteById(id);
	}

	public void updateCustomer(Customer cust, Integer id) {

		customer.updateCustomer(cust.getCust_name(), cust.getAge(), cust.getGender(), cust.getAddress(), id);
	}

	public List<Customer> getCustomerByIdAndName(Integer id, String name) {
		List<Customer> customers = new ArrayList<Customer>();
		System.out.println(id + name);
		for (Customer cust : customer.findAll()) {
			System.out.println(cust);
			if (cust.getCust_id() == id && cust.getCust_name().equals(name)) {
				customers.add(cust);
			}
		}
		return customers;
	}
}
