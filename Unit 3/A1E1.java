package unit_3_recur_sort;

/**
 * Program that displays the nth triangular number.
 * @author Bianca
 * @version Nov 22, 2023
 */

public class A1E1 {

	/**
	 * Function that finds the nth triangular number.
	 * @param n - term number
	 * @return the nth number
	 */
	public static int triangle(int n) {
		// first term - base case
		if (n == 1) {
			return 1;
		}
		// not the first term
		else {
			return triangle(n-1) + n;
		}
	}
	
	public static void main(String[] args) {
		System.out.print(triangle(10));

	}

}
