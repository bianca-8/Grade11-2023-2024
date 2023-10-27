package unit_1_introOOP;

import java.util.*;

/**
 * Program that shows a bank account.
 * @author Bianca
 * @version Oct 20, 2023
 */

public class A3E2 {

	public static void main(String[] args) {
		// Variables
		int accountNum;
		
		// Input
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the account number: ");
		accountNum = input.nextInt();
		
		// Connect to actions
		A3E2_Account action = new A3E2_Account(accountNum);
		
		while (true) {
			System.out.print("Enter an action (-1 to stop): ");
			String word = input.next();
			
			if (word.equals("-1")) {
				break;
			}
			
			else if (word.equals("deposit")) {
				System.out.print("Enter the deposit amount: ");
				action.deposit(input.nextDouble());
				System.out.format("Balance: $%.2f\n", action.getBalance());
			}
			else if (word.equals("withdraw")) {
				System.out.print("Enter the withdraw amount: ");
				action.withdraw(input.nextDouble());
				System.out.format("Balance: $%.2f\n", action.getBalance());
			}
			else if (word.equals("balance")) {
				System.out.format("Balance: $%.2f\n", action.getBalance());
			}
			else if (word.equals("account")) {
				System.out.format("Account number: %d\n", action.getAccountNum());
			}
			else {
				System.out.println("Enter a valid action.");
			}
		}
		
		input.close();
	}
}
