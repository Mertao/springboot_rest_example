package com.artemoleshev.spring.springboot.springboot_rest.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.artemoleshev.spring.springboot.springboot_rest.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;


@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Employee> getAllEmployees() {
//		Session session = entityManager.unwrap(Session.class);
//		Query<Employee> query = session.createQuery("FROM Employee ORDER BY id", Employee.class);
//		List<Employee> allEmployees = query.getResultList();
		
		Query query = entityManager.createQuery("FROM Employee ORDER BY id");
		List<Employee> allEmployees = query.getResultList();
		
		return allEmployees;
	}
	
	@Override
	public void saveEmployee(Employee employee) {
//		Session session = entityManager.unwrap(Session.class);
//		session.merge(employee);
		
		entityManager.merge(employee);
	}
	
	@Override
	public Employee getEmployee(int id) {
//		Session session = entityManager.unwrap(Session.class);
//		Employee employee = session.get(Employee.class, id);
		
		Employee employee = entityManager.find(Employee.class, id);
		return employee;
	}
	
	@Override
	public void deleteEmployee(int id) {
//		Session session = entityManager.unwrap(Session.class);
//		Employee employee = session.get(Employee.class, id);
//		session.remove(employee);
		
		Query query = entityManager.createQuery("DELETE FROM Employee " + "WHERE id = :employeeId");
		query.setParameter("employeeId", id);
		query.executeUpdate();
	}
}
