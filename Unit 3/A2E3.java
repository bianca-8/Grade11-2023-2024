package unit_3_recur_sort;

import java.io.*;
import java.util.*;

/**
 * Bubble sort with one array. Compare 2 in the array and move the smaller one to the front.
 * @author Bianca
 * @version Dec 5, 2023
 */

public class A2E3 {

	public static void main(String[] args) {
		// variables
		final int size = 8000;
		int [] numbers = new int[size];
		String file = "numbers.txt";
		int num;

		// file
		try {
			Scanner scanner = new Scanner(new File(file));

			// goes through size numbers and finds the number
			for (int i = 0; i < size; i++) {

				// put numbers in an array
				if (scanner.hasNext()) {
					numbers[i] = scanner.nextInt();
				}
			}
		}
		// file not found
		catch(FileNotFoundException ex){
			System.out.println("File not Found");
			System.exit(0);
		}

		// go through the array size times
		for (int k = 0; k < size; k++) {
			
			// go through the whole array
			for (int i = 1; i < size; i++) {
				
				// second number is smaller than first number
				if (numbers[i] < numbers[i-1]) {
					num = numbers[i];
					numbers[i] = numbers[i-1];
					numbers[i-1] = num;
				}
			}
		}
		
		// print out the final array
		for (int i = 0; i < size; i++) {
			System.out.println(numbers[i] + " ");
		}
	}
}
