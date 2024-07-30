package com.infosys.spring_jpa_transactions.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@NamedQuery(name="Customer.findByEmail", query = "SELECT c FROM Customer c where c.email = ?1")
public class Customer {
	
	@Id
	@Column(name="cust_id")
	private Integer custId;
	private boolean active;
	private Integer creditpoints;
	private String firstname;
	private String lastname;
	private String email;
	@Column(name="contact_no")
	private String contactNo;
	
	
	//Referencing
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="address_id", unique=true)
	private Address address;
}
