package unit_3_recurSort;

/**
 * Program that makes f(n) = f(n-1) + 2, t1 = 1
 * @author Bianca
 * @version Nov 22, 2023
 */

public class A1_RecursionLesson {

	/**
	 * Function that determines the nth number in the odd number pattern.
	 * @param n - term number
	 * @return the nth number
	 */
	public static int f(int n) {
		// First term
		if (n == 1) {
			return 1; // base case
		}
		// Not the first term
		else {
			return f(n-1) + 2; // recursive case
		}
	}
	
	public static void main(String[] args) {
		System.out.println(f(3));

	}

}
