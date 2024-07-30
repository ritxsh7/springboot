package com.infosys.spring_jpa_transactions.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.spring_jpa_transactions.domain.Loan;
import com.infosys.spring_jpa_transactions.repository.LoanRepository;


@Service
public class LoanServiceImpl implements LoanService{

	@Autowired
	LoanRepository loan;
	
	@Override
	public List<Loan> getByCustomerName(String name) {
		return loan.findByCustomerName(name);
	}
	
}
