package com.infosys.microservices_user.service;

import com.infosys.microservices_user.entity.ResponseDto;
import com.infosys.microservices_user.entity.User;

public interface UserService {
	public User saveUser(User user);
	public ResponseDto getById(Long id);
}
