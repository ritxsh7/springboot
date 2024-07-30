package com.infosys.jpql.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDTO {
	private Integer custId;
	private Boolean active;
	private Integer creditpoints;
	private String firstname;
	private String lastname;
	private String email;
	private String contactNo;
	private LocalDate date_of_birth;
	private String city;
}
