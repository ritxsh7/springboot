package com.example.jdbctemplatebootdemo;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.jdbctemplatebootdemo.config.AppConfig;
import com.example.jdbctemplatebootdemo.dao.EmployeeDAO;
import com.example.jdbctemplatebootdemo.model.Employee;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		EmployeeDAO employee = context.getBean(EmployeeDAO.class);
		
//		Insert
		Employee emp = new Employee(2, "Parth", "Software Engineer", 140000);
		System.out.println(employee.insertEmployee(emp));
		
		//Fetch Data
		List<Employee> employees = employee.displayEmployees();
		for(Employee e : employees) {
			System.out.println(e);
		}
		
	}

}
