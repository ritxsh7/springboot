package com.infosys.orm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.orm.entity.Employee;
import com.infosys.orm.entity.EmployeeDTO;
import com.infosys.orm.repository.EmployeeRepository;


@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeRepository employee;

	@Override
	public void insertEmployee(EmployeeDTO empDTO) {
		Employee emp = EmployeeDTO.createEmployee(empDTO);
		employee.saveAndFlush(emp);
	}

	@Override
	public EmployeeDTO searchEmployee(Integer id) {
		Optional<Employee> emp = employee.findById(id);
		Employee foundEmployee = emp.get();
		return Employee.createEmployeeDTO(foundEmployee);
	}

	@Override
	public List<EmployeeDTO> viewEmployees() {
		List<EmployeeDTO> empDTOList = new ArrayList<>();
		List<Employee> empList = employee.findAll();
		for(Employee emp : empList) {
			EmployeeDTO empDTO = Employee.createEmployeeDTO(emp);
			empDTOList.add(empDTO);
		}
		return empDTOList;
	}

	@Override
	public void editEmployee(Integer id, String dept) {
		Optional<Employee> emp = employee.findById(id);
		Employee foundEmployee = emp.get();
		foundEmployee.setDept(dept);
		employee.save(foundEmployee);
	}

	@Override
	public void removeEmployee(Integer id) {
		employee.deleteById(id);
	}

	@Override
	public List<Employee> getByBandlevel(String bandlevel) {
		return employee.findByEmpBandlevel(bandlevel);
	}

	@Override
	public List<Employee> getByEmpName(String empName) {
		return employee.findByEmpName(empName);
	}

	@Override
	public List<Employee> getByEmpSalaryBetween(double s1, double s2) {
		return employee.findByEmpSalaryBetween(s1, s2);
	}

	@Override
	public List<Employee> getByEmpBandlevelAndEmpDept(String bandlevel, String empDept) {
		return employee.findByEmpBandlevelAndDept(bandlevel, empDept);
	}
	
	public void updateEmpSalaryByBandlevel(Float inc, String Bandlevel){
		employee.updateEmpSalaryByBandlevel(inc, Bandlevel);
	}
	

}
