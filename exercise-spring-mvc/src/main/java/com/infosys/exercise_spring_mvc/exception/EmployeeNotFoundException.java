package com.infosys.exercise_spring_mvc.exception;

public class EmployeeNotFoundException extends RuntimeException{
	private String message;
	public EmployeeNotFoundException(String msg) {
		super(msg);
		this.message = msg;
	}
	public EmployeeNotFoundException() {
		super();
	}
}
