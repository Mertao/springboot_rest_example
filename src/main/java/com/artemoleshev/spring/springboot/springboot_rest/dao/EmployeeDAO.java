package com.artemoleshev.spring.springboot.springboot_rest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.artemoleshev.spring.springboot.springboot_rest.entity.Employee;


public interface EmployeeDAO {
	public List<Employee> getAllEmployees();
	
	public void saveEmployee(Employee employee);
	
	public Employee getEmployee(int id);
	
	public void deleteEmployee(int id);
}