package unit_0_java_basics;

/**
 * Program that averages marks entered.
 * @author Bianca
 * @version Sept 18, 2023
 */

import java.util.*;

public class A5E2a {

	public static void main(String[] args) {
		
		// Variables
		int amount;
		int marks = 0;
		int markAmt = 0;
		double average = 0;
		
		// Input
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the amount of marks: ");
		amount = input.nextInt();
		input.nextLine();
		
		// Enter marks
		while (markAmt < amount) {
			System.out.print("Enter a mark: ");
			marks = input.nextInt();
			if (marks >= 0 && marks <= 100) {
				average += marks;
				markAmt++;
			}
			else {
				System.out.println("Please enter a valid mark.");
			}
		}
		input.close();
		
		// Math
		average /= amount;
		
		// Print
		System.out.format("The average is %.2f.", average);

	}

}
