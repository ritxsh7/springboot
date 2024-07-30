package com.infosys.address.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosys.address.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{
	
}
