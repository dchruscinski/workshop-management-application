package pl.utp.edu.workshop2.rest;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.utp.edu.workshop2.entity.Inspection;
import pl.utp.edu.workshop2.service.InspectionService;

@RestController
public class WorkshopReportController {
	
	@Autowired
	private InspectionService theInspectionService;
	
	@RequestMapping("/report")
	public List<WorkshopReport> inspectionsReport() {
		
		List<WorkshopReport> theInspectionReports = new ArrayList<>();
		
		List<Inspection> theInspections = theInspectionService.findAll();
		
		Map<Integer, Integer> reportInspections = new LinkedHashMap<>();
		
		theInspections.forEach(e -> {
			Integer inspectionId = e.getInspectionId();
			Integer carId = e.getCar().getCarId();
			
			System.out.println(inspectionId);
			System.out.println(carId);
			
			if (reportInspections.get(inspectionId) != null) {
				reportInspections.put(inspectionId, reportInspections.get(inspectionId) + carId);
		} else {
			reportInspections.put(inspectionId, carId);
		}
			
		});
		
		theInspections.forEach(e -> {
			theInspectionReports.add(new WorkshopReport (
					e.getInspectionId(),
					reportInspections.get(e.getInspectionId())));
		});
		
		return theInspectionReports;
		
	}

}
