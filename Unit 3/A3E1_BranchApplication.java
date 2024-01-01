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
		boolean go = true;
		final int clients = 11;
		int [] id = new int[clients];
		double [] initBals = new double[clients];
		String [] names = new String[clients];
		int [] id2 = new int[clients];
		double [] initBals2 = new double[clients];
		String [] names2 = new String[clients];
		int count = 0;
		Scanner input = new Scanner(System.in);

		// menu
		System.out.print("Welcome to the WOSS Bank!\n\n");

		System.out.print("What is your account number: ");
		acctNum = input.nextInt();

		// input
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(file));
			
			// has more lines
			while(scanner.hasNextLine() && count < clients) {
				id[count] = scanner.nextInt();
				initBals[count] = scanner.nextDouble();
				names[count] = scanner.nextLine().strip();
				id2[count] = id[count];
				initBals2[count] = initBals[count];
				names2[count] = names[count];

				// account in file matches with account number given by user
				if (id[count] == acctNum) {
					initBal = initBals[count];
					name = names[count];
				}

				count += 1;
			}
			//A3E1_Account acct = new A3E1_Account(scanner);
		} 
		catch (FileNotFoundException e) {
			System.out.print("File not found");
			System.exit(0);
		}

		A3E1_Account account = new A3E1_Account(acctNum, name, initBal);
		
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

					// choose 1 - view balance
					if (choice2.equals("1")) {
						System.out.println(account.getBalance());
					}
					// choose 2 - deposit
					else if (choice2.equals("2")) {
						System.out.print("\nHow much would you like to deposit: ");
						amount = input.nextDouble();
						account.deposit(amount);
					}
					// choose 3 - withdraw
					else if (choice2.equals("3")) {
						System.out.print("\nHow much would you like to withdraw: ");
						amount = input.nextDouble();
						account.withdraw(amount);
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
				}
				while (choice2 != "4");
			}

			// choose 2 - sort by amount using bubble sort
			else if (choice1.equals("2")) {
				bubbleSort(initBals);
				
				System.out.println("ID:\t\tAmount:\t\tNames:");
				// go through sorted array
				for (int i = 0; i < initBals.length; i++) {
					// compare with original array
					for (int j = 0; j < initBals2.length; j++) {
						// found index of where the sorted number is in the original array
						if (initBals[i] == initBals2[j]) {
							System.out.println(id2[j] + "\t\t" +  initBals[i] + "\t\t" + names2[j]);
						}
					}
				}
			}

			// choose 3 - sort by ID using insertion sort
			else if (choice1.equals("3")) {
				insertSort(id);
				
				System.out.println("ID:\t\tAmount:\t\tNames:");
				// go through sorted array
				for (int i = 0; i < id.length; i++) {
					// compare with original array
					for (int j = 0; j < id.length; j++) {
						// found index of where the sorted number is in the original array
						if (id[i] == id[j]) {
							System.out.println(id[i] + "\t\t" +  initBals2[j] + "\t\t" + names2[j]);
						}
					}
				}
			}
			// choose 4 - sort by names using selection sort
			else if (choice1.equals("4")) {
				selectSort(names);
				
				System.out.println("ID:\t\tAmount:\t\tNames:");
				// go through sorted array
				for (int i = 0; i < names.length; i++) {
					// compare with original array
					for (int j = 0; j < names.length; j++) {
						// found index of where the sorted number is in the original array
						if (names[i].equals(names2[j])) {
							System.out.println(id2[j] + "\t\t" +  initBals2[j] + "\t\t" + names[i]);
						}
					}
				}
			}
			// choose 5 - exit
			else if (choice1.equals("5")) {
				System.out.print("Bye! See you again soon!");
				go = false;
				System.exit(0);
			}
		}
		input.close();	
	}

	/**
	 * Performs a bubble sort on an array of doubles
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
					bubbleSwap(numbers, i);
				}
			}
		}
		return numbers;
	}
	
	/**
	 * Swaps the numbers in a array of doubles
	 * pre: second number is smaller than first
	 * @param numbers - array of numbers
	 * @param i - index of first number
	 * @param j - index of second number
	 */
	private static void bubbleSwap(double [] numbers, int i) {
		double num = numbers[i];
		numbers[i] = numbers[i-1];
		numbers[i-1] = num;
	}

	/**
	 * Performs a insertion sort on an array of integers
	 * @param number - array of numbers to sort
	 * @return sorted array
	 */
	private static int [] insertSort(int [] numbers) {
		int temp;
		int previ;

		// go through array
		for (int i = 1; i < numbers.length; i++) {
			temp = numbers[i];
			previ = i - 1;

			// 
			while (numbers[i] > temp && previ > 0) {
				numbers[previ + 1] = numbers[previ];
				previ -= 1;
			}	

			// previous number is bigger, need to swap spots
			if (numbers[previ] > temp) {
				numbers[previ + 1] = numbers[previ];
				numbers[previ] = temp;
			}
			// number at i is bigger
			else {
				numbers[previ + 1] = temp;
			}
		}
		return numbers;
	}

	/**
	 * Performs a selection sort on an array of strings
	 * @param names - array of names to sort
	 * @return sorted array
	 */
	private static String [] selectSort(String [] names) {
		// go through names
		for (int i = 0; i < names.length; i++) {
			// compare with all other names
			for (int j = i; j < names.length; j++) {
				// name at j is alphabetically before name at i, swap the names
				if (names[j].compareToIgnoreCase(names[i]) < 0) {
					selectSwap(names, i, j);
				}
			}
		}
		return names;
	}

	/**
	 * Swaps the numbers in an array of Strings
	 * pre: second number is smaller than first
	 * @param numbers - array of numbers
	 * @param i - index of first number
	 * @param j - index of second number
	 */
	private static void selectSwap(String [] numbers, int i, int j) {
		String num = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = num;
	}

}