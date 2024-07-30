package com.infosys.capstone.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	private String CustId;
	private String FirstName;
	private String LastName;
	private String Phone;
}
