package unit_3_recur_sort;

import java.util.Scanner;
import java.io.*;

/**
 * Creates lots of accounts of its clients.
 * @author Bianca
 * @version Dec 7, 2023
 */

public class A3E1_BranchApplication {

	public static void main(String[] args) {
		String file = "accounts";
		String choice;
		double amount;
		int acctNum = 0;
		String name = "";
		double initBal = 0;
		String line;
		int num;
		Scanner input = new Scanner(System.in);

		A3E1_Account account = new A3E1_Account(acctNum, name, initBal);

		// menu
		System.out.print("Welcome to the WOSS Bank!\n\n");

		System.out.print("What is your account number: ");
		acctNum = input.nextInt();

		// get input from file
		try {
			Scanner scanner = new Scanner(new File(file));
			// has more lines
			while(scanner.hasNextLine()) {
				num = scanner.nextInt();
				
				// number entered matches account numbers stored
				if (num == acctNum) {
					line = scanner.nextLine().strip();
					break;
				}
				// account number entered doesn't exist
				else {
					System.out.print("Please enter a valid account number: ");
					acctNum = input.nextInt();
				}
			}
		}
		// file not found
		catch(FileNotFoundException ex) {
			System.out.println("File not Found");
			System.exit(0);
		}

		System.out.format("\nHello #%d,\n\n"
				+ "What would you like to do?\n"
				+ "1. Access account\n"
				+ "2. Sort by amount using Bubble Sort\n"
				+ "3. Sort by ID using Insertion Sort\n"
				+ "4. Sort by names using Selection Sort\n"
				+ "5. Exit\n\n"
				+ "Enter selection: ", acctNum);

		// input
		choice = input.next();
		input.nextLine();

		// choose 1 - access account
		if (choice.substring(0).equals("1")) {
			System.out.print("\n1. View balance\n"
					+ "2. Deposit\n"
					+ "3. Withdraw\n"
					+ "4. Back to menu\n"
					+ "5. Exit\n"
					+ "Enter selection: ");
			choice = input.next();
			input.nextLine();

			// choose 1 - view balance
			if (choice.substring(0).equals("1")) {
				System.out.print(account.getBalance());
			}
			// choose 2 - deposit
			if (choice.substring(0).equals("2")) {
				System.out.print("How much would you like to deposit: ");
				amount = input.nextDouble();
				account.deposit(amount);
			}
			// choose 3 - withdraw
			if (choice.substring(0).equals("3")) {
				System.out.print("How much would you like to withdraw: ");
				amount = input.nextDouble();
				account.withdraw(amount);
			}
			// choose 4 - back to menu
			if (choice.substring(0).equals("4")) {

			}
			// choose 5 - exit
			else if (choice.substring(0).equals("5")) {
				System.out.print("Bye! See you again soon!");
			}
		}

		// choose 2 - sort by amount using bubble sort
		else if (choice.substring(0).equals("2")) {

		}

		// choose 3 - sort by ID using insertion sort
		else if (choice.substring(0).equals("3")) {

		}
		// choose 4 - sort by names using selection sort
		else if (choice.substring(0).equals("4")) {

		}
		// choose 5 - exit
		else if (choice.substring(0).equals("5")) {
			System.out.print("Bye! See you again soon!");
		}


		input.close();
		//ask for account number, put 2,  - print balance sorted, name!, id!


	}

}
