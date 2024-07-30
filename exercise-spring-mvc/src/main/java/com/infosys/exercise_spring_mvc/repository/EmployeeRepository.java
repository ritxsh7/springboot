package com.infosys.exercise_spring_mvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.infosys.exercise_spring_mvc.entity.Employee;

import jakarta.transaction.Transactional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	public List<Employee> findByEmpidAndDesignation(Integer id, String desgination);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE EMPLOYEE SET EMPNAME = ?, DESIGNATION = ?, SALARY = ? WHERE EMPID = ?", nativeQuery = true)
	public void updateEmpById(String name, String designation, Integer salary, Integer id);
	
}
