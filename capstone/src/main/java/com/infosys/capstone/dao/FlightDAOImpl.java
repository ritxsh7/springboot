package com.infosys.capstone.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.infosys.capstone.model.Flight;
import com.infosys.capstone.model.FlightMapper;


@Component
public class FlightDAOImpl implements FlightDAO{
	
	

	

	

	@Autowired
	private JdbcTemplate jdbc;
	
	private final String SQL_BOOK_NEW_FLIGHT = "INSERT INTO FLIGHT VALUES (?, ?, ? , ?, ?, ?)";
	private final String SQL_FLIGHTS_FOR_DESTINATION = "SELECT * FROM FLIGHT WHERE TO_CITY=?";
	private final String SQL_CANCEL_FLIGHT = "DELETE FROM FLIGHT WHERE FLIGHT_ID=?";
	private  final String SQL_FIND_FLIGHT = "SELECT * FROM FLIGHT WHERE FLIGHT_ID = ?";
	private  final String SQL_FLIGHTS_FOR_CUSTOMER = "SELECT * FROM FLIGHT WHERE CUST_ID = ?";

	@Override
	public boolean bookFlight(Flight flight) {
		return jdbc.update(SQL_BOOK_NEW_FLIGHT, flight.getFlightId(), flight.getFlightName(), flight.getFromCity(), flight.getToCity(), flight.getCust_ID(), flight.getSeatNo()) > 0;
	}

	@Override
	public List<Flight> displayFlightsForDestination(String destination) {
		return jdbc.query(SQL_FLIGHTS_FOR_DESTINATION, new Object[] {destination}, new FlightMapper());
	}

	@Override
	public boolean cancelFlight(String id) {
		return jdbc.update(SQL_CANCEL_FLIGHT, id) > 0;
	}

	@Override
	public List<Flight> displayFlightForCustomer(String cid) {
		return jdbc.query(SQL_FLIGHTS_FOR_CUSTOMER, new Object[] {cid}, new FlightMapper());
	}
	
}
