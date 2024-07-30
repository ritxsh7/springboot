package com.infosys.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.infosys.jpa.domain.Customer;
import com.infosys.jpa.repository.CustomerRepository;
import com.infosys.jpa.service.CustomerService;

@SpringBootApplication
public class SpringJpaPaginationandsortingApplication implements CommandLineRunner{
	
	@Autowired
	CustomerService customer;
	
	@Autowired
	CustomerRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaPaginationandsortingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
//		PAGINATION
		int k = (int) (repository.count()/2);
		
		for(int i = 0; i <= k ; i++) {
			Pageable page = PageRequest.of(i, 2);
			System.out.println("Records are : ");
			Iterable<Customer> customers = customer.findPage(page);
			for(Customer c: customers) {
				System.out.println(c);
			}
		}
		
//		SORTING
		System.out.println("Sorted records");
		Iterable<Customer> sortedRecords = customer.findAll(Sort.by(Sort.Direction.DESC, "customerName"));
		for(Customer c: sortedRecords) {
			System.out.println(c);
		}
	}

}
