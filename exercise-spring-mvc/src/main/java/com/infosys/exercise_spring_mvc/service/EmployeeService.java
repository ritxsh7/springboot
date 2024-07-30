package com.infosys.exercise_spring_mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.exercise_spring_mvc.entity.Employee;
import com.infosys.exercise_spring_mvc.exception.EmployeeAlreadyExistsException;
import com.infosys.exercise_spring_mvc.exception.EmployeeNotFoundException;
import com.infosys.exercise_spring_mvc.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employee;
	
	public List<Employee> getAllEmployees(){
		return employee.findAll();
	}
	
	public Employee createEmployee(Employee emp) throws EmployeeAlreadyExistsException {
		if(employee.existsById(emp.getEmpid())) {
			throw new EmployeeAlreadyExistsException("Employee with ID " + emp.getEmpid() + " already exists");
		}
		return employee.save(emp);
	}
	
	public List<Employee> getByEmpidAndDesignation(Integer id, String designation){
		List<Employee> empList = employee.findByEmpidAndDesignation(id, designation);
		if(empList.isEmpty()) {
			throw new EmployeeNotFoundException("Employees don't exists for given data");
		}
		return empList;
	}
	
	public Employee getById(Integer id) {
		if(!employee.existsById(id)) {
			throw new EmployeeNotFoundException("No Employee exists with ID " + id);
		}
		return employee.findById(id).get();
	}
	
	public String updateById(Integer id, Employee emp) {
		if(!employee.existsById(id)) {
			throw new EmployeeNotFoundException("No Employee exists with ID " + id);
		}
		employee.updateEmpById(emp.getEmpname(), emp.getDesignation(), emp.getSalary(), id);
		return "Employee details updated";
	}
	
	public String deleteEmployee(Integer id) {
		if(!employee.existsById(id)) {
			throw new EmployeeNotFoundException("No Employee exists with ID " + id);
		}
		employee.deleteById(id);
		return "Employee with ID " + id + " deleted";
	}
	
}
