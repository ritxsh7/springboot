package com.infosys.spring_loadbalancer_eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringLoadbalancerEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringLoadbalancerEurekaApplication.class, args);
	}

}
