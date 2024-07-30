package com.infosys.blog.exception;

public class BlogAlreadyExistsException extends RuntimeException{
	
	private String message;
	public BlogAlreadyExistsException() {
		super();
	}
	public BlogAlreadyExistsException(String message) {
		super(message);
		this.message = message;
	}
}
