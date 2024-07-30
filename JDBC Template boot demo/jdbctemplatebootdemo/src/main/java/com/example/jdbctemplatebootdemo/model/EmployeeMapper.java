package com.example.jdbctemplatebootdemo.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee employee = new Employee();
		
		employee.setEmpId(rs.getInt("empid"));
		employee.setEmpName(rs.getString("empname"));
		employee.setEmpDesignation(rs.getString("empdesignation"));
		employee.setEmpSalary(rs.getInt("empsalary"));
		
		return employee;
	}
	
}
