package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Employee;
import com.example.demo.Entity.EmployeeDTO;
import com.example.demo.dao.EmployeeDAO;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeDAO employeeDAO;

	@Override
	public List<EmployeeDTO> list() {
		List<EmployeeDTO> empList = new ArrayList<>();
		List<Employee> empEntityList = employeeDAO.list();
		
		for(Employee employee : empEntityList) {
			EmployeeDTO empDTO = Employee.prepareDTO(employee);
			empList.add(empDTO);
		}
		
		return empList;
	}

	@Override
	public void insert(EmployeeDTO emp) {
		employeeDAO.insert(EmployeeDTO.prepareEmployeeEntity(emp));
	}

	@Override
	public int remove(Integer id) {
		return employeeDAO.remove(id);
		
	}

	@Override
	public void update(Integer id, String Name) {
		employeeDAO.update(id, Name);
	}

}
