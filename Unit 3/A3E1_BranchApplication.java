package unit_3_recur_sort;

import java.util.Scanner;
import java.io.*;

/**
 * Creates accounts of its clients.
 * @author Bianca
 * @version Dec 7, 2023
 */

public class A3E1_BranchApplication {

	A3E1_Account [] account;

	public static void main(String[] args) {
		// variables
		String file = "accounts";
		String choice1;
		String choice2;
		double amount;
		int acctNum;
		String name = "";
		double initBal = 0;
		Scanner input = new Scanner(System.in);	

		// menu
		System.out.print("Welcome to the WOSS Bank!\n\n");

		System.out.print("What is your account number: ");
		acctNum = input.nextInt();

		A3E1_Account account = new A3E1_Account(acctNum, name, initBal);

		final int clients = 11;
		int [] id = new int[clients];
		double [] initBals = new double[clients];
		String [] names = new String[clients];
		int count = 0;
		
		// input
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(file));
			// has more lines
			while(scanner.hasNextLine()) {
				id[count] = scanner.nextInt();
				initBals[count] = scanner.nextDouble();
				names[count] = scanner.nextLine().strip();

				count += 1;
			}
			A3E1_Account acct = new A3E1_Account(scanner);
		} 
		catch (FileNotFoundException e) {
			System.out.print("File not found");
			System.exit(0);
		}

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
		if (choice1.substring(0).equals("1")) {
			System.out.print("\nAccount Actions:\n"
					+ "1. View balance\n"
					+ "2. Deposit\n"
					+ "3. Withdraw\n"
					+ "4. Exit\n\n"
					+ "Enter selection: ");
			choice2 = input.next();
			input.nextLine();

			// choose 1 - view balance
			if (choice2.substring(0).equals("1")) {
				System.out.print(account.getBalance());
			}
			// choose 2 - deposit
			if (choice2.substring(0).equals("2")) {
				System.out.print("How much would you like to deposit: ");
				amount = input.nextDouble();
				account.deposit(amount);
			}
			// choose 3 - withdraw
			if (choice2.substring(0).equals("3")) {
				System.out.print("How much would you like to withdraw: ");
				amount = input.nextDouble();
				account.withdraw(amount);
			}
			// choose 4 - exit
			else if (choice2.substring(0).equals("4")) {
				System.out.print("Bye! See you again soon!");
			}
		}

		// choose 2 - sort by amount using bubble sort
		else if (choice1.substring(0).equals("2")) {
			bubbleSort(initBals);
			for (int i = 0; i < initBals.length; i++) {
				System.out.println(initBals[i]);
			}
		}

		// choose 3 - sort by ID using insertion sort
		else if (choice1.substring(0).equals("3")) {
			insertSort(id);
			for (int i = 0; i < id.length; i++) {
				System.out.println(id[i]);
			}
		}
		// choose 4 - sort by names using selection sort
		else if (choice1.substring(0).equals("4")) {
			selectSort(names);
			for (int i = 0; i < names.length; i++) {
				System.out.println(names[i]);
			}
		}
		// choose 5 - exit
		else if (choice1.substring(0).equals("5")) {
			System.out.print("Bye! See you again soon!");
			System.exit(0);
		}

		input.close();
		//ask for account number, put 2,  - print balance sorted, name!, id!
	}

	/**
	 * Performs a bubble sort
	 * @param numbers - array of numbers to sort
	 * @return sorted array
	 */
	private static double [] bubbleSort(double [] numbers) {
		int size = numbers.length;

		// go through the array size times
		for (int k = 0; k < size; k++) {
			// go through the whole array
			for (int i = 1; i < size; i++) {
				// second number is smaller than first number
				if (numbers[i] < numbers[i-1]) {
					swap(numbers, i);
				}
			}
		}
		return numbers;
	}

	/**
	 * Swaps the numbers
	 * pre: second number is smaller than first
	 * @param numbers - array of numbers
	 * @param i - index
	 */
	private static void swap(double [] numbers, int i) {
		double num = numbers[i];
		numbers[i] = numbers[i-1];
		numbers[i-1] = num;
	}

	/**
	 * Performs a insertion sort
	 * @param number - array of numbers to sort
	 * @return sorted array
	 */
	private static int [] insertSort(int [] numbers) {
		int temp, previousIndex;

		for (int index = 1; index < numbers.length; index++) {
			temp = numbers[index];
			previousIndex = index - 1;
			while ((numbers[previousIndex] > temp) && (previousIndex > 0)) {
				numbers[previousIndex + 1] = numbers[previousIndex];
				previousIndex -= 1; 	//decrease index to compare current 
			}	

			//item with next previous item
			if (numbers[previousIndex] > temp) {
				/* shift item in first element up into next element */
				numbers[previousIndex + 1] = numbers[previousIndex];
				/* place current item at index 0 (first element) */
				numbers[previousIndex] = temp;
			} 
			else {
				/* place current item at index ahead of previous item */
				numbers[previousIndex + 1] = temp;
			}
			
		}
		return numbers;
	}

	/**
	 * Performs a selection sort
	 * @param names - array of names to sort
	 * @return sorted array
	 */
	private static String [] selectSort(String [] names) {
		// 
		for (int i = 0; i < names.length; i++) {
			// 
			for (int j = i; j < names.length; j++) {
				// 
				if (names[j].compareToIgnoreCase(names[i]) < 0) {
					String temp = names[i];
					names[i] = names[j];
					names[j] = temp;
				}
			}
		}
		return names;
	}

}