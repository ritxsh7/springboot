package com.infosys.microservices_department.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.microservices_department.entity.Department;
import com.infosys.microservices_department.service.DepartmentService;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
	
	@Autowired
	private DepartmentService deptService;
	
	@RequestMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Department> getById(@PathVariable("id") Long id){
		return new ResponseEntity<>(deptService.getById(id), HttpStatus.OK);
	}
	
	@PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Department> saveDepartment(@RequestBody Department dept){
		return new ResponseEntity<>(deptService.saveDepartment(dept), HttpStatus.CREATED);
	}
}
