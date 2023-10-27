package unit_0_java_basics;

import java.util.*;

/**
 * Program that generates 25 random ints and displays even and odd separated.
 * @author Bianca
 * @version Sept 29, 2023
 */

public class A7E2 {

	@SuppressWarnings({ "rawtypes", "unchecked", "removal" })
	public static void main(String[] args) {
		
		// Variables
		final int amount = 25; // number of random integers
		int num; // random integer
		int range = 99; // maximum random number value
		
		// ArrayList
		ArrayList odd = new ArrayList();
		ArrayList even = new ArrayList();
		
		// Random
		Random generator = new Random();
		
		for (int i=0; i<amount; i++) {
			num = generator.nextInt(range+1);
			if (num % 2 == 0) { // even
				even.add(new Integer(num));
			}
			else { // odd
				odd.add(new Integer(num));
			}
		}
		
		// Print
		System.out.println("ODD: ");
		for (int i = 0; i<odd.size(); i++) {
			System.out.print(odd.get(i) + " ");
		}
		System.out.println("\nEVEN: ");
		for (int i = 0; i<even.size(); i++) {
			System.out.print(even.get(i) + " ");
		}
	}

}
