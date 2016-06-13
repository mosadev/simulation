package com.parking.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import com.parking.model.Car;
import com.parking.model.Garage;
import com.parking.model.Level;
import com.parking.model.Motorbike;
import com.parking.model.Space;
import com.parking.model.Vehicle;
import com.parking.util.Utilities;

public class Driver {
	
 	public static int AREA = 2;
	public static int SPACE_NUMBER_PER_LEVEL = 2;
	public static int LEVEL_NUMBER = 2;
	public static int CARS_NUMBER = 100;
	public static int MOTORBIKES_NUMBER = 100;

	public static ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
	 
	public static void main(String[] args) throws Exception {

		//initiate the garage structure.
		Garage garage = new Garage(LEVEL_NUMBER, SPACE_NUMBER_PER_LEVEL, AREA); 
		garage.print();

		//initiate a pool of vehicles that try to park in the garage.
		for (int i = 0; i < MOTORBIKES_NUMBER; i++) {
			vehicles.add(new Motorbike(i));
		} 
		for (int i = 0; i < CARS_NUMBER; i++) {
			vehicles.add(new Car(i));
		}
 
		//get random vehicle and park it in the garage.
		int rand0 = Utilities.getRandom(0,CARS_NUMBER + MOTORBIKES_NUMBER); 
		if(garage.park(vehicles.get(rand0))){
			garage.print();	
		}else{
			System.out.println("garage is full.");
		}
		
		int rand1 = Utilities.getRandom(0,CARS_NUMBER + MOTORBIKES_NUMBER);  
		garage.park(vehicles.get(rand1));garage.print();
		//get the available spaces at this moment.
		System.out.println(garage.getNumberOfAvailableSpace());
		
		int rand2 = Utilities.getRandom(0,CARS_NUMBER + MOTORBIKES_NUMBER);  
		garage.park(vehicles.get(rand2));garage.print();
		int rand3 = Utilities.getRandom(0,CARS_NUMBER + MOTORBIKES_NUMBER);  
		garage.park(vehicles.get(rand3));garage.print();
		int rand4 = Utilities.getRandom(0,CARS_NUMBER + MOTORBIKES_NUMBER);  
		garage.park(vehicles.get(rand4));garage.print();
		//check if one vehicle is inside the garage or not.
		System.out.println(vehicles.get(rand0).getLicensePlate());
		System.out.println(garage.getVehicleLocation(vehicles.get(rand0)));
		garage.print();
		//one of the vehicle exit the garage.
		garage.leaveSpace(vehicles.get(rand0));
		garage.print();
		
		System.out.println(garage.getVehicleLocation(vehicles.get(rand0)));
		int rand5 = Utilities.getRandom(0,CARS_NUMBER + MOTORBIKES_NUMBER); 
		garage.park(vehicles.get(rand5));garage.print();
		
	}
 

}
