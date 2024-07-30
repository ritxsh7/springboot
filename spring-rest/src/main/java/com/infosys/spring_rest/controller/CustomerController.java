package com.infosys.spring_rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.spring_rest.entity.Customer;
import com.infosys.spring_rest.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping(produces = "application/json")
	public List<Customer> fetchCustomers(){
		return customerService.fetchCustomers();
	}
	
	@GetMapping(value = "/{phoneNo}", produces = "application/json")
	public List<Customer> fetchCustomersByPhoneNo(@PathVariable("phoneNo") Long phoneNo){
		return customerService.getByPhoneNo(phoneNo);
	}
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<String> createCustomer(@RequestBody Customer cust) {
		String response = customerService.createCustomer(cust);
		return ResponseEntity.ok(response);
	}
	
	@PutMapping(value = "/{phoneNo}", consumes="application/json")
	public String updateCusomter(@PathVariable("phoneNo") Long phoneNo, @RequestBody Customer customer) {
		return customerService.updateCustomer(phoneNo, customer);
	}
	
	@DeleteMapping(value="/{phoneNo}")
	public String deleteCustomer(@PathVariable("phoneNo") Long phoneNo) {
		return customerService.deleteCustomer(phoneNo);
	}
	
}
