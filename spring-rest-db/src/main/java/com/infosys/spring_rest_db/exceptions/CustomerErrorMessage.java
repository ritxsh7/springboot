package com.infosys.spring_rest_db.exceptions;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerErrorMessage {
	private HttpStatus status;
	private String message;
}
