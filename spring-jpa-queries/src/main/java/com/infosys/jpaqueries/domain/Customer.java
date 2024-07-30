package com.infosys.jpaqueries.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
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
	@Column(name="address_id")
	private Integer addressId;
}
