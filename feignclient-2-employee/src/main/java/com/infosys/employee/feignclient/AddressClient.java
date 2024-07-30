package com.infosys.employee.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.infosys.employee.response.AddressResponse;

@FeignClient(name = "address-client", url = "http://localhost:8000", path = "/address-service")

public interface AddressClient {
	@GetMapping("/address/{id}")
	public ResponseEntity<AddressResponse> getAddressById(@PathVariable("id") Integer id);
	
	@PostMapping("/address/new")
	public ResponseEntity<AddressResponse> saveAddress(@RequestBody AddressResponse newAddress);
}
