package com.infosys.spring_jpa_transactions.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosys.spring_jpa_transactions.domain.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{

}
