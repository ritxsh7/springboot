package com.infosys.orm.service;

import java.util.List;

import com.infosys.orm.entity.Employee;
import com.infosys.orm.entity.EmployeeDTO;

public interface EmployeeService {
	public void insertEmployee(EmployeeDTO empDTO);
	public EmployeeDTO searchEmployee(Integer id);
	public List<EmployeeDTO> viewEmployees();
	public void editEmployee(Integer id, String dept);
	public void removeEmployee(Integer id);
	public List<Employee> getByBandlevel(String bandlevel);
	public List<Employee> getByEmpName(String empName);
	public List<Employee> getByEmpSalaryBetween(double s1, double s2);
	public List<Employee> getByEmpBandlevelAndEmpDept(String bandlevel, String empDept);
	public void updateEmpSalaryByBandlevel(Float inc, String Bandlevel);
}
