package com.infosys.spring_rest_db.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(annotations = RestController.class)
public class CustomerExceptionHandler {

	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e) {
		CustomerErrorMessage customerErrMsg = new CustomerErrorMessage();
		customerErrMsg.setMessage(e.getBindingResult().getAllErrors().toString());
		customerErrMsg.setStatus(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(customerErrMsg, HttpStatus.BAD_REQUEST);
		
	}

	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<CustomerErrorMessage> handleException(CustomerException e) {
		CustomerErrorMessage customerErrMsg = new CustomerErrorMessage();
		customerErrMsg.setStatus(HttpStatus.NOT_FOUND);
		customerErrMsg.setMessage(e.getMessage());
		return new ResponseEntity<>(customerErrMsg, customerErrMsg.getStatus());
	}
}
