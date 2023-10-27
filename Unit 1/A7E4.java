package unit_0_java_basics;

import java.util.*;

/**
 * Program that creates a Eratosthenes’s Sieve from 2 to 1000000, gets a user inputed number and displays prime factors.
 * @author Bianca
 * @version Oct 2, 2023
 */

public class A7E4 {

	public static void main(String[] args) {

		// Variables
		int num; // number inputed by user
		boolean [] sieve = new boolean[1000000];

		// Input
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter a number (<1000000): ");
		num = input.nextInt();
		input.close();

		// Add boolean to array
		for (int i = 2; i <= num; i++) { // numbers from 2 to the number
			sieve[i] = true;
		}

		// Calculate Factors
		for (int l = 2; l <= num; l++) { // numbers up until the number entered by user, starts at 2
			for (int j = 1; j < l; j++) { // numbers up until l, starts at 2
				if (l % j == 0 && sieve[l] == true && j != 1) { // composite number
					for (int k = 2; j * k <= num; k++) { // multiples of the composite number
						sieve[j * k] = false;
					}
				}
			}
		}

		// Print
		if (sieve[num] == true) { // is a prime number
			System.out.format("Prime Factors: \n1\n%d", num);
		}
		else { // not a prime number
			System.out.print("Prime Factors: \n1");
			for (int m = 2; m <= num; m++) { // numbers up to user entered number
				if (sieve[m] == true) { // is a prime number
					if (num % m == 0) { // divides evenly, is a prime factor
						num /= m;
						System.out.print("\n" + m);
					}
				}
			}
		}

	}

}
