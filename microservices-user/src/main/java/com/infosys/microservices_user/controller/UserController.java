package com.infosys.microservices_user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.microservices_user.entity.ResponseDto;
import com.infosys.microservices_user.entity.User;
import com.infosys.microservices_user.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<ResponseDto> getById(@PathVariable("id") Long id){
		return new ResponseEntity<>(userService.getById(id), HttpStatus.OK);
	}
	
	@PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> saveUser(@RequestBody User user){
		return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
	}
	
}
