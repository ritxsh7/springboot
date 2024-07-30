package com.infosys.spring_eureka_service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/demo")
@RestController
public class DemoController {

	@GetMapping("/service")
	public ResponseEntity<String> display(){
		return ResponseEntity.status(HttpStatus.OK).body("This is demo controller");
	}
}
