package pl.utp.edu.workshop2.service;

import java.util.List;

import pl.utp.edu.workshop2.entity.Inspection;

public interface InspectionService {
	
	public List<Inspection> findAll();
	
	public Inspection findById(int theId);
	
	public void save(Inspection theInspection);
	
	public void deleteById(int theId);

}
