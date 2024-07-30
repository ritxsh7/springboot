package com.infosys.microservices_department.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.microservices_department.entity.Department;
import com.infosys.microservices_department.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	private DepartmentRepository department;

	@Override
	public Department saveDepartment(Department dept) {
		return department.save(dept);
	}

	@Override
	public Department getById(Long id) {
		return department.findById(id).get();
	}

}
