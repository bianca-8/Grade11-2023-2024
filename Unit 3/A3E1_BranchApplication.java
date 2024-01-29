package unit_3_recur_sort;

import java.util.Scanner;
import java.io.*;

/**
 * Creates accounts of its clients.
 * @author Bianca
 * @version Dec 7, 2023
 */

public class A3E1_BranchApplication {

	A3E1_AccountOld [] account;

	public static void main(String[] args) {
		// variables
		String file = "accounts";
		String choice1;
		String choice2;
		double amount;
		int acctNum;
		int count;
		boolean go = true;
		final int CLIENTS = 11;
		A3E1_Account [] account = new A3E1_Account[CLIENTS];
		Scanner input = new Scanner(System.in);

		// menu
		System.out.print("Welcome to the WOSS Bank!\n\n");

		System.out.print("What is your account number: ");
		acctNum = input.nextInt();
		count = acctNum - 1;

		// input
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(file));
			
			// add objects to account list
			for (int i = 0; i < CLIENTS; i++) {
				A3E1_Account acct = new A3E1_Account(scanner);
				account[i] = acct;
			}
		} 
		catch (FileNotFoundException e) {
			System.out.print("File not found");
			System.exit(0);
		}

		// not exiting
		while (go) {
			// choice 1
			System.out.format("\nWhat would you like to do?\n\n"
					+ "1. Access account\n"
					+ "2. Sort by amount using Bubble Sort\n"
					+ "3. Sort by ID using Insertion Sort\n"
					+ "4. Sort by names using Selection Sort\n"
					+ "5. Exit\n\n"
					+ "Enter selection: ");

			// input
			choice1 = input.next();
			input.nextLine();

			// choose 1 - access account
			if (choice1.equals("1")) {
				// not exiting or going back to menu
				do {
					System.out.print("\nAccount Actions:\n"
							+ "1. View balance\n"
							+ "2. Deposit\n"
							+ "3. Withdraw\n"
							+ "4. Back to Menu\n"
							+ "5. Exit\n\n"
							+ "Enter selection: ");
					choice2 = input.next();
					input.nextLine();

					// find place in list of id of client
					for (int i = 0; i < CLIENTS; i++) {
						if (account[i].getAccountNum() == acctNum) {
							count = i;
							break;
						}
					}

					// choose 1 - view balance
					if (choice2.equals("1")) {
						System.out.format("$%.2f\n", account[count].getBalance());
					}
					// choose 2 - deposit
					else if (choice2.equals("2")) {
						System.out.print("\nHow much would you like to deposit: ");
						amount = input.nextDouble();
						account[count].deposit(amount);
					}
					// choose 3 - withdraw
					else if (choice2.equals("3")) {
						System.out.print("\nHow much would you like to withdraw: ");
						amount = input.nextDouble();
						account[count].withdraw(amount);
					}
					// choose 4 - back to menu
					else if (choice2.equals("4")) {
						break;
					}
					// choose 5 - exit
					else if (choice2.equals("5")) {
						System.out.print("Bye! See you again soon!");
						System.exit(0);
					}
					else {
						System.out.print("\nPlease enter a valid choice.\n");
					}
				}
				while (choice2 != "4");
			}

			// choose 2 - sort by amount using bubble sort
			else if (choice1.equals("2")) {
				bubbleSort(account);
				printAccounts(account);
			}

			// choose 3 - sort by ID using insertion sort
			else if (choice1.equals("3")) {
				insertSort(account);
				printAccounts(account);
			}
			// choose 4 - sort by names using selection sort
			else if (choice1.equals("4")) {
				selectSort(account);
				printAccounts(account);
			}
			// choose 5 - exit
			else if (choice1.equals("5")) {
				System.out.print("Bye! See you again soon!");
				go = false;
				System.exit(0);
			}
			else {
				System.out.print("\nPlease enter a valid choice.\n");
			}
		}
		input.close();	
	}

	/**
	 * Prints out the accounts.
	 * @param account - bank account array
	 */
	private static void printAccounts(A3E1_Account [] account) {
		System.out.println("ID:\t\tAmount:\t\tNames:");
		// go through sorted array
		for (int i = 0; i < account.length; i++) {
			System.out.format("%d\t\t$%.2f\t\t%s\n", account[i].getAccountNum(), account[i].getBalance(), account[i].getName());
		}
	}
	
	/**
	 * Performs a bubble sort on an array of objects
	 * @param list - array of objects to sort
	 * @return sorted array
	 */
	private static A3E1_Account [] bubbleSort(A3E1_Account [] list) {
		int size = list.length;

		// go through the array size times
		for (int k = 0; k < size; k++) {
			// go through the whole array
			for (int i = 1; i < size; i++) {
				// second number is smaller than first value
				if (list[i].getBalance() < list[i-1].getBalance()) {
					A3E1_Account temp = list[i];
					list[i] = list[i-1];
					list[i-1] = temp;
				}
			}
		}
		return list;
	}

	/**
	 * Performs a insertion sort on an array of objects
	 * @param list - array of objects to sort
	 * @return sorted array
	 */
	private static A3E1_Account [] insertSort(A3E1_Account [] list) {
		A3E1_Account temp;
		int previ;

		// go through array
		for (int i = 1; i < list.length; i++) {
			temp = list[i];
			previ = i - 1;

			// 
			while (list[i].getAccountNum() > temp.getAccountNum() && previ > 0) {
				list[previ + 1] = list[previ];
				previ -= 1;
			}	

			// previous number is bigger, need to swap spots
			if (list[previ].getAccountNum() > temp.getAccountNum()) {
				list[previ + 1] = list[previ];
				list[previ] = temp;
			}
			// number at i is bigger
			else {
				list[previ + 1] = temp;
			}
		}
		return list;
	}

	/**
	 * Performs a selection sort on an array of objects
	 * @param list - array of objects to sort
	 * @return sorted array
	 */
	private static A3E1_Account [] selectSort(A3E1_Account [] list) {
		// go through names
		for (int i = 0; i < list.length; i++) {
			// compare with all other names
			for (int j = i; j < list.length; j++) {
				// name at j is alphabetically before name at i, swap the names
				if (list[j].getName().compareToIgnoreCase(list[i].getName()) < 0) {
					A3E1_Account temp = list[i];
					list[i] = list[j];
					list[j] = temp;
				}
			}
		}
		return list;
	}

}