package com.infosys.spring_mvc_db.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.infosys.spring_mvc_db.entity.User;
import com.infosys.spring_mvc_db.repository.UserRepository;

@Controller
public class UserController {
	
	
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping("/test")
	public String test() {
		return "test";
	}
	
	@RequestMapping("/")
	public String indexUser(Model model) {
		return "index";
	}
	
	@RequestMapping("/get-users")
	public String getAllUsers(Model model) {
		List<User> userList = (List<User>)userRepository.findAll();
		model.addAttribute("users", userList);
		return "users";
	}
	
	@RequestMapping("/add-user-form")
	public String addUserForm() {
		return "adduser";
	}
	
	@RequestMapping("/show-user-form")
	public String showUserForm() {
		return "showUser";
	}
	
	@RequestMapping("/delete-user-form")
	public String deleteUserForm(@ModelAttribute User user, Model model) {
		return "deleteUser";
	}
	
	@RequestMapping("/update-password-form")
	public String updatePasswordForm(@ModelAttribute User user, Model model) {
		return "updateUser";
	}
	
	@RequestMapping(path = "/save-user", method = RequestMethod.POST)
	public String addUser(@ModelAttribute User user, Model model) {
		userRepository.save(user);
		model.addAttribute("username", user);
		return "successAddUser";
	}

	@RequestMapping("/show-user")
	public String showUser(@ModelAttribute User user, Model model) {
		User u = userRepository.getById(user.getUserid());
		model.addAttribute("username", u);
		return "successShowUser";
	}
	
	@RequestMapping(path="/delete-user", method = RequestMethod.POST)
	public String deleteUser(@ModelAttribute User user, Model model) {
	
		userRepository.deleteUser(user.getUserid());
		List<User> userList = userRepository.findAll();
		model.addAttribute("users", userList);
		return "successDeleteUser";
	}
	
	@RequestMapping("/update-password")
	public String updateUser(@ModelAttribute User user, Model model) {
		userRepository.updatePassword(user.getPassword(), user.getUserid());
		User newUser = userRepository.getById(user.getUserid());
		model.addAttribute("user", newUser.getUsername());
		return "successUpdateUser";
	}
}

