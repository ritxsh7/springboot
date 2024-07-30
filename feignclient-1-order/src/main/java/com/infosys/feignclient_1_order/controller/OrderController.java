package com.infosys.feignclient_1_order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.feignclient_1_order.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	private OrderService order;
	
	@GetMapping("/product/{id}")
	public Product getProductById(@PathVariable("id") Long id) {
		return order.getProductById(id);
	}
	
}
