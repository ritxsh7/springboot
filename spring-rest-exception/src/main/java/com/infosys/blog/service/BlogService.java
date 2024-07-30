package com.infosys.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.blog.entity.Blog;
import com.infosys.blog.exception.BlogAlreadyExistsException;
import com.infosys.blog.exception.BlogNotFoundException;
import com.infosys.blog.repository.BlogRepository;

@Service
public class BlogService implements BlogServiceInterface{
	@Autowired
	private BlogRepository blogRepository;

	@Override
	public List<Blog> getAllBlogs() {
		return blogRepository.findAll();
	}

	@Override
	public Blog saveBlog(Blog blog) throws BlogAlreadyExistsException {
		if(blogRepository.existsById(blog.getBlog_id())) 
			throw new BlogAlreadyExistsException("Blog already exists for this ID");
		return blogRepository.save(blog);
	}

	@Override
	public Blog getById(Integer id) throws BlogNotFoundException {
		Blog checkBlog;
		if(blogRepository.findById(id).isEmpty()) 
			throw new BlogNotFoundException("Blog with Id " + id + " doesn't exist");
		return blogRepository.findById(id).get();
	}
}
