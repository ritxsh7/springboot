package com.infosys.capstone.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.infosys.capstone.model.Customer;
import com.infosys.capstone.model.CustomerMapper;


@Component
public class CustomerDAOImpl implements CustomerDAO{

	@Autowired
	private JdbcTemplate jdbc;
	
	private final String SQL_GET_CUSTOMER_FROM_FLIGT = "SELECT CUST_ID, CUST_FIRSTNAME, CUST_LASTNAME, CUST_PHONE FROM CUSTOMER JOIN FLIGHT USING(CUST_ID) WHERE FLIGHT_ID = ?";
	
	private final String SQL_UPDATE_CUSTOMER = "UPDATE CUSTOMER SET CUST_PHONE = ? WHERE CUST_ID = ?";
	
	@Override
	public List<Customer> displayCustomers() {
		return jdbc.query("SELECT * FROM CUSTOMER", new CustomerMapper());
	}

	@SuppressWarnings("deprecation")
	@Override
	public Customer getCustomerFromFlightID(String Id) {
		return jdbc.queryForObject(SQL_GET_CUSTOMER_FROM_FLIGT, new Object[] {Id}, new CustomerMapper());
	}

	@Override
	public boolean update(Customer customer) {
		return jdbc.update(SQL_UPDATE_CUSTOMER, customer.getPhone(), customer.getCustId()) > 0;
	}

}
