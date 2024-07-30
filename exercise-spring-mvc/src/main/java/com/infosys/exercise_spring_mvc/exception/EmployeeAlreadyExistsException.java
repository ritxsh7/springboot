package com.infosys.exercise_spring_mvc.exception;

public class EmployeeAlreadyExistsException extends RuntimeException{
	private String message;
	public EmployeeAlreadyExistsException(String msg) {
		super(msg);
		this.message = msg;
	}
	public EmployeeAlreadyExistsException() {
		super();
	}
}
