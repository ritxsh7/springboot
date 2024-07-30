package com.example.demo.Entity;

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
	
	@Column(name="ID")
	@Id
	private int EMP_ID;
	private String FIRSTNAME;
	private String LASTNAME;
	private Float EMP_SALARY;
	
	public static EmployeeDTO prepareDTO(Employee employeeEntity) {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setEMP_ID(employeeEntity.getEMP_ID());
		employeeDTO.setFIRSTNAME(employeeEntity.getFIRSTNAME());
		employeeDTO.setLASTNAME(employeeEntity.getLASTNAME());
		employeeDTO.setEMP_SALARY(employeeEntity.getEMP_SALARY());
		return employeeDTO;
	}
}
