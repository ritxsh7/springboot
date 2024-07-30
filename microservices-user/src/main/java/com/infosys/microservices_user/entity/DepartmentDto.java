package com.infosys.microservices_user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DepartmentDto {
	private Long deptId;
	private String deptName;
	private String deptAddress;
	private String deptCode;
}
