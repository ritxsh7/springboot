package com.infosys.microservices_user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosys.microservices_user.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
}
