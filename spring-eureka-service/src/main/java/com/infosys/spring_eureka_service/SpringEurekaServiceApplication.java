package com.infosys.spring_eureka_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringEurekaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringEurekaServiceApplication.class, args);
	}

}
