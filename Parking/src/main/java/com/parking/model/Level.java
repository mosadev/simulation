package com.parking.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Level {

	private int levelNumber = -1 ; 
	private int spaceNumberPerLevel = -1 ;
	
	private List<Space> spaces = new ArrayList<Space>();

	 
	public Level(int levelNumber, int spaceNumberPerLevel) {
		setLevelNumber(levelNumber);
		setSpaceNumberPerLevel(spaceNumberPerLevel);
		for (int i = 0; i < spaceNumberPerLevel; i++) {
			Space space = new Space(i);
			this.getSpaces().add(space);
		}

	}

	
	public boolean isFull(){ 
		if(this.getSpaces().size() < this.getSpaceNumberPerLevel()){
			return false;
		}
		return true;
	}
	
	public List<Space> getSpaces() {
		return spaces;
	}

	public void setSpaces(List<Space> spaces) {
		this.spaces = spaces;
	}

	public int getLevelNumber() {
		return levelNumber;
	}

	public void setLevelNumber(int levelNumber) {
		this.levelNumber = levelNumber;
	}

	public int getSpaceNumberPerLevel() {
		return spaceNumberPerLevel;
	}

	public void setSpaceNumberPerLevel(int spaceNumberPerLevel) {
		this.spaceNumberPerLevel = spaceNumberPerLevel;
	}

}
