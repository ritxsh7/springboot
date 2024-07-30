package com.infosys.jpaqueries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.infosys.jpaqueries.domain.Customer;
import com.infosys.jpaqueries.service.CustomerService;

@SpringBootApplication
public class SpringJpaQueriesApplication implements CommandLineRunner{

	
	@Autowired
	CustomerService customerService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringJpaQueriesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
//		1. GET CUSTOMERS BY EMAIL
		System.out.println("CUSTOMERS BY EMAIL");
		Iterable<Customer> customersByEmail = customerService.getByEmail("ritesh@gmail.com");
		for(Customer c : customersByEmail) {
			System.out.println(c);
		}
		
//		2. GET CUSTOMERS BY ACTIVE
		System.out.println("CUSTOMERS BY ACTIVE");
		Iterable<Customer> customersByActive = customerService.getByActiveTrue();
		for(Customer c : customersByActive) {
			System.out.println(c);
		}
		
//		3. GET CUSTOMERS BY RANGE
		System.out.println("CUSTOMERS BY RANGE");
		Iterable<Customer> customersByRange = customerService.getByCreditpointsRange(15);
		for(Customer c : customersByRange) {
			System.out.println(c);
		}
		
//		4. GET CUSTOMERS BETWEEN 
		System.out.println("CUSTOMERS BETWEEN POINTS");
		Iterable<Customer> customersBetween = customerService.getByCreditpointsBetween(10, 18);
		for(Customer c : customersBetween) {
			System.out.println(c);
		}
		
//		5. GET CUSTOMERS BY LASTNAME AND ORDER BY FIRST NAME 
		System.out.println("CUSTOMERS BY LASTNAME AND ORDER BY FIRST NAME ");
		Iterable<Customer> customersLastName = customerService.getByLastnameOrderByFirstname("Patil");
		for(Customer c : customersLastName) {
			System.out.println(c);
		}
		
//		6. GET CUSTOMERS BY EMAIL AND CONTACT NO
		System.out.println("CUSTOMERS BY EMAIL AND CONTACT NO");
		Iterable<Customer> customersByEmailAndContact = customerService.getByEmailAndContactNo("parth@gmail.com", "987654321");
		for(Customer c : customersByEmailAndContact) {
			System.out.println(c);
		}
		
	}

}
