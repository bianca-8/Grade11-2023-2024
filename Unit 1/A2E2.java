package unit_0_java_basics;
/**
 * Program that stores prices and prints the sum formatted.
 * @author Bianca
 * @version Sept. 11, 2023
 */
public class A2E2 {

	public static void main(String[] args) {
		// Variables
		double price1 = 2.55;
		double price2 = 3.20;
		double price3 = 4.00;

		// Calculate sum
		double sum = price1 + price2 + price3;

		// Print
		System.out.format("%-11s", "Item one:");
		System.out.format("%5s %5.2f\n", "$", price1);
		System.out.format("%-11s", "Item two:");
		System.out.format("%5s %5.2f\n", "$", price2);
		System.out.format("%-10s", "Item three:");
		System.out.format("%5s %5.2f\n", "$", price3);
		System.out.format("%23s", "-------\n");
		System.out.format("%-10s", "Total cost:");
		System.out.format("%5s %5.2f\n", "$", sum);

	}

}
