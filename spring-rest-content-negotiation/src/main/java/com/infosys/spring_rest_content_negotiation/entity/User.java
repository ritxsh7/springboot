package com.infosys.spring_rest_content_negotiation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="newuser")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id
	private Integer userid;
	private String username;
	private String email;
}
