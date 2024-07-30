package com.infosys.orm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.infosys.orm.entity.Employee;

import jakarta.transaction.Transactional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	List<Employee> findByEmpBandlevel(String bandlevel);
	List<Employee> findByEmpName(String empName);
	List<Employee> findByEmpSalaryBetween(double s1, double s2);
	List<Employee> findByEmpBandlevelAndDept(String bandlevel, String empDept);
	
	@Transactional
	@Query(value="UPDATE EMPLOYEE SET EMP_SALARY = EMP_SALARY * ? WHERE EMP_BANDLEVEL = ?", nativeQuery = true)
	@Modifying(clearAutomatically = true)
	public void updateEmpSalaryByBandlevel(Float inc, String Bandlevel);
}
