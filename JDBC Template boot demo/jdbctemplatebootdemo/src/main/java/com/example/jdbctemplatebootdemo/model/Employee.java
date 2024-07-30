package com.example.jdbctemplatebootdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	private Integer empId;
	private String empName;
	private String empDesignation;
	private Integer empSalary;
}
