package com.infosys.capstone.dao;

import java.util.List;

import com.infosys.capstone.model.Flight;

public interface FlightDAO {
	public boolean bookFlight(Flight flight);
	public List<Flight> displayFlightsForDestination(String destination);
	public boolean cancelFlight(String id);
	public List<Flight> displayFlightForCustomer(String cid);
}
