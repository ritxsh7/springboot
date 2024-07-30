package com.infosys.feignclient_1_product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.feignclient_1_product.entity.Product;

@RestController
@RequestMapping("/products")
public class ProductController {
	@GetMapping("/{id}")
	public Product getById(@PathVariable("id") Long id) {
		return new Product(id, "Sample Product", 65.50);
	}
}
