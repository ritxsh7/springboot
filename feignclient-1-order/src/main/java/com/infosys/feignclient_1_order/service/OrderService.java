package com.infosys.feignclient_1_order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.feignclient_1_order.controller.Product;
import com.infosys.feignclient_1_order.controller.ProductClient;


@Service
public class OrderService {
	
	@Autowired
	private ProductClient productClient;
	
	public Product getProductById(Long id) {
		return productClient.getById(id);
	}
}
