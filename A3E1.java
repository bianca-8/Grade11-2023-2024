package unit_0_java_basics;

import java.util.Scanner;

/**
 * Program showing mailing address entered in a box of X's.
 * @author Bianca
 * @version Sept. 12, 2023
 */
public class A3E1 {

	public static void main(String[] args) {
		// variables
		String name, address, city;
		
		// User input
		Scanner input = new Scanner(System.in);
		System.out.print("Enter your name: ");
		name = input.nextLine();
		System.out.print("Enter your address: ");
		address = input.nextLine();
		System.out.print("Enter your city: ");
		city = input.nextLine();
		input.close();
		

		// Print command
		System.out.format("%90s\n", "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.format("%50s ", "X");
		System.out.format("%-30s",  name);
		System.out.format("%9s\n", "X");
		System.out.format("%50s ", "X");
		System.out.format("%-30s",  address);
		System.out.format("%9s\n", "X");
		System.out.format("%50s ", "X");
		System.out.format("%-30s",  city);
		System.out.format("%9s\n", "X");
		System.out.format("%90s", "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

	}

}
