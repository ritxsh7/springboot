package com.infosys.jpql.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.infosys.jpql.domain.Customer;
import com.infosys.jpql.dto.CustomerDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<CustomerDTO> getCustomers() {
		String GET_CUSTOMERS = "select c from Customer c";
		Query query = entityManager.createQuery(GET_CUSTOMERS);
		List<Customer> customerList = query.getResultList();

		List<CustomerDTO> customerDTOList = new ArrayList<>();

		// CONVERT TO DTO
		for (Customer cust : customerList) {
			CustomerDTO custDTO = new CustomerDTO(cust.getCustId(), cust.getActive(), cust.getCreditpoints(),
					cust.getFirstname(), cust.getLastname(), cust.getEmail(), cust.getContactNo(), cust.getDateOfBirth(), cust.getCity());
			customerDTOList.add(custDTO);
		}

		return customerDTOList;
	}

	@Override
	public List<Object[]> getCustomerFirstNameAndEmail() {
		String GET_CUSTOMERS = "select c.firstname, c.email from Customer c";
		Query query = entityManager.createQuery(GET_CUSTOMERS);
		List<Object[]> customerList = query.getResultList();
		return customerList;
	}

	@Override
	public List<Object[]> getCustomerFullName() {
		String GET_CUSTOMERS_FULLNAME = "select c.firstname, c.lastname from Customer c";
		Query query = entityManager.createQuery(GET_CUSTOMERS_FULLNAME );
		List<Object[]> customerList = query.getResultList();
		return customerList;
	}

	@Override
	public Customer getCustomerById(int id) {
		String GET_CUSTOMERS_BY_ID = "select c from Customer c where c.custId = ?1";
		Query query = entityManager.createQuery(GET_CUSTOMERS_BY_ID);
		query.setParameter(1, id);
		Customer customer = (Customer) query.getSingleResult();
		return customer;
	}

	@Override
	public List<Customer> getFullCustomerDetails() {
		String GET_CUSTOMERS_BY_ID = "select c from Customer c where c.custId = 102";
		String GET_CUSTOMERS_BY_CITY = "select c from Customer c where c.city != 'Pune'";
		String GET_CUSTOMERS_BY_RANGE = "select c from Customer c where c.creditpoints between 20 and 25";
		String GET_CUSTOMERS_BY_EMAIL = "select c from Customer c where c.firstname like 'A%'";
		String GET_CUSTOMERS_BY_CITYIN = "select c from Customer c where c.city in ('Mumbai', 'Pune')";
		String GET_CUSTOMERS_BY_DATE1 = "select c from Customer c where c.dateOfBirth >= cast('2004-01-01' as date)";
		String GET_CUSTOMERS_BY_DATE2 = "select c from Customer c where c.dateOfBirth < cast('2004-01-01' as date)";

		Query query = entityManager.createQuery(GET_CUSTOMERS_BY_DATE2);
		List<Customer> customerList = query.getResultList();
		return customerList;
	}

	@Override
	public Integer updateCustomerCity(Integer id, String city) {	
		String UPDATE_CUSTOMER_CITY = "update Customer c set c.city = ?1 where c.custId = ?2";
		Query query = entityManager.createQuery(UPDATE_CUSTOMER_CITY);
		query.setParameter(1, city);
		query.setParameter(2, id);
		return query.executeUpdate();
	}

	@Override
	public Integer deleteCustomerByEmail(String email) {
		String DELETE_CUSTOMER = "delete from Customer c where c.email = ?1";
		Query query = entityManager.createQuery(DELETE_CUSTOMER);
		query.setParameter(1, email);
		return query.executeUpdate();
	}

	@Override
	public List<Object[]> getCustomerCountByCity(String city) {
		String GET_CUSTOMER_COUNT_BY_CITY = "select c.city, count(c.city) from Customer c group by c.city";
		Query query = entityManager.createQuery(GET_CUSTOMER_COUNT_BY_CITY);
		return query.getResultList();
	}
}
