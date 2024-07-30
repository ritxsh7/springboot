package com.infosys.jpaqueries.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosys.jpaqueries.domain.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{
	
}
