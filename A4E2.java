package unit_0_java_basics;

import java.util.Scanner;

/**
 * Program that calculates federal tax.
 * @author Bianca
 * @version Sept. 14, 2023
 */

public class A4E2 {

	public static void main(String[] args) {

		// Variables
		double income;
		final int stage = 27500; // Stages of tax 1 and 2
		final double TAX1 = 0.17; // First stage of tax
		final double TAX2 = 0.24; // Second stage of tax
		final double TAX3 = 0.29; // Rest of income
		double tTax1; // total tax paid at 17%
		double tTax2; // total tax paid at 24%
		double tTax3; // total tax paid at 29%
		double totalTax;

		// Input
		Scanner input = new Scanner(System.in);
		System.out.print("Enter taxable income: ");
		income = input.nextDouble();
		input.nextLine();
		input.close();

		// Checks income
		if (income - stage > 0) { // money is greater than first stage of tax
			tTax1 = stage * TAX1;
			income -= stage;

			if (income - stage > 0) { // money is greater than second stage of tax
				tTax2 = stage * TAX2;
				income -= stage;
				tTax3 = income * TAX3;
		
			}
			else {
				tTax2 = income * TAX2; // money is smaller than second stage of tax
				tTax3 = 0;
			}
		}
		else { // money is less than first stage of tax
			tTax1 = income * TAX1;
			tTax2 = 0;
			tTax3 = 0;
		}

		// Calculate federal tax
		totalTax = tTax1 + tTax2 + tTax3;

		// Print
		System.out.format("Federal Tax: $%.2f", totalTax);

	}

}
