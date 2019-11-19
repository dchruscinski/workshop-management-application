package pl.utp.edu.workshop2.service;

import java.util.List;

import pl.utp.edu.workshop2.entity.Car;

public interface CarService {
	
	public List<Car> findAll();
	
	public Car findById(int theId);
	
	public void save(Car theCar);
	
	public void deleteById(int theId);

}
