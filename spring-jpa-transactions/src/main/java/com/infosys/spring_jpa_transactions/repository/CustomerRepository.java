package com.infosys.spring_jpa_transactions.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.infosys.spring_jpa_transactions.domain.Customer;

import jakarta.transaction.Transactional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE CUSTOMER SET CREDITPOINTS = ?" + " WHERE CUST_ID = ?", nativeQuery = true)

	public void updateCustomerById(int creditpoints, int id);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "DELETE FROM CUSTOMER WHERE CUST_ID = ?", nativeQuery = true)
	public void deleteCustomer(int id);

	List<Customer> findByEmail(String email);

	@Query(value = "SELECT * FROM CUSTOMER WHERE ADDRESS_ID IN ( SELECT ADDRESS_ID FROM ADDRESS WHERE CITY = ?)", nativeQuery = true)
	List<Customer> findCustomerByCity(String city);

}
