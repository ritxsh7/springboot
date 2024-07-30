package com.infosys.spring_rest_db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.infosys.spring_rest_db.entity.Customer;

import jakarta.transaction.Transactional;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value="UPDATE CUSTOMER SET CUST_NAME = ?, AGE = ?, GENDER = ? , ADDRESS = ? WHERE CUST_ID = ?", nativeQuery=true)
	public void updateCustomer(String name, Integer age, Character gender, String address, Integer custId);
	
}
