package unit_3_recur_sort;

import java.util.*;
import java.io.*;

/**
 * Program that acts as a vehicle database.
 * @author Bianca
 * @version Jan 1, 2024
 */

public class A3E3_Vehicle {
	final static int size = 6;
	static String [] type = new String[size];
	static String [] manu = new String[size];
	static String [] name = new String[size];
	static int [] price = new int[size];
	
	public static void main(String[] args) {
		String [] type2 = new String[size];
		String [] manu2 = new String[size];
		String [] name2 = new String[size];
		int [] price2 = new int[size];
		
		String file = "Vehicles";
		int count = 0;
		Scanner input = new Scanner(System.in);
		String choice;
		String choice2;
		
		// initialize file
		try {
			Scanner scanner = new Scanner(new File(file));
			
			// there are more lines in the file
			while (scanner.hasNext()) {
				type[count] = scanner.next();
				manu[count] = scanner.next();
				name[count] = scanner.next();
				price[count] = scanner.nextInt();
				
				type2[count] = type[count];
				manu2[count] = manu[count];
				name2[count] = name[count];
				price2[count] = price[count];
				
				count += 1;
			}
		}
		// file not found
		catch (FileNotFoundException e) {
			System.out.print("File not found.");
			System.exit(0);
		}

		do {
			choice = input.next();
			// sort price
			if (choice == "1") {
				
			}
			// sort type by name
			else if (choice == "2") {
				
			}
			// sort by name
			else if (choice == "3") {
				
			}
			// exit
			else if (choice == "4") {
				System.out.print("\nBye! Come again soon.");
				System.exit(0);
			}
			// 
			else {
				System.out.print("Please enter a valid choice.");
			}
		}
		while (choice != "4");
		
		// sort price using selection sort
		selectSort(price);
		System.out.format("Sort by Price:\n%-10s\t\t%-10s\t\t%-10s\t\t%-10s\n", "Manufacturer:", "Name:", "Type:", "Price:");
		// go through array
		for (int i = 0; i < price.length; i++) {
			// compare with original array
			for (int j = 0; j < price.length; j++) {
				// found index of price in original array
				if (price[i] == price2[j]) {
					System.out.format("%-10s\t\t%-10s\t\t%-10s\t\t$%-10d\n", manu2[j], name2[j], type2[j], price[i]);
				}
			}
		}
		
		
		// sort certain type names using insertion sort
		insertSort(name);
		
		
		
		// sort names using bubble sort
		bubbleSort(name);
		print(name.length, manu2, name, type2, price);
		System.out.format("\nSort by Name:\n%-10s\t\t%-10s\t\t%-10s\t\t%-10s\n", "Manufacturer:", "Name:", "Type:", "Price:");
		// go through array
		for (int i = 0; i < name.length; i++) {
			// compare with original array
			for (int j = 0; j < name.length; j++) {
				// found index of price in original array
				if (name[i].equals(name2[j])) {
					System.out.format("%-10s\t\t%-10s\t\t%-10s\t\t$%-10d\n", manu2[j], name[i], type2[j], price2[j]);
				}
			}
		}
		
	}
	
	/**
	 * Gets the type of the vehicle
	 * @return type of vehicle
	 */
	private static String [] getType() {
		return type;
	}
	
	/**
	 * Gets the manufacturer of the vehicle
	 * @return the manufacturer of the vehicle
	 */
	private static String [] getManu() {
		return manu;
	}
	
	/**
	 * Gets the name of the vehicle
	 * @return name of the vehicle
	 */
	private static String [] getName() {
		return name;
	}
	
	/**
	 * Gets the price of the vehicle
	 * @return price of the vehicle
	 */
	private static int [] getPrice() {
		return price;
	}
	
	/**
	 * Performs a selection sort on an array of integers
	 * @param names - array of names to sort
	 * @return sorted array
	 */
	private static int [] selectSort(int [] numbers) {
		// go through names
		for (int i = 0; i < numbers.length; i++) {
			// compare with all other names
			for (int j = i; j < numbers.length; j++) {
				// name at j is alphabetically before name at i, swap the names
				if (numbers[j] < numbers[i]) {
					selectSwap(numbers, i, j);
				}
			}
		}
		return numbers;
	}

	/**
	 * Swaps the numbers in an array of integers
	 * pre: second number is smaller than first
	 * @param numbers - array of numbers
	 * @param i - index of first number
	 * @param j - index of second number
	 */
	private static void selectSwap(int [] numbers, int i, int j) {
		int num = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = num;
	}
	
	/**
	 * Performs a insertion sort on an array of strings
	 * @param names - array of strings to sort
	 * @return sorted array
	 */
	private static String [] insertSort(String [] names) {
		String temp;
		int previ;

		// go through array
		for (int i = 1; i < names.length; i++) {
			temp = names[i];
			previ = i - 1;

			// 
			while (names[i].compareToIgnoreCase(temp) > 0 && previ > 0) {
				names[previ + 1] = names[previ];
				previ -= 1;
			}	

			// previous number is bigger, need to swap spots
			if (names[previ].compareToIgnoreCase(temp) > 0) {
				names[previ + 1] = names[previ];
				names[previ] = temp;
			}
			// number at i is bigger
			else {
				names[previ + 1] = temp;
			}
		}
		return names;
	}
	
	/**
	 * Performs a bubble sort on an array of strings
	 * @param names - array of names to sort
	 * @return sorted array
	 */
	private static String [] bubbleSort(String [] names) {
		int size = names.length;

		// go through the array size times
		for (int k = 0; k < size; k++) {
			// go through the whole array
			for (int i = 1; i < size; i++) {
				// second number is smaller than first number
				if (names[i].compareToIgnoreCase(names[i-1]) < 0) {
					bubbleSwap(names, i);
				}
			}
		}
		return names;
	}
	
	/**
	 * Swaps the terms in a array of strings
	 * pre: second term is smaller than first
	 * @param names - array of numbers
	 * @param i - index of first number
	 * @param j - index of second number
	 */
	private static void bubbleSwap(String [] names, int i) {
		String name = names[i];
		names[i] = names[i-1];
		names[i-1] = name;
	}
	
	/**
	 * 
	 */
	private static void print(int length, String [] manu, String [] name, String [] type, int [] price) {
		System.out.format("\nSort by Name:\n%-10s\t\t%-10s\t\t%-10s\t\t%-10s\n", "Manufacturer:", "Name:", "Type:", "Price:");
		// go through array
		for (int i = 0; i < name.length; i++) {
			// compare with original array
			for (int j = 0; j < name.length; j++) {
				// found index of price in original array
				if (name[i].equals(name[j])) {
					System.out.format("%-10s\t\t%-10s\t\t%-10s\t\t$%-10d\n", manu[j], name[i], type[j], price[j]);
				}
			}
		}
	}
}
