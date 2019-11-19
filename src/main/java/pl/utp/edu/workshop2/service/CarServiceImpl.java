package pl.utp.edu.workshop2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.utp.edu.workshop2.dao.CarRepository;
import pl.utp.edu.workshop2.entity.Car;

@Service
public class CarServiceImpl implements CarService {
	
	private CarRepository carRepository;
	
	@Autowired
	public CarServiceImpl(CarRepository theCarRepository) {
		carRepository = theCarRepository;
	}

	@Override
	public List<Car> findAll() {
		return carRepository.findAllByOrderByCarIdAsc();
	}

	@Override
	public Car findById(int theId) {
		Optional <Car> result = carRepository.findById(theId);
		
		Car theCar = null;
		
		if (result.isPresent()) {
			theCar = result.get();
		}
		else {
			throw new RuntimeException("Did not find the car ID: " + theId);
		}
		
		return theCar;
	}

	@Override
	public void save(Car theCar) {
		carRepository.save(theCar);

	}

	@Override
	public void deleteById(int theId) {
		carRepository.deleteById(theId);

	}

}
