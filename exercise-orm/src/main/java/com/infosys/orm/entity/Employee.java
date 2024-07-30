package com.infosys.orm.entity;

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
public class Employee {
	
	@Id
	@Column(name = "emp_id")
	private Integer empId;
	@Column(name = "emp_name")
	private String empName;
	@Column(name = "emp_dept")
	private String dept;
	@Column(name = "base_location")
	private String baseLocation;
	
	private Integer address;
	
	@Column(name = "emp_salary")
	private Double empSalary;
	@Column(name = "emp_bandlevel")
	private String empBandlevel;
	@Column(name = "contact_no")
	private String contactNo;
	
	
	public static EmployeeDTO createEmployeeDTO(Employee emp) {
		return new EmployeeDTO(emp.getEmpId(), emp.getEmpName(), emp.getDept(), emp.getBaseLocation(), emp.getAddress(), emp.getEmpSalary(), emp.getEmpBandlevel(), emp.getContactNo());
	}
}
