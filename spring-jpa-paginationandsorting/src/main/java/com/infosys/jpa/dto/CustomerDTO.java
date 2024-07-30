package com.infosys.jpa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class CustomerDTO {

		private Integer CustID;
		private String CustName;
		private Integer Age;
		private Character Gender;
		private String Address;
}
