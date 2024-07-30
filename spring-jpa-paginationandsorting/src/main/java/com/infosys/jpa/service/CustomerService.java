package com.infosys.jpa.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.infosys.jpa.domain.Customer;

public interface CustomerService {
	Page<Customer> findPage(Pageable page);
	List<Customer> findAll(Sort sort);
}
