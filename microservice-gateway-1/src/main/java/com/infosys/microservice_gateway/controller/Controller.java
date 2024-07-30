package com.infosys.microservice_gateway.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@GetMapping("/demo1")
	public ResponseEntity<String> display(){
		return ResponseEntity.status(HttpStatus.OK).body("This is demo controller 1");
	}
	
}
