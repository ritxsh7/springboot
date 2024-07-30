package com.example.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeDTO {
	private int EMP_ID;
	private String FIRSTNAME;
	private String LASTNAME;
	private Float EMP_SALARY;

	public static Employee prepareEmployeeEntity(EmployeeDTO emp) {
		Employee employee = new Employee();

		employee.setEMP_ID(emp.getEMP_ID());
		employee.setFIRSTNAME(emp.getFIRSTNAME());
		employee.setLASTNAME(emp.getLASTNAME());
		employee.setEMP_SALARY(emp.getEMP_SALARY());
		return employee;
	}

	public EmployeeDTO() {
	}
}
