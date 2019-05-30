/**
 * 
 */
package parkinglot;

import java.util.Scanner;


/**
 * @author kumarrahul
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		Controller ctrl;
		System.out.println("Create Parking lot:");
		System.out.println("1. Enter capacity:");
	    int size = scan.nextInt();
		System.out.println("2. Total entrance:");
	    int entrance = scan.nextInt();	    
		System.out.println("2. Total exit:");
	    int exit = scan.nextInt();	    	    
	    
	    
	    ctrl = new Controller(size, entrance, exit);
	    
		while(true) {
		    System.out.println("===============");			
			System.out.println("1. Check Pakring Availability");			
			System.out.println("2. Find my vehicle");			
			System.out.println("3. Add my vehicle");						
			System.out.println("4. Exit my vehicle");						
//			System.out.println("5. Logout");			
    	    int choice = scan.nextInt();
    	    ctrl.execute(choice);    	    
		}
		
	}

}
