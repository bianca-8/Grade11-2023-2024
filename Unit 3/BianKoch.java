package unit_3_recur_sort;

import java.util.*;

public class BianKoch {

	public static int koch(int n) {
		// first term - base case
		if (n == 1) {
			return 3;
		}
		// not the first term
		else {
			return koch(n-1)*4;
		}
	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int num;


		System.out.print("Please enter the Koch Snowflake number ==> ");
		num = input.nextInt();
		input.close();
		
		System.out.print("There are " + koch(num) + " sides.");

	}

}
