package com.infosys.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.employee.response.AddressResponse;
import com.infosys.employee.response.EmployeeResponse;
import com.infosys.employee.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employee;
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<EmployeeResponse> getEmployee(@PathVariable("id") Integer id){
		EmployeeResponse emp = employee.getByEmpId(id);
		return ResponseEntity.status(HttpStatus.OK).body(emp);
	}
	
	@PostMapping("employee/new")
	public ResponseEntity<EmployeeResponse> saveEmployee(@RequestBody EmployeeResponse emp){
		return new ResponseEntity<>(employee.saveEmployee(emp), HttpStatus.CREATED);
	}
}
