package com.infosys.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.blog.entity.Blog;
import com.infosys.blog.exception.BlogAlreadyExistsException;
import com.infosys.blog.exception.BlogNotFoundException;
import com.infosys.blog.service.BlogService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/blogs")
public class BlogController {
	
	@Autowired
	private BlogService blogService;
	
	@GetMapping(path="/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Blog> getAllBlogs(){
		return blogService.getAllBlogs();
	}
	
	@PostMapping(path="/save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Blog> saveBlog(@Valid @RequestBody Blog blog){
		Blog savedBlog = blogService.saveBlog(blog);
		return new ResponseEntity<>(savedBlog, HttpStatus.CREATED);
	}
	
	@GetMapping(path="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Blog> getById(@PathVariable("id") Integer id){
		Blog blogById = blogService.getById(id);
		return new ResponseEntity<>(blogById, HttpStatus.FOUND);
	}
	
	@ExceptionHandler(BlogNotFoundException.class)
	public ResponseEntity<String> handleNotFoundException(BlogNotFoundException e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(BlogAlreadyExistsException.class)
	public ResponseEntity<String> handleAlreadyExistsException(BlogAlreadyExistsException e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
	}
	
}
