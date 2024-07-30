package com.infosys.feignclient_1_order.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "ProductClient", url = "http://localhost:8000/products")
public interface ProductClient {
	@RequestMapping("/{id}")
	public Product getById(@PathVariable("id") Long id);
}
