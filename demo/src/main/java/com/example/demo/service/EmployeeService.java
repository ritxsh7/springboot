package com.example.demo.service;

import java.util.List;

import com.example.demo.Entity.EmployeeDTO;

public interface EmployeeService {
	public List<EmployeeDTO> list();
	public void insert(EmployeeDTO emp);
	public int remove(Integer id);
	public void update(Integer id, String Name);
}
