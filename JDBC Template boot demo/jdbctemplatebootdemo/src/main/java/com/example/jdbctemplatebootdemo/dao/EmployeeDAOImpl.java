package com.example.jdbctemplatebootdemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.jdbctemplatebootdemo.model.Employee;
import com.example.jdbctemplatebootdemo.model.EmployeeMapper;

@Component
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String SQL_INSERT_EMPLOYEE = "INSERT INTO EMPLOYEES VALUES(?,?,?,?)";
	private final String SQL_SELECT_EMPLOYEES = "SELECT * FROM EMPLOYEES";
	private final String SQL_FIND_EMPLOYEE_BY_ID = "SELECT * FROM EMPLOYEES WHERE EMPID = ?";
	private final String SQL_UPDATE_EMPLOYEE = "UPDATE EMPLOYEES SET EMPNAME = ?, EMPDESIGNATION = ? WHERE EMPID = ?";
	private final String SQL_DELETE_EMPLOYEE = "DELETE FROM EMPLOYEES WHERE EMPID = ?";
	
	
	@Override
	public List<Employee> displayEmployees() {
		return jdbcTemplate.query(SQL_SELECT_EMPLOYEES, new EmployeeMapper());
	}

	@Override
	public boolean insertEmployee(Employee employee) {
		return jdbcTemplate.update(SQL_INSERT_EMPLOYEE, employee.getEmpId(), employee.getEmpName(),
				employee.getEmpDesignation(), employee.getEmpSalary()) > 0;
	}

	@Override
	public Employee findEmployeeByID(int empID) {
		return jdbcTemplate.queryForObject(SQL_FIND_EMPLOYEE_BY_ID, new Object[] { empID }, new EmployeeMapper());
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		return jdbcTemplate.update(SQL_UPDATE_EMPLOYEE, employee.getEmpName(), employee.getEmpDesignation(), employee.getEmpId()) > 0;
	}

	@Override
	public boolean deleteEmployee(Employee employee) {
		return jdbcTemplate.update(SQL_DELETE_EMPLOYEE, employee.getEmpId()) > 0;
	}

}
