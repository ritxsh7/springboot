package com.infosys.spring_jpa_transactions.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.infosys.spring_jpa_transactions.domain.Loan;

public interface LoanRepository extends JpaRepository<Loan, Integer>{
	
	@Query(value="SELECT * FROM LOAN WHERE LOAN_ID IN (SELECT LOAN_ID FROM CUSTOMER WHERE FIRSTNAME = ?)", nativeQuery = true)
	List<Loan> findByCustomerName(String name);
}
