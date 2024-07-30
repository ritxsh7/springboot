package com.infosys.feignclient_1_order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Feignclient1OrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(Feignclient1OrderApplication.class, args);
	}

}
