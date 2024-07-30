package com.infosys.spring_jpa_transactions.service;

import java.util.List;

import com.infosys.spring_jpa_transactions.domain.Loan;

public interface LoanService {
	public List<Loan> getByCustomerName(String name);
}
