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
		boolean [] sieve;
		
		// Input
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter a number (<1000000): ");
		num = input.nextInt();
		sieve = new boolean[num];
		input.close();
		
		// Calculate factors
		for (int i = 0; i < num; i++) { // numbers up until the number entered by user, starts at 2
			sieve[i] = true;
			for (int j = 0; j < i; j++) { // numbers up until i, starts at 1
				if ((i + 1) % (j + 1) == 0 && j != 1) { // has factors
					//System.out.println(i + " " + (i+1)%(j+1));
					for (int k = 1; (i + 1) * k < num; k++) { // multiples of the number that has factors
						sieve[(i+1)*k] = false;
						System.out.print(sieve[i]);
					}
				}
			}
		}
		System.out.print(sieve[6]);
		
	}

}
