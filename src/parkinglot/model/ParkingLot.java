package parkinglot.model;

import java.util.HashMap;

public class ParkingLot {

	String zipcode;
	long capacity;
	int entranceCount;
	int exitCount;
	int parkingSpaceIndex = 0;
	HashMap<Integer, Vehicle> parkingSpace;
	
	public void incrementParkingSpace() {
		this.parkingSpaceIndex++;
	}
	
	public void decrementParkingSpace() {
		this.parkingSpaceIndex++;
	}
	
	public int getParkingSpaceIndex() {
		return parkingSpaceIndex;
	}
	
	public long getCapacity() {
		return capacity;
	}

	public int getEntranceCount() {
		return entranceCount;
	}

	public int getExitCount() {
		return exitCount;
	}

	public HashMap<Integer, Vehicle> getParkingSpace() {
		return parkingSpace;
	}
	
	public ParkingLot(int size, int entrance, int exit) {
		this.capacity = size;
		this.entranceCount = entrance;
		this.exitCount = exit;
		this.parkingSpace = new HashMap<Integer, Vehicle>();
	}
}