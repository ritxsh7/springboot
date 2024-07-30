package com.infosys.spring_jpa_transactions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.infosys.spring_jpa_transactions.domain.Customer;
import com.infosys.spring_jpa_transactions.domain.Loan;
import com.infosys.spring_jpa_transactions.service.CustomerService;
import com.infosys.spring_jpa_transactions.service.LoanService;

@SpringBootApplication
public class SpringJpaTransactionsApplication implements CommandLineRunner {

	@Autowired
	CustomerService customerService;
	@Autowired
	LoanService loanService;

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaTransactionsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		DISPLAY CUSTOMERS
//		System.out.println("Customer list");
//		List<Customer> customerList1 = customerService.getCustomers();
//		for (Customer cust : customerList1) {
//			System.out.println(cust);
//		}

//		UPDATE CUSTOMER BY THE ID
//		customerService.updateCustomerById(24, 103);
//		System.out.println("Updated successfully");

//		DELETE CUSTOMER
//		customerService.deleteCustomer(104);
//		System.out.println("Deleted successfully");

//		GET BY EMAIL BY NAMED QUERY
//		System.out.println("Customers by email");
//		List<Customer> custByEmail = customerService.getByEmail("parth@gmail.com");
//		for (Customer cust : custByEmail) {
//			System.out.println(cust);
//		}

//		GET BY EMAIL BY CITY
		System.out.println("Customer by city");
		List<Customer> custByCity = customerService.getCustomerByCity("Surat");
		for (Customer cust : custByCity) {
			System.out.println(cust);
		}

//		DISPLAY CUSTOMERS
//		System.out.println("Customer list");
//		List<Customer> customerList2 = customerService.getCustomers();
//		for (Customer cust : customerList2) {
//			System.out.println(cust);
//		}

//		FIND LOAN BY CUSTOMER NAME
		System.out.println("Loan by customer name");
		List<Loan> loanByName = loanService.getByCustomerName("Parth");
		for(Loan loan : loanByName) {
			System.out.println(loan);
		}
		
	}

}
