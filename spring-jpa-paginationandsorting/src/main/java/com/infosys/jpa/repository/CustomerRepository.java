package com.infosys.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosys.jpa.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
