package com.infosys.microservices_department.service;

import com.infosys.microservices_department.entity.Department;

public interface DepartmentService {
	public Department saveDepartment(Department dept);
	public Department getById(Long id);
}
