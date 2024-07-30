package com.example.demo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.Entity.EmployeeDTO;
import com.example.demo.service.EmployeeService;


@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	@Autowired
	ApplicationContext context;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		EmployeeService employeeService = context.getBean("employeeService", EmployeeService.class);
		
		EmployeeDTO emp = new EmployeeDTO(4, "Parth", "Gandhi", (float) 95666.87);
//		employeeService.insert(emp);
		
		
		if(employeeService.remove(1) == 1) {
			System.out.println("Removed employee successfully");
		}else {
			System.out.println("Error while removing employee");
		}
		
		
		employeeService.update(4,  "Patil");
		
		
		System.out.println("Listing all the employees");
		ArrayList<EmployeeDTO> empList = (ArrayList<EmployeeDTO>) employeeService.list();
		
		for(EmployeeDTO employee : empList) {
			System.out.println(employee);
		}
		
		
	}

}
