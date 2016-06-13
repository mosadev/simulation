package com.parking.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import com.parking.exceptions.CanNotDeleteException;
import com.parking.util.Utilities;

public class Garage {

	private int area = 0;
	private int levelNumber = 0;

	// garage available spaces indexing system
	private List<String> list = new ArrayList<String>();
	private Map<String, Integer> availableSpaces = new HashMap<String, Integer>();

	private Map<String, String> existedVehicles = new HashMap<String, String>();

	// level in the garage
	private List<Level> levels = new ArrayList<Level>();

	public Garage(int levelNumber, int spaceNumberPerLevel, int area) {

		// construct the garage structure.
		this.area = area;
		this.levelNumber = levelNumber;
		for (int i = 0; i < levelNumber; i++) {
			Level l = new Level(i, spaceNumberPerLevel);
			levels.add(l);
		}

		// construct the garage available spaces indexing system
		int index = 0;
		for (int i = 0; i < levelNumber; i++) {
			for (int j = 0; j < spaceNumberPerLevel; j++) {
				list.add(i + "_" + j);
				availableSpaces.put(i + "_" + j, index);
				index++;
			}
		}
	}

	/**
	 * draw the garage status in the time of calling
	 */
	public void print() {
		List<Level> l = this.getLevels();
		System.out.println(l.size());
		for (int i = 0; i < l.size(); i++) {
			List<Space> s = this.getLevels().get(i).getSpaces();
			for (int j = 0; j < s.size(); j++) {

				if (s.get(j).getVehicle() == null) {
					System.out.print("|" + "Empty" + "|");
				} else {
					System.out.print("|"
							+ s.get(j).getVehicle().getLicensePlate() + "|");
				}
			}
			System.out.println(s.size());
		}
	}

	/**
	 * Represent the action of vehicle park
	 * 
	 * @param vehicle
	 * @return true if the operation complete false otherwise
	 * @throws Exception
	 */
	public boolean park(Vehicle vehicle) throws Exception {
		// Park where ever you want.
		int level = Utilities.getRandom(0, this.getLevels().size());
		int space = Utilities.getRandom(0, this.getLevels().get(level)
				.getSpaces().size());
		if (!this.getLevels().get(level).getSpaces().get(space).isEmpty()) {
			this.getLevels().get(level).getSpaces().get(space)
					.setVehicle(vehicle);
			existedVehicles.put(vehicle.getLicensePlate(), level + "_" + space);
			deleteFromAvailableSpaces(level, space);

			return true;
		} else {
			if (list.size() > 0) {
				// if the garage has random occupied spaces.
				int rIndex = Utilities.getRandom(0, list.size() - 1);
				String mIndex = list.get(rIndex);
				String[] si = mIndex.split("_");
				int l = Integer.valueOf(si[0]);
				int s = Integer.valueOf(si[1]);

				this.getLevels().get(l).getSpaces().get(s).setVehicle(vehicle);
				existedVehicles.put(vehicle.getLicensePlate(), l + "_" + s);
				deleteFromAvailableSpaces(l, s);
				return true;
			} else {
				return false;
			}
		}
	}

	/**
	 * Delete the vehicle from the system.
	 * 
	 * @param level
	 *            number
	 * @param space
	 *            number
	 * @return true if the operation complete false otherwise
	 * @throws Exception
	 *             if the system can not delete the recored.
	 */
	private boolean deleteFromAvailableSpaces(int l, int s) throws Exception {
		try {
			// remove this space from available list
			int index = availableSpaces.get(l + "_" + s);
			// swap to avoid array list removal cost
			String s2 = list.get(list.size() - 1);
			Collections.swap(list, index, list.size() - 1);
			availableSpaces.put(s2, index);
			// remove at the end of list and from the map
			list.remove(list.size() - 1);
			availableSpaces.remove(l + "_" + s);
			return true;
		} catch (Exception ex) {
			throw new CanNotDeleteException("Can not delete at level: " + l
					+ "_ space: " + s);
			// return false;
		}

	}

	/**
	 * represent the action where the car exit the garage
	 * 
	 * @param vehicle
	 */
	public boolean leaveSpace(Vehicle vehicle) {
		try {
			String mIndex = existedVehicles.get(vehicle.getLicensePlate());
			String[] si = mIndex.split("_");
			int i = Integer.valueOf(si[0]);
			int j = Integer.valueOf(si[1]);

			this.getLevels().get(i).getSpaces().get(j).setVehicle(null);
			existedVehicles.remove(vehicle.getLicensePlate());
			list.add(i + "_" + j);
			availableSpaces.put(i + "_" + j, list.size() - 1);

			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	public int getNumberOfAvailableSpace() {
		return availableSpaces.size();
	}

	public String getVehicleLocation(Vehicle vehicle) {

		String mIndex = existedVehicles.get(vehicle.getLicensePlate());
		if (mIndex == null) {
			return "Not Exist.";
		} else {
			String[] si = mIndex.split("_");
			int x = Integer.valueOf(si[0]);
			int y = Integer.valueOf(si[1]);

			return "Level:" + y + " and Space:" + x;
		}
	}

	public List<Level> getLevels() {
		return levels;
	}

	public void setLevels(List<Level> levels) {
		this.levels = levels;
	}

	public int getLevelNumber() {
		return levelNumber;
	}

	public void setLevelNumber(int levelNumber) {
		this.levelNumber = levelNumber;
	}

}
