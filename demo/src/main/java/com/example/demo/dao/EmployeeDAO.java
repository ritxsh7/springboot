package com.example.demo.dao;

import java.util.List;

import com.example.demo.Entity.Employee;

public interface EmployeeDAO {
	public List<Employee> list();
	public void insert(Employee emp);
	public int remove(Integer id);
	public void update(Integer id, String lastname);
}
