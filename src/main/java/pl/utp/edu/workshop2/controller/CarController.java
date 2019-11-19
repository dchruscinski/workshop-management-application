package pl.utp.edu.workshop2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.utp.edu.workshop2.entity.Car;
import pl.utp.edu.workshop2.service.CarService;

@Controller
@RequestMapping("/cars")
public class CarController {

	@Autowired
	private CarService carService;
	
	public CarController(CarService theCarService) {
		carService = theCarService;
	}
	
	@GetMapping("/list")
	public String listCars(Model theModel) {
		
		List<Car> theCars = carService.findAll();
		
		theModel.addAttribute("cars", theCars);
		
		return "cars/list-cars";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Car theCar = new Car();
		
		theModel.addAttribute("car", theCar);
		
		return "cars/car-form";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("carId") int theId, Model theModel) {
		
		Car theCar = carService.findById(theId);
		
		theModel.addAttribute("car", theCar);
		
		return "cars/car-form";
	}
	
	@PostMapping("/save")
	public String saveCar (@ModelAttribute("car") Car theCar) {
		
		carService.save(theCar);
		
		return "redirect:/cars/list";
	}
	
	@GetMapping("/delete")
	public String delete (@RequestParam("carId") int theId) {
	
		carService.deleteById(theId);
		
		return "redirect:/cars/list";
		
	}
	

	
	
}
