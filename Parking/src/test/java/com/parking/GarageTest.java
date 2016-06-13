package com.parking;

import static org.junit.Assert.*;

import java.util.ArrayList;


import org.junit.Before;
import org.junit.Test;

import com.parking.model.Car;
import com.parking.model.Garage;
import com.parking.model.Motorbike;
import com.parking.model.Vehicle;
import com.parking.util.Utilities;

public class GarageTest {
	
	public static int AREA = 2;
	public static int SPACE_NUMBER_PER_LEVEL = 2;
	public static int LEVEL_NUMBER = 5;
	public static int CARS_NUMBER = 100;
	public static int MOTORBIKES_NUMBER = 100;
	Garage garage = new Garage(LEVEL_NUMBER, SPACE_NUMBER_PER_LEVEL, AREA); 
	public static ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

	@Before
	public void before() throws Exception {  
		for (int i = 0; i < MOTORBIKES_NUMBER; i++) {
			vehicles.add(new Motorbike(i));
		} 
		for (int i = 0; i < CARS_NUMBER; i++) {
			vehicles.add(new Car(i));
		}
		 
	}
	
	
	
	@Test
	public void test_availableLotNumber() throws Exception{
		int rand0 = Utilities.getRandom(0,CARS_NUMBER + MOTORBIKES_NUMBER); 
		garage.park(vehicles.get(rand0)) ; 
		int rand1 = Utilities.getRandom(0,CARS_NUMBER + MOTORBIKES_NUMBER);  
		garage.park(vehicles.get(rand1));  
		int rand2 =Utilities.getRandom(0,CARS_NUMBER + MOTORBIKES_NUMBER);  
		garage.park(vehicles.get(rand2)); 
		int rand3 = Utilities.getRandom(0,CARS_NUMBER + MOTORBIKES_NUMBER);  
		garage.park(vehicles.get(rand3)); 
		int rand4 = Utilities.getRandom(0,CARS_NUMBER + MOTORBIKES_NUMBER);  
		garage.park(vehicles.get(rand4));   
		
		assertEquals(5, garage.getNumberOfAvailableSpace() , 0);
		
	}
	
	
	@Test
	public void test_garageIsFull() throws Exception{
		
		int rand0 = Utilities.getRandom(0,CARS_NUMBER + MOTORBIKES_NUMBER); 
		garage.park(vehicles.get(rand0)) ; 
		int rand1 = Utilities.getRandom(0,CARS_NUMBER + MOTORBIKES_NUMBER);  
		garage.park(vehicles.get(rand1));  
		int rand2 =Utilities.getRandom(0,CARS_NUMBER + MOTORBIKES_NUMBER);  
		garage.park(vehicles.get(rand2)); 
		int rand3 = Utilities.getRandom(0,CARS_NUMBER + MOTORBIKES_NUMBER);  
		garage.park(vehicles.get(rand3)); 
		int rand4 = Utilities.getRandom(0,CARS_NUMBER + MOTORBIKES_NUMBER);  
		garage.park(vehicles.get(rand4));  
		
		garage.leaveSpace(vehicles.get(rand0));  
		 
		assertEquals(6, garage.getNumberOfAvailableSpace() , 0);
		
	} 
}
