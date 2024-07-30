package com.infosys.spring_jpql_aggregate_functions.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.infosys.spring_jpql_aggregate_functions.domain.Account;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository

public class AccountRepositoryImpl implements AccountRepository {
	
	@Autowired
	EntityManager entityManager;

	@Override
	public List<Account> getAllAccounts() {
		String GET_ALL_ACCOUNTS = "select a from Account a";
		Query query = entityManager.createQuery(GET_ALL_ACCOUNTS);
		List<Account> accountList = query.getResultList();
		return accountList;
	}

	@Override
	public Double avgBalance() {
		String GET_AVG_BALANCE = "select avg(a.balance) from Account a";
		Query query = entityManager.createQuery(GET_AVG_BALANCE);
		return (Double)query.getSingleResult();
	}

	@Override
	public Long totalBalance() {
		String GET_TOTAL_BALANCE = "select sum(a.balance) from Account a";
		Query query = entityManager.createQuery(GET_TOTAL_BALANCE);
		return (Long)query.getSingleResult();
	}

	@Override
	public Long getNoOfAccounts() {
		String GET_TOTAL_ACCOUNTS = "select count(a) from Account a";
		Query query = entityManager.createQuery(GET_TOTAL_ACCOUNTS);
		return (Long)query.getSingleResult();
	}

	@Override
	public Integer getMinBalance() {
		String GET_MIN_BALANCE = "select min(a.balance) from Account a";
		Query query = entityManager.createQuery(GET_MIN_BALANCE);
		return (Integer)query.getSingleResult();
	}

	@Override
	public Integer getMaxBalance() {
		String GET_MAX_BALANCE = "select max(a.balance) from Account a";
		Query query = entityManager.createQuery(GET_MAX_BALANCE);
		return (Integer)query.getSingleResult();
	}

}
