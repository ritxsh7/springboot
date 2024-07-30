package com.infosys.spring_rest_db.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {
	@Id
	@NotNull(message = "Customer id is required")
	private Integer cust_id;
	@NotNull(message = "Customer name is required")
	private String cust_name;
	@NotNull(message="Customer age is required")
	@Min(value = 18, message = "Age should not be less than 18")
	private Integer age;
	@NotNull(message = "Gender is required")
	private Character gender;
	@NotNull(message = "Address is required")
	@Size(min=3, max=12, message = "Address should be of 3 to 12 characters")
	private String address;
	@Email(message = "Email is invalid")
	private String email;
}
