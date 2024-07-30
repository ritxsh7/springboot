package com.infosys.orm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

	private Integer empId;
	private String empName;
	private String dept;
	private String baseLocation;
	private Integer address;
	private Double empSalary;
	private String empBandlevel;
	private String contactNo;
	
	public static Employee createEmployee(EmployeeDTO empDTO) {
		Employee emp = new Employee();
		emp.setEmpId(empDTO.getEmpId());
		emp.setEmpName(empDTO.getEmpName());
		emp.setDept(empDTO.getDept());
		emp.setBaseLocation(empDTO.getBaseLocation());
		emp.setAddress(empDTO.getAddress());
		emp.setEmpSalary(empDTO.getEmpSalary());
		emp.setEmpBandlevel(empDTO.getEmpBandlevel());
		emp.setContactNo(empDTO.getContactNo());
		return emp;
	}
}
