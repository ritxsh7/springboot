package com.infosys.capstone.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CustomerMapper implements RowMapper<Customer>{

	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customer customer = new Customer();
		
		customer.setCustId(rs.getString("CUST_ID"));
		customer.setFirstName(rs.getString("CUST_FIRSTNAME"));
		customer.setLastName(rs.getString("CUST_LASTNAME"));
		customer.setPhone(rs.getString("CUST_PHONE"));
		
		return customer;
	}

}
