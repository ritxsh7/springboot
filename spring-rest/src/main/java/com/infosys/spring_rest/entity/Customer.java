package com.infosys.spring_rest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {
	Long phoneNo;
	String name;
	Integer age;
	String email;
	Character gender;
}
