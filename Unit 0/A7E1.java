package unit_0_java_basics;

import java.util.Scanner;

/**
 * Program that determines if 5 doubles are in order from least to greatest without using sort
 * @author Bianca
 * @version Sept 29, 2023
 */

public class A7E1 {

	public static void main(String[] args) {
		
		// Variables
		final int length = 5;
		double [] num = new double [length];
		boolean order = true;

		// User Input
		Scanner input = new Scanner(System.in);
		for (int i = 0; i<=length-1; i++) { // for the length of the list
			System.out.print("Enter a double: ");
			num [i] = input.nextDouble();
		}
		input.close();
		
		// Checks if numbers are in order
		for (int j = 0; j<=length-2; j++) {
			if (num[j] > num[j+1]) { // The next number is greater than the first number
				order = false;
			}
		}
		
		// Print
		System.out.format("The doubles are in order: %b.", order);
	}

}