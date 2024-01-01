package unit_2_robots;

/**
 * Program that makes a cybertruck which makes a sound when told to drive.
 * @author Bianca
 * @version Nov 27, 2023
 */

public class A4E2_Cybertruck extends A4E2_Vehicle {
	
	/**
	 * Initialize vehicle
	 */
	public A4E2_Cybertruck() {
		super("Cybertruck", 405309.50);
	}
	
	/**
	 * Override drive method
	 */
	public void drive() {
		System.out.print("Vroom");
	}
}
