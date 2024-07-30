package com.infosys.capstone.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flight {
	
	private String FlightId;
	private String FlightName;
	private String FromCity;
	private String ToCity;
	private String Cust_ID;
	private String SeatNo;
	
}
