package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import jakarta.persistence.Query;


@Repository("employeeRepository")
public class EmployeeDAOImpl implements EmployeeDAO {
	
	
	//ENTITY MANAGER FACTORY
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}
	
	
	@Override
	public List<Employee> list() {
		
		//INSTANCE OF ENTITY MANAGER
		EntityManager entityManager = this.entityManagerFactory.createEntityManager();
//		entityManager.getTransaction().begin();
		
		Query query = entityManager.createQuery("Select c from Employee c");
		return (List<Employee>)query.getResultList();
	}


	@Override
	public void insert(Employee emp) {
		EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(emp);
		entityManager.getTransaction().commit();
	}


	@Override
	public int remove(Integer id) {
		EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		int result = 0;
		
		try {
			Employee emp = entityManager.find(Employee.class, id);
			entityManager.remove(emp);
			result = 1;
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		}
		
		entityManager.close();
		
		return result;
	}


	@Override
	public void update(Integer id, String lastname) {
		EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		Employee emp = entityManager.find(Employee.class, id);
		emp.setLASTNAME(lastname);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

}
