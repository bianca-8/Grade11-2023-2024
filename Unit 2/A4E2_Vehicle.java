package unit_2_robots;

import java.util.Random;

/**
 * Program that overrides a drive method for 3 cars.
 * @author Bianca
 * @version Nov 27, 2023
 */

public abstract class A4E2_Vehicle {
	private String name;
	private double price;

	public static void main(String[] args) {
		A4E2_Vehicle [] vehicles = new A4E2_Vehicle[3];
		vehicles[0] = new A4E2_Cybertruck();
		vehicles[1] = new A4E2_Car();
		vehicles[2] = new A4E2_Van();
		
		Random r = new Random();
		
		int choice = r.nextInt(3);
		
		System.out.println(vehicles[choice].getName());
		System.out.println("$" + vehicles[choice].getPrice());
		vehicles[choice].drive();
	}
	
	/**
	 * Constructor method for the vehicle class.
	 * @param name - name of the vehicle
	 * @param price - price of the vehicle
	 */
	public A4E2_Vehicle(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public abstract void drive();

	/**
	 * Gets the name of the vehicle.
	 * @return name of the vehicle
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the price of the vehicle.
	 * @return the price of the vehicle
	 */
	public double getPrice() {
		return price;
	}
}

