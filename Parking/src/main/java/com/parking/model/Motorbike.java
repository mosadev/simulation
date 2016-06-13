package com.parking.model;

public class Motorbike extends Vehicle {
 

	public Motorbike(int num) {
		this.setVehicleType(Vehicle.MOTORBIKE);
		this.setLicensePlate("Motorbike_" + num);
	}
}
