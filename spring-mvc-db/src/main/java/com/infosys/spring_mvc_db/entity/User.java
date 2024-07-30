package com.infosys.spring_mvc_db.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "user_details")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
	
	@Id
	private Integer userid;
	private String username;
	private String password;
	
}
