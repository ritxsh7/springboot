package com.infosys.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.infosys.jpa.domain.Customer;
import com.infosys.jpa.repository.CustomerRepository;


@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerRepository customer;

	@Override
	public Page<Customer> findPage(Pageable page) {
		return customer.findAll(page);
	}

	@Override
	public List<Customer> findAll(Sort sort) {
		return customer.findAll(sort);
	}

}
