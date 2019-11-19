package pl.utp.edu.workshop2.rest;

public class WorkshopReport {
	
	final private int inspectionId;
	final private int carId;
	
	public WorkshopReport(int inspectionId, int carId) {
		this.inspectionId = inspectionId;
		this.carId = carId;
	}

	public int getCarId() {
		return carId;
	}

	public int getInspectionId() {
		return inspectionId;
	}
	
}
