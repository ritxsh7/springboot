package com.infosys.employee.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.infosys.employee.entity.Employee;
import com.infosys.employee.feignclient.AddressClient;
import com.infosys.employee.repository.EmployeeRepository;
import com.infosys.employee.response.AddressResponse;
import com.infosys.employee.response.EmployeeResponse;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employee;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private AddressClient address;
	
	public EmployeeResponse getByEmpId(Integer id) {
		Employee foundEmp = employee.findById(id).get();
		EmployeeResponse empResponse = mapper.map(foundEmp, EmployeeResponse.class);
		ResponseEntity<AddressResponse> addressResponse = address.getAddressById(id);
		return new EmployeeResponse(
				foundEmp.getEmpId(), 
				foundEmp.getEmpName(), 
				foundEmp.getEmail(), foundEmp.getAge(), addressResponse.getBody()
			);
	}
	
	public EmployeeResponse saveEmployee(EmployeeResponse emp) {
		Employee newEmp = mapper.map(emp, Employee.class);
		Employee savedEmp = employee.save(newEmp);
		ResponseEntity<AddressResponse> savedAddress = address.saveAddress(emp.getAddress());
		EmployeeResponse savedEmpResponse = new EmployeeResponse(
				savedEmp.getEmpId(), 
				savedEmp.getEmpName(), 
				savedEmp.getEmail(),
				savedEmp.getAge(),
				savedAddress.getBody()		
				);
		return savedEmpResponse;
	}
}
