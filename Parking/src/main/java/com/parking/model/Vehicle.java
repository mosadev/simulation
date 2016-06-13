package com.parking.model;

public abstract class Vehicle {
	  
	public static final int MOTORBIKE = 1;
	public static final int CAR = 2;
	private String licensePlate = "";
	protected int vehicleType = 0;
	protected boolean isInsideGarage = false;
	
	protected int getVehicleType(){
		return this.vehicleType;
	}

	protected void setVehicleType(int vehicleType) {
		this.vehicleType = vehicleType;
	}
	
	public  String getLicensePlate() {
		return licensePlate;
	}

	protected  void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public boolean isInsideGarage() {
		return isInsideGarage;
	}

	public void setInsideGarage(boolean isInsideGarage) {
		this.isInsideGarage = isInsideGarage;
	}
	
}
