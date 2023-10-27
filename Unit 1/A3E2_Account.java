package unit_1_introOOP;

public class A3E2_Account {

	// Variables
	private double balance;
	private int accountNum;
	
	/**
	 * Method that gets the account number of the user.
	 * @param acctNum - account number of the user.
	 */
	public A3E2_Account(int acctNum) {
		accountNum = acctNum;
		balance = 0;
	}
	
	/**
	 * Method that deposits money to the account.
	 * @param amount - amount that is deposited by the user.
	 */
	public void deposit(double amount) {
		balance += amount;
	}
	
	/**
	 * Method that withdraws money from the account.
	 * @param amount - amount that is withdrawn by the user.
	 */
	public void withdraw(double amount) {
		if (balance - amount >= 0) {
			balance -= amount;
		}
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
