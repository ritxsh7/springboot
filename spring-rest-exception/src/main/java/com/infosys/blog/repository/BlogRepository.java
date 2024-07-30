package com.infosys.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosys.blog.entity.Blog;

public interface BlogRepository extends JpaRepository<Blog, Integer>{
	
}
