package unit_0_java_basics;

import java.util.Scanner;

/**
 * Cash register program with 3 products entered by user plus tax.
 * @author Bianca
 * @version Sept. 12, 2023
 */
public class A3E2 {

	public static void main(String[] args) {
		// Variables
		String product1;
		String product2;
		String product3;
		double cost1;
		double cost2;
		double cost3;
		final double HST = 0.13;

		// User input
		Scanner input = new Scanner(System.in);
		System.out.print("Enter product one name: ");
		product1 = input.nextLine();
		System.out.print("Enter product one cost: ");
		cost1 = input.nextDouble();
		input.nextLine();
		System.out.print("Enter product two name: ");
		product2 = input.nextLine();
		System.out.print("Enter product two cost: ");
		cost2 = input.nextDouble();
		input.nextLine();
		System.out.print("Enter product three name: ");
		product3 = input.nextLine();
		System.out.print("Enter product three cost: ");
		cost3 = input.nextDouble();
		input.nextLine();
		input.close();
		System.out.print("\n");
		
		
		// Calculate HST and total
		double tax = (cost1 + cost2 + cost3) * HST;
		double total = cost1 + cost2 + cost3 + tax;

		// Print
		System.out.println("WOSS Gift Shop Receipt");
		System.out.println("----------------------\n");
		System.out.format("%-10s", product1);
		System.out.format("%5s%5.2f\n", "$", cost1);
		System.out.format("%-10s", product2);
		System.out.format("%5s%5.2f\n", "$", cost2);
		System.out.format("%-10s", product3);
		System.out.format("%5s%5.2f\n", "$", cost3);
		System.out.format("%22s", "-------\n");
		System.out.format("%-10s", "HST (13%)");
		System.out.format("%5s%5.2f\n", "$", tax);
		System.out.format("%22s", "-------\n");
		System.out.format("%-10s", "TOTAL");
		System.out.format("%5s%5.2f\n", "$", total);

	}

}
