package com.parking.model;

public class Space {
	private int spaceNumber = -1 ; 
	private boolean isEmpty = false;
	private Vehicle vehicle = null; 
	private int levelNumber = -1;

	
	public Space(int spaceNumber){
		setSpaceNumber(spaceNumber);
	}
	 
	public int getSpaceNumber() {
		return spaceNumber;
	}

	public void setSpaceNumber(int spaceNumber) {
		this.spaceNumber = spaceNumber;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
		if(vehicle == null){
			setEmpty(false);
		}else{
			setEmpty(true);
		}
	}
	public boolean isEmpty() {
		return isEmpty;
	}
	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}

	public int getLevelNumber() {
		return levelNumber;
	}

	public void setLevelNumber(int levelNumber) {
		this.levelNumber = levelNumber;
	}

	 

}
