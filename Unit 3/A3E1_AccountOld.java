package unit_3_recur_sort;

import java.util.*;

/**
 * Program that creates an account.
 * @author Bianca Bian
 * @version Dec 7, 2023
 */

public class A3E1_AccountOld {

	// Variables
	private double balance;
	private String name;
	private int accountNum;

	/**
	 * Method that gets the account number of the user.
	 * @param acctNum - account number of the user.
	 * @param clientName - name of the user.
	 * @param initialBal - initial balance of the account.
	 */
	public A3E1_AccountOld(int acctNum, String clientName, double initialBal) {
		this.accountNum = acctNum;
		this.name = clientName;
		this.balance = initialBal;
	}

	/**
	 * Overload Account constructor to take in a Scanner
	 * @param fileInput - scanner for file
	 */
	public A3E1_AccountOld(Scanner fileInput) {
		// has more lines
		while (fileInput.hasNextLine()) {
			int num = fileInput.nextInt();
			// account in file matches with account number given by user
			if (num == this.accountNum) {
				this.balance = fileInput.nextDouble();
				this.name = fileInput.nextLine().strip();
			}
		}
	}

	/**
	 * Method that deposits money to the account.
	 * @param amount - amount that is deposited by the user.
	 */
	public void deposit(double amount) {
		// not depositing negative
		if (amount >= 0) {
			this.balance += amount;
			System.out.format("Your new balance is: $%.2f.\n", this.balance);
		}
		// depositing positive
		else {
			System.out.print("Invalid amount\n");
		}
	}

	/**
	 * Method that withdraws money from the account.
	 * @param amount - amount that is withdrawn by the user.
	 */
	public void withdraw(double amount) {
		// amount to withdraw is greater than money in account
		if (this.balance > amount && amount >= 0) {
			this.balance -= amount;
			System.out.format("Your new balance is: $%.2f.\n", this.balance);
		}
		// amount to withdraw is within money in account
		else {
			System.out.print("You do not have this much money to withdraw.\n");
		}
	}

	/**
	 * Method that returns the balance of the user.
	 * @return balance in the account.
	 */
	public double getBalance() {
		return this.balance;
	}

	/**
	 * Return the name of the user.
	 * @return - name of the user.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Method that returns the account number of the user.
	 * @return account number of the user.
	 */
	public int getAccountNum() {
		return this.accountNum;
	}

}
