package com.infosys.microservices_user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.infosys.microservices_user.entity.DepartmentDto;
import com.infosys.microservices_user.entity.ResponseDto;
import com.infosys.microservices_user.entity.User;
import com.infosys.microservices_user.entity.UserDto;
import com.infosys.microservices_user.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService{

	@Autowired 
	private UserRepository user;
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public User saveUser(User newUser) {
		return user.save(newUser);
	}

	@Override
	public ResponseDto getById(Long id) {
		User userById = user.findById(id).get();
		UserDto userDto = mapToUser(userById);
		ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8000/api/departments/" + userById.getDeptId(), DepartmentDto.class);
		ResponseDto responseUser = new ResponseDto(userDto, responseEntity.getBody());
		return responseUser;
	}

	private UserDto mapToUser(User user) {
		return new UserDto(user.getUserId(), user.getFirstName(), user.getLastName(), user.getLastName());
	}
	
}
