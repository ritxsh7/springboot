package com.infosys.spring_mvc_basic.entity;

import java.util.ArrayList;
import java.util.List;

public class ContactDetails {
	
	//Static data of type Contact
	
	public List<Contact> getContactDetails(){
		List<Contact> contacts = new ArrayList<Contact>();
		contacts.add(new Contact("Ritesh", "ritesh@gmail.com", "India"));
		contacts.add(new Contact("Parth", "parth@gmail.com", "India"));
		return contacts;
	}
}
