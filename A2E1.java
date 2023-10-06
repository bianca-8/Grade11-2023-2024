package unit_0_java_basics;
/**
 * Program that stores prices and prints the sum.
 * @author Bianca
 * @version Sept. 11, 2023
 */
public class A2E1 {

	public static void main(String[] args) {
		// Variables
		double price1 = 2.55;
		double price2 = 3.20;
		double price3 = 4.00;
		
		// Calculate sum
		double sum = price1 + price2 + price3;
		
		// Print
		System.out.format("$%.2f + $%.2f + $%.2f = $%.2f", price1, price2, price3, sum);

	}

}
