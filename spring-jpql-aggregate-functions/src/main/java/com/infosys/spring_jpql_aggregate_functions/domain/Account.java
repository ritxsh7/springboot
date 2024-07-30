package com.infosys.spring_jpql_aggregate_functions.domain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
	
	@Id
	@Column(name = "account_no")
	private Integer accountNo;
	@Column(name = "account_status")
	private String accountStatus;
	@Column(name = "account_type")
	private String accountType;
	private Integer balance;
	@Column(name = "opening_date")
	private LocalDate openingDate;
}
