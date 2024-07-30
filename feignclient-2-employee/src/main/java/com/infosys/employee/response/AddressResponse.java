package com.infosys.employee.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class AddressResponse {
	private Integer addressId;
	private String city;
	private String state;
}
