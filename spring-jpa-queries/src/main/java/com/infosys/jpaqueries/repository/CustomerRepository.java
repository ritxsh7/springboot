package com.infosys.jpaqueries.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosys.jpaqueries.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	List<Customer> findByEmail(String email);
	List<Customer> findByActiveTrue();
	List<Customer> findByCreditpointsGreaterThanEqual(int point);
	List<Customer> findByCreditpointsBetween(int point1, int point2);
	List<Customer> findByLastnameOrderByFirstnameAsc(String lastname);
	List<Customer> findByEmailAndContactNo(String email, String contactNo);
}