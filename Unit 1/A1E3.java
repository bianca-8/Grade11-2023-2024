package unit_1_OOP;

/**
 * Program that calculates amount of change.
 * @author Bianca
 * @version Oct 6, 2023
 */

import java.util.*;

public class A1E3 {

	public static void main(String[] args) {
		// Variables
		int toonies;
		int dollars;
		int quarters;
		int dimes;
		int nickels;
		double total;
		
		// Input
		Scanner input = new Scanner(System.in);
		
		System.out.print("toonies: ");
		toonies = input.nextInt();
		
		System.out.print("dollars: ");
		dollars = input.nextInt();
		
		System.out.print("quarters: ");
		quarters = input.nextInt();
		
		System.out.print("dimes: ");
		dimes = input.nextInt();
		
		System.out.print("nickels: ");
		nickels = input.nextInt();
		
		input.close();
		
		total = coin(toonies,2) + coin(dollars,1) + coin(quarters,0.25) + coin(dimes,0.1) + coin(nickels,0.05);
		
		// Print
		System.out.format("total is $%.2f", total);

	}
	
	public static double coin(int amt, double value) {
		// Variables
		double total;
		
		// Calculations
		total = amt * value;
		
		return total;
	}

}
