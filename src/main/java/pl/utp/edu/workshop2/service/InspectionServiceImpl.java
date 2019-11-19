package pl.utp.edu.workshop2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.utp.edu.workshop2.dao.InspectionRepository;
import pl.utp.edu.workshop2.entity.Inspection;

@Service
public class InspectionServiceImpl implements InspectionService {

	private InspectionRepository inspectionRepository;
	
	@Autowired
	public InspectionServiceImpl (InspectionRepository theInspectionRepository) {
		inspectionRepository = theInspectionRepository;
	}
	
	@Override
	public List<Inspection> findAll() {
		return inspectionRepository.findAllByOrderByInspectionIdAsc();
	}

	@Override
	public Inspection findById(int theId) {
		Optional <Inspection> result = inspectionRepository.findById(theId);
		
		Inspection theInspection = null;
		
		if(result.isPresent()) {
			theInspection = result.get();
		}
		else {
			throw new RuntimeException("Did not find the inspection ID: " + theId);
		}
		
		return theInspection;
	}

	@Override
	public void save(Inspection theInspection) {
		inspectionRepository.save(theInspection);
	}

	@Override
	public void deleteById(int theId) {
		inspectionRepository.deleteById(theId);
	}

}
