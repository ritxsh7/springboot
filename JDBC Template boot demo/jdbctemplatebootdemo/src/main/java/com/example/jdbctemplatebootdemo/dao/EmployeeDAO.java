package com.example.jdbctemplatebootdemo.dao;

import java.util.List;

import com.example.jdbctemplatebootdemo.model.Employee;

public interface EmployeeDAO {
	public List<Employee> displayEmployees();
	public boolean insertEmployee(Employee employee);
	public Employee findEmployeeByID(int empID);
	public boolean updateEmployee(Employee employee);
	public boolean deleteEmployee(Employee employee);
}
