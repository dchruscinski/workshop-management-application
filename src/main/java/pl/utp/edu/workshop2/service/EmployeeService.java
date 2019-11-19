package pl.utp.edu.workshop2.service;

import java.util.List;

import pl.utp.edu.workshop2.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee theEmployee);
	
	public void deleteById(int theId);
}
