package com.infosys.address.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.address.entity.Address;
import com.infosys.address.repository.AddressRepository;
import com.infosys.address.response.AddressResponse;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepository address;
	
	@Autowired
	private ModelMapper mapper;
	
	public AddressResponse getAddressById(Integer id) {
		Address foundAddress = address.findById(id).get();
		AddressResponse addressResponse = mapper.map(foundAddress, AddressResponse.class);
		return addressResponse;
	}
	
	public AddressResponse saveAddress(AddressResponse newAddressResponse) {
		Address newAddress = mapper.map(newAddressResponse, Address.class);
		Address savedAddress = address.save(newAddress);
		AddressResponse addressResponse = mapper.map(savedAddress, AddressResponse.class);
		return addressResponse;
	}
	
}
