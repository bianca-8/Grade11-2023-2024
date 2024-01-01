package unit_2_robots;

/**
 * Program that makes a car which makes a sound when told to drive.
 * @author Bianca
 * @version Nov 27, 2023
 */

public class A4E2_Car extends A4E2_Vehicle {
	
	/**
	 * Initialize vehicle
	 */
	public A4E2_Car() {
		super("Car", 19999.99);
	}
	
	/**
	 * Override drive method
	 */
	public void drive() {
		System.out.print("Beep");
	}
}
