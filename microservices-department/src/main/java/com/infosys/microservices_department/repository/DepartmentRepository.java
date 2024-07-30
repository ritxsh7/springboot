package com.infosys.microservices_department.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosys.microservices_department.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{
	
}
