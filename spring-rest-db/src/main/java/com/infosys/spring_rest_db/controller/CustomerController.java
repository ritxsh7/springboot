package com.infosys.spring_rest_db.controller;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.spring_rest_db.entity.Customer;
import com.infosys.spring_rest_db.exceptions.CustomerErrorMessage;
import com.infosys.spring_rest_db.exceptions.CustomerException;
import com.infosys.spring_rest_db.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
//	1. GET ALL CUSTOMERS
	@GetMapping(produces = "application/json")
	public List<Customer> getAllCustomers(){
		return customerService.getAllCustomers();
	}
	
//	2. CREATE A CUSTOMER
	@PostMapping(consumes = "application/json")
	public ResponseEntity<String> createCustomer(@Valid @RequestBody Customer cust){
		String response = customerService.createCustomer(cust);
		return ResponseEntity.ok(response);
	}
	
//	3. GET CUSTOMER BY ID
	@GetMapping(path="/{id}", produces = "application/json")
	public ResponseEntity<Object> findById(@PathVariable("id") Integer id) throws CustomerException{
			Customer cust = customerService.findById(id);
			return new ResponseEntity<>(cust, HttpStatus.OK);			
	}
	
//	4. DELETE BY ID
	@DeleteMapping(path="/{id}")
	public String deleteCustomer(@PathVariable("id") Integer id) {
		customerService.deleteById(id);
		return "Customer deleted successfully";
	}
	
//	5. UPDATE BY ID
	@PutMapping(path="/{id}", consumes = "application/json")
	public String updateCustomer(@PathVariable("id") Integer id, @Valid @RequestBody Customer cust) throws CustomerException{
		Customer checkCustomer = customerService.findById(id);
		if(checkCustomer == null) 
			throw new CustomerException("Customer with Id" + id + " doesnt exist");
		customerService.updateCustomer(cust, id);
		return "Customer with ID " + id + " updated";
	}
	
//	6. GET BY NAME AND ID
	@GetMapping(path="/details", produces="application/json")
	public List<Customer> getByIdAndName(@RequestParam("id") Integer custId, @RequestParam("name") String name){
		return customerService.getCustomerByIdAndName(custId, name);
	}
	
}
