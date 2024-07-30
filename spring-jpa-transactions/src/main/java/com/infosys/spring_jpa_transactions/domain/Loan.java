package com.infosys.spring_jpa_transactions.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Loan {
	@Id
	private Integer loan_id;
	private Integer amount;
	private String status;
	private String issue_date;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="cust_id", unique = true )
	private Customer customer;
	
}
