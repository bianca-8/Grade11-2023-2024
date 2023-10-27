package unit_0_java_basics;

/**
 * Program that prints out x prime numbers entered by user.
 * @author Bianca
 * @version Sept 18, 2023
 */

import java.util.Scanner;

public class A5E1b {

	public static void main(String[] args) {

		// Variables
		int prime; // amount of prime numbers
		int print = 0; // amount of prime numbers found
		int factor = 0; // number of non - factors to test for prime numbers

		// Input
		Scanner input = new Scanner(System.in);
		System.out.print("Enter amount of prime numbers: ");
		prime = input.nextInt();
		input.close();

		// Prints prime numbers
		for (int i = 2; print < prime; i++) { // all numbers until print # entered by user
			for (int j = 1; j <= i; j++) { // tests factors
				if (i % j == 0 && j != 1) { // composite number
					break;
				}
				else { // prime number
					factor++;

					if (factor == i - 1) {
						System.out.println(i);
						print++;
						break;

					}
				}
			}
			factor = 0;
		}

	}

}
