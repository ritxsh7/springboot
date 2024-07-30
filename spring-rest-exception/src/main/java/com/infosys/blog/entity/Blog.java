package com.infosys.blog.entity;

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
public class Blog {
	@Id
	@NotNull(message = "Blog ID should not be empty")
	private Integer blog_id;
	@NotNull(message = "Blog title should not be empty")
	private String title;
	@NotNull(message = "Blog creator should not be empty")
	private String creator;
	@NotNull(message = "Blog date should not be empty")
	private Integer postedon;
}
