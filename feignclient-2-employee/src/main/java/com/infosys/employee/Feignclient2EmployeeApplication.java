package com.infosys.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Feignclient2EmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(Feignclient2EmployeeApplication.class, args);
	}

}
