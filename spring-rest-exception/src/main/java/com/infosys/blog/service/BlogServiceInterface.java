package com.infosys.blog.service;

import java.util.List;

import com.infosys.blog.entity.Blog;
import com.infosys.blog.exception.BlogAlreadyExistsException;
import com.infosys.blog.exception.BlogNotFoundException;

public interface BlogServiceInterface {
	public List<Blog> getAllBlogs();
	public Blog saveBlog(Blog blog) throws BlogAlreadyExistsException;
	public Blog getById(Integer id) throws BlogNotFoundException;
}
