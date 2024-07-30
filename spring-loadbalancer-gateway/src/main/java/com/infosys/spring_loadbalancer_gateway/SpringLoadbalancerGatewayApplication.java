package com.infosys.spring_loadbalancer_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringLoadbalancerGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringLoadbalancerGatewayApplication.class, args);
	}

}
