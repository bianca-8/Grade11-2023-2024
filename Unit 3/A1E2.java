package unit_3_recurSort;

/**
 * Program that displays the first n terms of the Fibbonaci sequence.
 * @author Bianca
 * @version Nov 22, 2023
 */

public class A1E2 {

	/**
	 * Function that finds the nth term of the Fibbonaci sequence
	 * @param n - term number
	 * @return the nth number
	 */
	public static int fibb(int n) {
		// base case
		if (n == 1) {
			return 1;
		}
		// base case
		if (n == 2) {
			return 1;
		}
		// not base case
		else {
			return fibb(n - 1) + fibb(n - 2);
		}
	}
	
	public static void main(String[] args) {
		int term = 10;
		
		// prints out all of the terms leading up to the term number
		for (int i = 1; i <= term; i++) {
			System.out.print(fibb(i) + " ");
		}

	}

}
