package com.infosys.spring_mvc_basic.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.infosys.spring_mvc_basic.entity.Contact;
import com.infosys.spring_mvc_basic.entity.ContactDetails;

@Controller
public class HomeController {
	
	@RequestMapping("/welcome")
	public String welcome() {
		return "index";
	}
	
	@RequestMapping("/contact")
	public String listContacts(Model model) {
		ContactDetails contactDetails = new ContactDetails();
		List<Contact> contactsList = contactDetails.getContactDetails();
		model.addAttribute("contacts", contactsList);
		return "contact";
	}
	
}
