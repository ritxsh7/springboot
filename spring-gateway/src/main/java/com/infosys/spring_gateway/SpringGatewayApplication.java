package com.infosys.spring_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringGatewayApplication {

	@Bean
	public RouteLocator routeBuilder(RouteLocatorBuilder routeLocateBuilder) {
		return routeLocateBuilder.routes()
				.route("microservice-gateway-1", r->r.path("/server1/**").uri("http://localhost:8080"))
				.route("microservice-gateway-2", r->r.path("/server2/**").uri("http://localhost:8081")).build();	
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringGatewayApplication.class, args);
	}

}
