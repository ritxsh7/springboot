package com.infosys.blog.exception;

public class BlogNotFoundException extends RuntimeException {
	
	private String message;
	
	public BlogNotFoundException(){
		super();
	}
	
	public BlogNotFoundException(String message){
		super(message);
		this.message = message;
	}
}
