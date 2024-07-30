package com.example.jdbctemplatebootdemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.DataAccessException;

import com.example.jdbctemplatebootdemo.config.AppConfig;
import com.example.jdbctemplatebootdemo.dao.EmployeeDAO;
import com.example.jdbctemplatebootdemo.model.Employee;

@SpringBootApplication
public class JdbctemplatebootdemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(JdbctemplatebootdemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		EmployeeDAO employee = context.getBean(EmployeeDAO.class);

//		Insert
//		System.out.println("Inserting data :");
//		Employee empObj = new Employee(2, "Sanket", "Software Tester", 90000);
//		try {
//			System.out.println(employee.insertEmployee(empObj));
//		} catch (DataAccessException e) {
//			System.out.println(e.getMessage());
//		}

		// Fetch Data
		List<Employee> employees = employee.displayEmployees();
		for (Employee e : employees) {
			System.out.println(e);
		}

		// Updating Data
//		System.out.println("Updating employee");

//		try {
//			Employee emp1 = employee.findEmployeeByID(2);
//			emp1.setEmpName("Shreyash");
//			emp1.setEmpDesignation("Designer");
//			System.out.println(employee.updateEmployee(emp1));
//		} catch (DataAccessException e) {
//			System.out.println(e.getMessage());
//		}

		// Fetch Data
		for (Employee e : employee.displayEmployees()) {
			System.out.println(e);
		}

		// Delete Data
		System.out.println("Deleting employee");
		try {
			Employee emp2 = employee.findEmployeeByID(2);
			System.out.println(employee.deleteEmployee(emp2));
		} catch (DataAccessException e) {
			System.out.println(e.getMessage());
		}

		// Fetch Data
		for (Employee e : employee.displayEmployees()) {
			System.out.println(e);
		}

	}

}
