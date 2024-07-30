package com.infosys.spring_rest_content_negotiation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.spring_rest_content_negotiation.entity.User;
import com.infosys.spring_rest_content_negotiation.service.UserService;

@RestController
@RequestMapping("/user")
public class UserContoller {
	
	@Autowired
	private UserService userService;
	
//	@GetMapping(path="{userid}.{format}", produces="application/json")
//	public ResponseEntity<User> getUserById(
//			@PathVariable("userid") Integer userid, 
//			@PathVariable("format") String format){
//		User user = userService.getById(userid);
//		if("json".equalsIgnoreCase(format)) {			
//			return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(user);
//		}else {
//			return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).build();
//		}
//	}
	
	@GetMapping(path="/{userid}", produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<User> getUserById(
			@PathVariable("userid") Integer userid, @RequestHeader(name="Accept", defaultValue="application/json") String header){
		User user = userService.getById(userid);
		if(user==null) {
			return ResponseEntity.notFound().build();
		}
		if(header.contains(MediaType.APPLICATION_JSON_VALUE)) {
			return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(user);
		}
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(user);

	}
	
}
