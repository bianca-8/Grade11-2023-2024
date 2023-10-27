package unit_0_java_basics;

/**
 * Program that prints out the factors of a number.
 * @author Bianca
 * @version Sept 18, 2023
 */

import java.util.Scanner;

public class A5E1a {

	public static void main(String[] args) {
		
		// Variables
		int number;
		
		// User Input
		Scanner input = new Scanner (System.in);
		System.out.print("Enter a number: ");
		number = input.nextInt();
		System.out.print("\n");
		input.close();
		
		// Print
		System.out.println("number\t\tfactors");
		System.out.print("10\t\t");
		
		
		// Finds factors of number
		for (int i = 1; i <= number; i++) {
			
			if (number % i == 0) {
				System.out.print(i + "\t");
			}
		}

	}

}
