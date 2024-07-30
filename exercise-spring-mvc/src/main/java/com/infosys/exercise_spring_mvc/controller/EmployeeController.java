package com.infosys.exercise_spring_mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.exercise_spring_mvc.entity.Employee;
import com.infosys.exercise_spring_mvc.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@GetMapping(path = "/get-all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Employee>> getAllEmployees(){
		List<Employee> empList = empService.getAllEmployees();
		return new ResponseEntity<>(empList, HttpStatus.FOUND);
	}
	
	@PostMapping(path = "/new", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee emp) {
		Employee savedEmp = empService.createEmployee(emp);
		return new ResponseEntity<>(savedEmp, HttpStatus.CREATED);
	}
	
	@GetMapping(path = "/find", produces = MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<List<Employee>> getByIdAndDesignation(@RequestParam("id") Integer id, @RequestParam("desg") String designation){
		List<Employee> empList = empService.getByEmpidAndDesignation(id, designation);
		return new ResponseEntity<>(empList, HttpStatus.OK);
	}
	
	
	@GetMapping(path="/find/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> getById(@PathVariable("id") Integer id){
		return new ResponseEntity<>(empService.getById(id), HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateById(@PathVariable("id") Integer id, @RequestBody Employee emp){
		return new ResponseEntity<>(empService.updateById(id, emp), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmp(@PathVariable("id") Integer id){
		return new ResponseEntity<>(empService.deleteEmployee(id), HttpStatus.OK);
	}
}
