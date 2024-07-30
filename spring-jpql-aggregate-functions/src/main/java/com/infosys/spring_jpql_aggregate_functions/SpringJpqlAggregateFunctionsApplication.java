package com.infosys.spring_jpql_aggregate_functions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.infosys.spring_jpql_aggregate_functions.domain.Account;
import com.infosys.spring_jpql_aggregate_functions.service.AccountService;

@SpringBootApplication
public class SpringJpqlAggregateFunctionsApplication implements CommandLineRunner{

	
	@Autowired
	AccountService accountService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringJpqlAggregateFunctionsApplication.class, args);
	}
	
//	LIST ALL ACCOUNTS
	public void getAllAccounts() {
		List<Account> accountsList = accountService.getAllAccounts();
		for(Account account : accountsList) {
			System.out.println(account);
		}
	}
	
	
//	AVERAGE BALANCE
	public void getAvgBalance() {
		System.out.println("Average balance = " + accountService.avgBalance());
	}

//	TOTAL BALANCE
	public void getTotalBalance() {
		System.out.println("Total balance = " + accountService.totalBalance());
	}
	
//	TOTAL NO OF ACCOUNTS
	public void getTotalAccounts() {
		System.out.println("Total number of accounts = " + accountService.getNoOfAccounts());
	}
	
	
//	MIN BALANCE
	public void getMinBalance() {
		System.out.println("Minimum Balance = " + accountService.getMinBalance());
	}
	
//	MAX BALANCE
	public void getMaxBalance() {
		System.out.println("Maximum Balance = " + accountService.getMaxBalance());
	}
	
	@Override
	public void run(String... args) throws Exception {
//		getAllAccounts();
		getAvgBalance();
		getTotalBalance();
		getTotalAccounts();
		getMinBalance();
		getMaxBalance();
	}

}
