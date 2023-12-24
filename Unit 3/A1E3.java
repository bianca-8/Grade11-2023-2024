package unit_3_recur_sort;

/**
 * Program that writes the nth factorial with the full expansion.
 * @author Bianca
 * @version Nov 22, 2023
 */

public class A1E3 {

	/**
	 * Function that finds the nth factorial.
	 * @param n - term number
	 * @return the nth number
	 */
	public static int factorial(int n) {
		// base case
		if (n==1) {
			return 1;
		}
		// not base case
		else {
			return factorial(n-1)*n;
		}

	}
	
	public static void main(String[] args) {
		int term = 10;
		
		System.out.print(term + "! = ");
		// prints out full expansion of nth factorial
		for (int i = term; i > 1; i--) {
			System.out.print(i + " X ");
		}
		System.out.print("1 = " + factorial(term));

	}

}
