package com.infosys.jpql.domain;

import java.time.LocalDate;
import java.util.Date;

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
	@Column(name = "cust_id")
	private Integer custId;
	private Boolean active;
	private Integer creditpoints;
	private String firstname;
	private String lastname;
	private String email;
	@Column(name="contact_no")
	private String contactNo;
	@Column(name="date_of_birth")
	private LocalDate dateOfBirth;
	private String city;
	
	
}
