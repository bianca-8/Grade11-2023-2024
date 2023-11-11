package unit_1_OOP;

/**
 * Class that deposits, withdraws and gets balance of the account.
 * @author Bianca
 * @version Oct 20, 2023
 */

public class A3E2_Account {

	// Variables
	private double balance;
	private int accountNum;
	
	/**
	 * Method that gets the account number of the user.
	 * @param acctNum - account number of the user.
	 */
	public A3E2_Account(int acctNum) {
		this.accountNum = acctNum;
		this.balance = 0;
	}
	
	/**
	 * Method that deposits money to the account.
	 * @param amount - amount that is deposited by the user.
	 */
	public void deposit(double amount) {
		// not depositing negative
		if (amount >= 0) {
			this.balance += amount;
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
	 * Method that returns the account number of the user.
	 * @return account number of the user.
	 */
	public int getAccountNum() {
		return this.accountNum;
	}
	
	
}
