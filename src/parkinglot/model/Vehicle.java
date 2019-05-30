package parkinglot.model;

import parkinglot.constant.VehicleType;

public class Vehicle {
	
	String vehcileNum;
	VehicleType type;
	int parkingSpace;
	
	public Vehicle(String vehcileNum, VehicleType vType) {
		this.vehcileNum = vehcileNum;
		this.type = vType;
	}

	public int getParkingSpace() {
		return parkingSpace;
	}

	public void setParkingSpace(int parkingSpace) {
		this.parkingSpace = parkingSpace;
	}
	
	public String getVehcileNum() {
		return vehcileNum;
	}
	
}
