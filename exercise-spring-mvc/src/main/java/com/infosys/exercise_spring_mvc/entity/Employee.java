package com.infosys.exercise_spring_mvc.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	@Id
	@NotNull(message = "Employee ID is required")
	private Integer empid;
	@NotNull(message = "Employee name is required")
	private String empname;
	@NotNull(message = "Employee designation is required")
	private String designation;
	@NotNull(message = "Employee salary is required")
	private Integer salary;
}
