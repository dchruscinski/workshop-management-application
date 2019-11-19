package pl.utp.edu.workshop2.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.utp.edu.workshop2.entity.Inspection;

public interface InspectionRepository extends JpaRepository<Inspection, Integer> {
	
	public List<Inspection> findAllByOrderByInspectionIdAsc();

}
