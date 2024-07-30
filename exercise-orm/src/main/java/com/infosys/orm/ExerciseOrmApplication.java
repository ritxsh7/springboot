package com.infosys.orm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.infosys.orm.entity.Employee;
import com.infosys.orm.entity.EmployeeDTO;
import com.infosys.orm.repository.EmployeeRepository;
import com.infosys.orm.service.EmployeeService;

@SpringBootApplication
public class ExerciseOrmApplication implements CommandLineRunner {

	@Autowired
	EmployeeService employee;
	@Autowired
	EmployeeRepository empRepository;

	public static void main(String[] args) {
		SpringApplication.run(ExerciseOrmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		1. INSERTING EMPLOYEE
//		System.out.println("Adding employees");
//		EmployeeDTO empDTO = new EmployeeDTO(4501, "Ritesh", "Architechture Design", "A4 Block", 1);
//		
//		try {
//			employee.insertEmployee(empDTO);
//			System.out.println("Inserted successfully");
//		}catch (Exception e) {
//			System.out.println(e.getMessage());
//		}

//		2. SEARCH EMPLOYEE
//		System.out.println("Searching employee");
//		try {
//			System.out.println(employee.searchEmployee(4501));
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//		

//		
//		
////		4. EDITING EMPLOYEE
//		System.out.println("Editing employee details");
//		try {
//			employee.editEmployee(4501, "Devops");
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}

//		5. REMOVE EMPLOYEE
//		System.out.println("Removing employees");
//		try {
//			employee.removeEmployee(4503);
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}

//		6. GET EMPLOYEES ACCORDING TO LABEL
		System.out.println("Employees by Bandlevel");
		List<Employee> empByBandlevelA = employee.getByBandlevel("A");
		
		for (Employee emp : empByBandlevelA) {
			System.out.println(emp);
		}
		
		
//		UPDATE BY LABEL A
		employee.updateEmpSalaryByBandlevel(1.15f, "A");
//		UPDATE BY LABEL B
		employee.updateEmpSalaryByBandlevel(1.10f, "B");
//		UPDATE BY LABEL C
		employee.updateEmpSalaryByBandlevel(1.05f, "C");
	

////	3.VIEW EMPLOYEES
		System.out.println("Viewing employees");
		List<EmployeeDTO> empDTOList = employee.viewEmployees();
		for (EmployeeDTO e : empDTOList) {
			System.out.println(e);
		}
		
////		FIND BY EMPNAME
//		System.out.println("Employees by employee name");
//		List<Employee> empByName = employee.getByEmpName("Parth");
//		for(Employee emp : empByName) {
//			System.out.println(emp);
//		}
//		
////		FIND BY EMP SALARY RANGE
//		System.out.println("Employees by employee salary range");
//		List<Employee> empBySalaryRange = employee.getByEmpSalaryBetween(50000, 100000);
//		for(Employee emp : empBySalaryRange) {
//			System.out.println(emp);
//		}
//		
//		
////		FIND EMP BY DEPT AND BANDLEVEL
//		System.out.println("Employees by employee bandlevel and department");
//		List<Employee> empByBandlevelAndDept = employee.getByEmpBandlevelAndEmpDept("A", "UI/UX Designer");
//		for(Employee emp : empByBandlevelAndDept) {
//			System.out.println(emp);
//		}

	}

}
