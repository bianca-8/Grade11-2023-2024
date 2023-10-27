package unit_0_java_basics;

import java.util.Scanner;

/**
 * Program that shows the credit card payment schedule.
 * @author Bianca
 * @version Sept 25, 2023
 */

public class BianCredit {

	public static void main(String[] args) {

		// Variables
		double initBal; // Initial balance on the credit card
		double purchases; // Monthly charge from purchases
		double rate; // Annual interest rate
		double interest = 0; // Amount of interest
		double payment; // Monthly payment amount
		double debt; // Balance owed per month
		final double minPay = 10; // Minimum payment amount
		int month = 0; // Months to pay off credit card
		int years; // Years to pay off credit card
		double purchaseTotal; // Total cost of purchases
		double extra = 0; // Money that is left unused from payment
		String monthGrammar = "month"; // add s in "months" when # of months is greater than 0


		// User Input
		Scanner input = new Scanner(System.in);

		// Initial balance on the credit card
		System.out.print("Please enter the current amount on the credit card: $");
		initBal = input.nextDouble();	
		
		while (initBal < 0) { // Invalid input where initial balance is smaller than $0
			System.out.println("The initial balance must be greater than 0.");
			System.out.print("Please enter the current amount on the credit card: $");
			initBal = input.nextDouble();
		}
		// Charge from monthly purchases
		System.out.print("Please enter the monthly charge: $");
		purchases = input.nextDouble();
		
		while (purchases < 0) { // Invalid input where monthly purchases is smaller than $0
			System.out.println("The monthly purchases must be greater than 0.");
			System.out.print("Please enter the monthly charge: $");
			purchases = input.nextDouble();
		}

		// Annual interest rate
		System.out.print("Please enter the annual interest rate: %");
		rate = input.nextDouble();
		while (rate < 0) { // Invalid input where annual interest rate is smaller than 0%
			System.out.println("The interest rate must be greater than 0.");
			System.out.print("Please enter the annual interest rate: %");
			rate = input.nextDouble();
		}
		// Amount paid monthly
		System.out.print("Please enter the monthly payment amount: $");
		payment = input.nextDouble();

		while (payment < 10) { // Invalid input where the monthly payment amount is smaller than the minimum
			System.out.format("The minimum payment is $%.2f/month.\n", minPay);
			System.out.print("Please enter the monthly payment amount: $");
			payment = input.nextDouble();
		}

		input.close();


		// Calculate monthly interest rate
		rate = rate / 100 / 12;
		debt = initBal; // Initialize debt variable


		// Print
		System.out.format("\n%s%28s%18s%26s%23s%31s%26s\n", "Month", "Initial Balance", "Interest", "Purchases", "Payment", "Balance Owing", "Money Leftover");
		while (debt < 100000 && debt > 0) { // debt is between $0 and $100000
			initBal = debt;
			interest = rate * initBal;
			debt = initBal + interest + purchases - payment;
			month++;

			// Calculate money left that wasn't used in payment
			if (debt < 0) { // there is a greater payment amount than debt amount
				debt = 0;
				extra = payment - purchases - initBal - interest;
			}

			System.out.format("%-4s%15s%-10.2f%15s%-10.2f%15s%-10.2f%15s%-10.2f%15s%-10.2f%15s%-10.2f\n", month, "$", initBal, "$", interest, "$", purchases, "$", payment, "$", debt, "$", extra);
		}

		// Calculate time taken to pay off credit card
		purchaseTotal = purchases * month;

		years = month / 12;
		month = month % 12;

		// Grammar for month(s)
		if (month > 1) { // months are greater than one, so the correct grammar is "months"
			monthGrammar = "months";
		}


		// Conclusion statement
		if (debt <= 0) { // The debt has been paid off
			System.out.format("\nIt will take %d years and %d %s to pay off your credit card. You spent a total of $%.2f in purchases and $%.2f was charged in interest.\n", years, month, monthGrammar, purchaseTotal, interest);
		}
		else { // The debt has exceeded $100000
			System.out.format("\nYou will be in debt by $100000.00 or more after %d years and %d months. You spent a total of $%.2f in purchases and $%.2f was charged in interest.", years, month, purchaseTotal, interest);
		}


	}
}
