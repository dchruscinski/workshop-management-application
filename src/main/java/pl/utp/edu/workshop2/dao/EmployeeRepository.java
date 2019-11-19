package pl.utp.edu.workshop2.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.utp.edu.workshop2.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// sorting by film name ascending method
	public List<Employee> findAllByOrderByEmployeeIdAsc();
}
