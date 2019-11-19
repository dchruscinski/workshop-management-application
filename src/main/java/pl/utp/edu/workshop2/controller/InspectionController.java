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
import pl.utp.edu.workshop2.entity.Employee;
import pl.utp.edu.workshop2.entity.Inspection;
import pl.utp.edu.workshop2.service.CarService;
import pl.utp.edu.workshop2.service.EmployeeService;
import pl.utp.edu.workshop2.service.InspectionService;

@Controller
@RequestMapping("/inspections")
public class InspectionController {

	private Car theCar;
	
	private Employee theEmployee;
	
	@Autowired
	private InspectionService inspectionService;
	
	@Autowired
	private CarService carService;
	
	@Autowired
	private EmployeeService employeeService;
	
	public InspectionController(InspectionService theInspectionService) {
		inspectionService = theInspectionService;
	}
	
	@GetMapping("/list")
	public String listInspections(Model theModel) {
		
		List<Inspection> theInspections = inspectionService.findAll();
		
		theModel.addAttribute("inspections", theInspections);
		
		return "inspections/list-inspections";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Inspection theInspection = new Inspection();
		List<Car> theCars = carService.findAll();
		List<Employee> theEmployees = employeeService.findAll();
		
		theModel.addAttribute("inspection", theInspection);
		theModel.addAttribute("car", theCars);
		theModel.addAttribute("employee", theEmployees);
		
		return "inspections/inspection-form";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("inspectionId") int theId, Model theModel) {
		
		Inspection theInspection = inspectionService.findById(theId);
		List<Car> theCars = carService.findAll();
		List<Employee> theEmployees = employeeService.findAll();
		
		theModel.addAttribute("inspection", theInspection);
		theModel.addAttribute("car", theCars);
		theModel.addAttribute("employee", theEmployees);
		
		return "inspections/inspection-form";
	}
	
	@PostMapping("/save")
	public String saveInspection (@ModelAttribute("inspection") Inspection theInspection) {
		
		inspectionService.save(theInspection);
		
		return "redirect:/inspections/list";
	}
	
	@GetMapping("/delete")
	public String delete (@RequestParam("inspectionId") int theId) {
	
		inspectionService.deleteById(theId);
		
		return "redirect:/inspections/list";
		
	}
}
