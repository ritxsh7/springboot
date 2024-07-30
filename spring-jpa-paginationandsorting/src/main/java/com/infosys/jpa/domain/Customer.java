package com.infosys.jpa.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {
	
	@Id
	@Column(name="CUST_ID")
	private Integer custID;
	
	@Column(name="CUST_NAME")
	private String customerName;
	
	@Column(name="AGE")
	private Integer age;
	
	@Column(name="GENDER")
	private Character gnder;
	
	@Column(name="ADDRESS")
	private String address;
}
