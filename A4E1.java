package unit_0_java_basics;

import java.util.Scanner;

/**
 * Program that writes a receipt.
 * @author Bianca
 * @version Sept. 14, 2023
 */
public class A4E1 {

	public static void main(String[] args) {
		
		// Variables
		double cost;
		double tax;
		double totalCost;
		double taxCost;
		final double TAX1 = 0.05;
		final double TAX2 = 0.13;
		final int CUTOFF = 4;
		
		// User input
		Scanner input = new Scanner(System.in);
		System.out.print("Enter meal cost: ");
		cost = input.nextDouble();
		System.out.print("\n");
		input.close();
		
		// Checks cost at cutoff or under
		if (cost <= CUTOFF) {
			tax = TAX1;
		}
		else {
			tax = TAX2;
		}
		
		// Calculations
		taxCost = cost * tax;
		totalCost = cost + taxCost;
		
		tax *= 100;
		
		// Print
		System.out.format("%73s\n", "Meal Receipt");
		System.out.format("%79s\n", "------------------------");
		System.out.format("%73s%5.2f\n", "Cost before tax: $", cost);
		System.out.format("%66s%2.0f%s%5.2f\n", "Tax (", tax, "%): $", taxCost);
		System.out.format("%73s%5.2f", "Total Cost: $", totalCost);

	}

}
