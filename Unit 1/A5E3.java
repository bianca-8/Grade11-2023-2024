package unit_0_java_basics;

/**
 * Program that finds 3 digit numbers equal to the sum of the cubes of its digits.
 * @author Bianca
 * @version Sept 18, 2023
 */

public class A5E3 {

	public static void main(String[] args) {
		
		// Variables
		int num = 0;
		
		// Find all 3 digit numbers
		for (int dig1 = 1; dig1 < 10; dig1++) { // hundreds
			for (int dig2 = 0; dig2 < 10; dig2++) { // tens
				for (int dig3 = 0; dig3 < 10; dig3++) { // ones
					num = dig1 * 100 + dig2 * 10 + dig3; // final number
					if (Math.pow(dig1, 3) + Math.pow(dig2, 3) + Math.pow(dig3, 3) == num) { // Finds cubes of digits of number
						System.out.format("%d^3 + %d^3 + %d^3 = %d\n", dig1, dig2, dig3, num); 
					}
				}
			}
		}

	}

}
