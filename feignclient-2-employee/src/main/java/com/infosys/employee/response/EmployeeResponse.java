package com.infosys.employee.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponse {
	private Integer empId;
	private String empName;
	private String email;
	private Integer age;
	private AddressResponse address;
}
