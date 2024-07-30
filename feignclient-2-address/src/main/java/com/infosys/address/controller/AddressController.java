package com.infosys.address.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.address.entity.Address;
import com.infosys.address.response.AddressResponse;
import com.infosys.address.service.AddressService;

@RestController
public class AddressController {
	
	@Autowired
	private AddressService address;
	
	@GetMapping("/address/{id}")
	public ResponseEntity<AddressResponse> getAddressById(@PathVariable("id") Integer id){
		return new ResponseEntity<>(address.getAddressById(id), HttpStatus.OK);
	}
	
	@PostMapping("address/new")
	public ResponseEntity<AddressResponse> saveAddress(@RequestBody AddressResponse newAddress){
		return new ResponseEntity<>(address.saveAddress(newAddress), HttpStatus.CREATED);
	}
}
