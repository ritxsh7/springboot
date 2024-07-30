package com.infosys.capstone.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class FlightMapper implements RowMapper<Flight>{

	@Override
	public Flight mapRow(ResultSet rs, int rowNum) throws SQLException {
		Flight flight = new Flight();
		flight.setFlightId(rs.getString("FLIGHT_ID"));
		flight.setFlightName(rs.getString("FLIGHT_NAME"));
		flight.setFromCity(rs.getString("FROM_CITY"));
		flight.setToCity(rs.getString("TO_CITY"));
		flight.setCust_ID(rs.getString("CUST_ID"));
		flight.setSeatNo(rs.getString("SEAT_NO"));
		
		return flight;
	}

}
