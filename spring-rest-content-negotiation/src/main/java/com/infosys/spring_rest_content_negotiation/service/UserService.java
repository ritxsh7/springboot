package com.infosys.spring_rest_content_negotiation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.spring_rest_content_negotiation.entity.User;
import com.infosys.spring_rest_content_negotiation.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository user;
	
	public List<User> listAllUsers(){
		return user.findAll();
	}
	
	public User getById(Integer id) {
		return user.findById(id).get();
	}
}
