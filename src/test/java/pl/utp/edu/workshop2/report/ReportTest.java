package pl.utp.edu.workshop2.report;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.notNullValue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import com.jayway.restassured.RestAssured;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReportTest {
	
		@LocalServerPort
		private int port = 8086;
	
		@Before
		public void setUp() throws Exception {
			RestAssured.port = port;
		}	
		
		@Test
		public void checkingCar() {
			 given().when()
	 			.get("/report")
	 		.then().statusCode(200)
	 		.body("carId", hasItem(3));
	}
		
		@Test
		public void checkingNulls() {
			 given().when()
	 			.get("/report")
	 		.then().statusCode(200).body("inspectionId", notNullValue());
	}
		
		
}