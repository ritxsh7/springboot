package com.infosys.spring_rest_content_negotiation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosys.spring_rest_content_negotiation.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
}
