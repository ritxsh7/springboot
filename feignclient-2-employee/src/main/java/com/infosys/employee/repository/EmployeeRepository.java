package com.infosys.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosys.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
}
