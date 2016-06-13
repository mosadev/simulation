package com.parking.model;

public class Car extends Vehicle{
 
	public Car(int num) {
		this.setVehicleType(Vehicle.CAR);
		this.setLicensePlate("Car_" + num);
	}

}
