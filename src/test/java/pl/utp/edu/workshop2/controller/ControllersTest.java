package pl.utp.edu.workshop2.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ControllersTest {

	@Autowired
	private EmployeeController employeeController;
	
	@Autowired
	private CarController carController;
	
	@Autowired
	private InspectionController inspectionController;
	
	@Test
	public void contextLoads() {
		assertThat(employeeController).isNotNull();
		assertThat(carController).isNotNull();
		assertThat(inspectionController).isNotNull();
	}
}