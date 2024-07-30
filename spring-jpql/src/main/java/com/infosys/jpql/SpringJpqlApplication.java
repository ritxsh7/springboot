package com.infosys.jpql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.infosys.jpql.domain.Customer;
import com.infosys.jpql.dto.CustomerDTO;
import com.infosys.jpql.service.CustomerService;

@SpringBootApplication
public class SpringJpqlApplication implements CommandLineRunner{
	
	@Autowired
	CustomerService customerService;

	public static void main(String[] args) {
		SpringApplication.run(SpringJpqlApplication.class, args);
	}
	
//	LISTING ALL THE CUSTOMERS
	public void getCustomerDetails() {
		List<CustomerDTO> customersList = customerService.getCustomers();
		for(CustomerDTO c : customersList) {
			System.out.println(c);
		}
	}
	
	public void getCustomerFirstnameAndEmailDetails() {
		List<Object[]> customersList = customerService.getCustomerFirstnameAndEmail();
		for(Object[] c : customersList) {
			System.out.println("Name = " + c[0] + ", Email = " + c[1]);
		}
	}
	
	public void getCustomerFullName() {
		List<Object[]> customersList = customerService.getCustomerFullName();
		for(Object[] c : customersList) {
			System.out.println("Fullname = " + c[0] + " " +  c[1]);
		}
	}
	
	public void getCustomerById(int id) {
		System.out.println("Customer with ID = " + id);
		System.out.println(customerService.getCustomerById(id));
	}
	
	public void getFullCustomerDetails() {
		List<Customer> customersList = customerService.getFullCustomerDetails();
		for(Customer c : customersList) {
			System.out.println(c);
		}
	}
	
	public void updateCustomerCity(Integer id, String city) {
		if(customerService.updateCustomerCity(id, city) > 0) {
			System.out.println("Updated successfully");
		}
	}
	
	public void deleteCustomerByEmail(String email) {
		if(customerService.deleteCustomerByEmail(email) > 0) {
			System.out.println("Deleted successfully");
		}
	}
	
	public void getCustomerCountByCity(String city) {
		List<Object[]> customerCityList = customerService.getCustomerCountByCity(city);
		for(Object[] result : customerCityList) {
			System.out.println("City = " + result[0] + ", Count = " + result[1]);
		}
	}

	@Override
	public void run(String... args) throws Exception {
	
		getCustomerDetails();
//		getCustomerFirstnameAndEmailDetails();
//		getCustomerFullName();
//		getCustomerById(101);
//		getFullCustomerDetails();
//		updateCustomerCity(101, "Vadodara");
//		deleteCustomerByEmail("akshat@gmail.com");
		getCustomerCountByCity("Surat");
//		getCustomerDetails();
	}

}
