package parkinglot.algorithm;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Stack;

import parkinglot.model.ParkingLot;
import parkinglot.model.Vehicle;

public class Service {
	private ParkingLot parkingLot;
	private Stack<Integer> vaccantSpace = new Stack<Integer>();
	
	public ParkingLot getParkingLot() {
		return parkingLot;
	}
	
	public ParkingLot createParkingLot(int size, int entrance, int exit) {
		ParkingLot pl = new ParkingLot(size, entrance, exit);
		this.parkingLot = pl;
		return this.parkingLot;
	}
	
	public boolean checkParkingAvailability() {
		boolean status = true;
		if(!vaccantSpace.isEmpty() || this.parkingLot.getParkingSpace().size() < this.parkingLot.getCapacity()) {
			status = true;
		} else 
			status = false;
		return status;
	}

	public Vehicle addVehicle(Vehicle vehicle) {
		int parkingSpace;
		if (!vaccantSpace.isEmpty()) {
			parkingSpace = vaccantSpace.peek();
			vehicle.setParkingSpace(parkingSpace);
			this.parkingLot.getParkingSpace().put(parkingSpace, vehicle);			
		} else {
			parkingSpace = this.parkingLot.getParkingSpaceIndex();
			vehicle.setParkingSpace(parkingSpace);
			this.parkingLot.getParkingSpace().put(parkingSpace, vehicle);
			this.parkingLot.incrementParkingSpace();			
		}
		return vehicle;
	}

	public Vehicle findMyVehicleParkingSpace(int parkingSpaceIndex) {
		return this.parkingLot.getParkingSpace().get(parkingSpaceIndex);
	}

	public Vehicle exitMyVehicle(int parkingSpaceIndex) {
		Vehicle vehicle = this.parkingLot.getParkingSpace().put(parkingSpaceIndex, null);
		vaccantSpace.add(parkingSpaceIndex);
		return vehicle;
	}

	public Vehicle findMyVehicleByVehcileNum(String vehicleNum) {
		Vehicle vehicle = null;
		HashMap<Integer, Vehicle> map = this.parkingLot.getParkingSpace();
		for (Entry<Integer, Vehicle> entry : map.entrySet()) {
			if (entry.getValue().getVehcileNum().equals(vehicleNum)) {
				vehicle = entry.getValue();
			}
		}
		return vehicle;
	}

}
