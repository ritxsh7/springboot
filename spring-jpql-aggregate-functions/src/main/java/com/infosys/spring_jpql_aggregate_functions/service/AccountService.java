package com.infosys.spring_jpql_aggregate_functions.service;

import java.util.List;

import com.infosys.spring_jpql_aggregate_functions.domain.Account;

public interface AccountService {
	public List<Account> getAllAccounts();
	public Double avgBalance();
	public Long totalBalance();
	public Long getNoOfAccounts();
	public Integer getMinBalance();
	public Integer getMaxBalance();
}
