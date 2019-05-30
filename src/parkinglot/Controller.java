package parkinglot;

import java.util.Scanner;

import parkinglot.algorithm.Service;
import parkinglot.constant.VehicleType;
import parkinglot.model.ParkingLot;
import parkinglot.model.Vehicle;

public class Controller {
	static ParkingLot parking;
	private Service service;
	
	public Controller(int size, int entrance, int exit) {
		service = new Service();
		parking = service.createParkingLot(size, entrance, exit);
		System.out.println("Parking lot created. It has capacity of "+ parking.getCapacity() +". It has "+ parking.getEntranceCount() +" entrance and "+ parking.getExitCount() +" exit.");
	}
	

	public void execute (int choice) {
		Scanner scan = new Scanner(System.in);
		String vehicleNum;
		boolean parkingSpaceStatus;
		int parkingSpaceNum;
		switch (choice) {
			case 1:
				// call service
				parkingSpaceStatus = service.checkParkingAvailability();
				if (!parkingSpaceStatus) {
					System.out.println("Full");
				} else {
					System.out.println("Available");					
				}

				break;
				
			case 2:
				System.out.println("Choose option:");
				System.out.println("1. Use parking space no:");
				System.out.println("2. Use vehicle no:");
				int findByOption = scan.nextInt();
				if (findByOption == 1) {
					System.out.println("Enter your parking space no:");				
				    parkingSpaceNum = scan.nextInt();
				    Vehicle myVehicle = service.findMyVehicleParkingSpace(parkingSpaceNum);
				    if (myVehicle != null) {
				    	System.out.println("Your vehicle: " + myVehicle.getVehcileNum());
				    	System.out.println("And your parking space: " + myVehicle.getParkingSpace());
				    } else {
				    	System.out.println("Vehicle Not Found");
				    }					
				} else if (findByOption == 2) {
					System.out.println("Enter your vehicle no:");				
					vehicleNum = scan.next();
				    Vehicle myVehicle = service.findMyVehicleByVehcileNum(vehicleNum);
				    if (myVehicle != null) {
				    	System.out.println("Your vehicle: " + myVehicle.getVehcileNum());
				    	System.out.println("And your parking space: " + myVehicle.getParkingSpace());
				    } else {
				    	System.out.println("Vehicle Not Found");
				    }									    
				} else {
					System.out.println("Invalid choice for find my vehicle option");
				}
				break;
			
			case 3: 
				parkingSpaceStatus = service.checkParkingAvailability();
				if (!parkingSpaceStatus) {
					System.out.println("Full");
				} else {
					System.out.println("Enter your vehcile no:");
				    vehicleNum = scan.next();
					System.out.println("Enter your vehcile type <S, M, L, XL>:");
				    String vehicleType = scan.next();
					Vehicle vehicle = new Vehicle(vehicleNum, VehicleType.valueOf(vehicleType.toUpperCase()));
					Vehicle addedVehicle = service.addVehicle(vehicle);
					System.out.println("Your parking space no: " + addedVehicle.getParkingSpace());
				}
				break;				
				
			case 4:
				System.out.println("Enter your parking space no:");
			    parkingSpaceNum = scan.nextInt();
			    Vehicle exitVehicle = service.exitMyVehicle(parkingSpaceNum);
			    if (exitVehicle != null) {
			    	System.out.println("Your vehicle: " + exitVehicle.getVehcileNum());
			    } else {
			    	System.out.println("Vehicle Not Found");
			    }
				break;
				
			default: System.out.println("Invalid selection. Try Again");
		}
	}
	
}
