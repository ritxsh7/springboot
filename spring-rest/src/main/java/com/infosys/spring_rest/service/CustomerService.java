package com.infosys.spring_rest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.spring_rest.entity.Customer;
import com.infosys.spring_rest.repository.CustomerRepository;


@Service
public class CustomerService {

	@Autowired
	CustomerRepository customer;
	
	public List<Customer> fetchCustomers(){
		return customer.fetchCustomers();
	}
	
	public String createCustomer(Customer cust) {
		customer.createCustomer(cust);
		return "Customer " + cust.getName() + " inserted.";
	}
	
	public List<Customer> getByPhoneNo(Long phoneNo) {
		List<Customer> customers = new ArrayList<>();
		List<Customer> customerDetails = new ArrayList<>();
		customers = customer.fetchCustomers();
		for(Customer cust : customers) {
			if(cust.getPhoneNo().equals(phoneNo)) {
				customerDetails.add(cust);
			}
		}
		return customerDetails;
	}
	
	public String updateCustomer(Long phoneNo, Customer cust) {
		
		for(Customer c : customer.fetchCustomers()) {
			if(c.getPhoneNo().equals(phoneNo)) {
				if(c.getName() != null) {
					c.setName(cust.getName());
				}
				if(c.getEmail() != null) {
					c.setEmail(cust.getEmail());
				}
				if(c.getGender() != null) {
					c.setGender(cust.getGender());
				}
			}
		}
		return "Customer " +cust.getName() +  " updated";
	}
	
	public String deleteCustomer(Long phoneNo) {
		System.out.println(phoneNo);
		for(Customer c : customer.fetchCustomers()) {
			if(c.getPhoneNo().equals(phoneNo)) {
				customer.deleteCustomer(c);
				return "Customer " + c.getName() + " deleted";
			}
		}
		return "Customer not found";
	}
	
}
