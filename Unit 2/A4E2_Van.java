package unit_2_robots;

/**
 * Program that makes a van which makes a sound when told to drive.
 * @author Bianca
 * @version Nov 27, 2023
 */

public class A4E2_Van extends A4E2_Vehicle {
	
	/**
	 * Initialize vehicle
	 */
	public A4E2_Van() {
		super("Van", 20850.85);
	}
	
	/**
	 * Override drive method.
	 */
	public void drive() {
		System.out.print("Honk");
	}
}