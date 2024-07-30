package com.infosys.exercise_spring_mvc.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EmployeeExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<List<String>> handleMethodArgsNotValid(MethodArgumentNotValidException e){
		List<FieldError> errors = e.getBindingResult().getFieldErrors();
		List<String> errorMessages = new ArrayList<>();
		for(FieldError error : errors) {
			errorMessages.add(error.getDefaultMessage());
		}
		return new ResponseEntity<>(errorMessages, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(EmployeeAlreadyExistsException.class)
	public ResponseEntity<String> handleEmpAlreadyExists(EmployeeAlreadyExistsException e){
		return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<String> handleEmpNotFound(EmployeeNotFoundException e){
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
}
