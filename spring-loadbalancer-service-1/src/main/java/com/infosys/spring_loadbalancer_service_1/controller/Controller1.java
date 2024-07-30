package com.infosys.spring_loadbalancer_service_1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class Controller1 {
	@GetMapping("/message")
	public ResponseEntity<String> message(@RequestHeader("first-request") String header){
		System.out.println(header);
		return ResponseEntity.ok("This is service 1");
	}
}
