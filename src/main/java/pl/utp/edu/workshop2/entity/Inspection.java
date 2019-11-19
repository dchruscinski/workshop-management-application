package pl.utp.edu.workshop2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="inspection")
public class Inspection {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="inspection_id")
	private int inspectionId;
	
	@Column(name="date_time")
	private String dateTime;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="car_id")
	private Car car;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="employee_id")
	private Employee employee;

	/*
	 * constructors
	 */
	
	public Inspection() {
		
	}
	
	public Inspection(int inspectionId, String dateTime, Car car, Employee employee) {
		this.inspectionId = inspectionId;
		this.dateTime = dateTime;
		this.car = car;
		this.employee = employee;
	}
	
	/*
	 * getters and setters
	 */

	public int getInspectionId() {
		return inspectionId;
	}

	public void setInspectionId(int inspectionId) {
		this.inspectionId = inspectionId;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
}
