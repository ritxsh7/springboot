package com.infosys.spring_rest_db.exceptions;



public class CustomerException extends RuntimeException{
	public CustomerException() {
		super();
	}
	
	public CustomerException(String msg) {
		super(msg);
	}
}
