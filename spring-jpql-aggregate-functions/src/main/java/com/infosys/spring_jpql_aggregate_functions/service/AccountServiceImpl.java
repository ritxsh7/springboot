package com.infosys.spring_jpql_aggregate_functions.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.spring_jpql_aggregate_functions.domain.Account;
import com.infosys.spring_jpql_aggregate_functions.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	AccountRepository account;
	
	@Override
	public List<Account> getAllAccounts() {
		return account.getAllAccounts();
	}

	@Override
	public Double avgBalance() {
		return account.avgBalance();
	}

	@Override
	public Long totalBalance() {
		return account.totalBalance();
	}

	@Override
	public Long getNoOfAccounts() {
		return account.getNoOfAccounts();
	}

	@Override
	public Integer getMinBalance() {
		return account.getMinBalance();
	}

	@Override
	public Integer getMaxBalance() {
		return account.getMaxBalance();
	}

}
