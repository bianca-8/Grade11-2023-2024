package unit_3_recurSort;

import java.io.*;
import java.util.*;

/**
 * Sorts numbers in a file by checking each with every number and storing it in a new list if it is smaller than each one but bigger than the last one of the list.
 * @author Bianca
 * @version Dec 5, 2023
 */

public class A2E2a {

	public static void main(String[] args) {
		// variables
		final int size = 119;
		String file = "numbers2.txt";
		int [] numbers = new int[size];
		int [] sortNum = new int[size];
		int count = 0;
		int sortPlace = 0;

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

		// goes through each number
		for (int i = 0; i < size; i++) {
			// checks with all other numbers
			for (int j = 0; j < size; j++) {
				// sorted array is empty
				if (sortPlace == 0) {
					// no numbers smaller at the end of the array and sorted array is empty
					if (numbers[i] <= numbers[j] && count <= size-i-1) { // ALWIFJLWAIsize-i-1 was -k
						count += 1;
					}
				}
				// sorted array is not empty
				else {
					// no numbers smaller at the end of the array and sorted array is not empty and number is bigger than last number in sorted array
					if (numbers[i] <= numbers[j] && count <= size-i-1 && numbers[i] > sortNum[sortPlace-1]) { // LAFWJFIJWALsize-i-1 was -k
						count += 1;
					}
				}
				// arrived at the end of the array without any smaller number
				if (count == size-i) {// AWLIFJLIWFJsize-i-1 was -k
					sortNum[sortPlace] = numbers[i];
					sortPlace += 1;
					break;
				}
			}
			count = 0;
		}

		// print out sorted list
		for (int i = 0; i < size; i++) {
			System.out.println(sortNum[i]);
		}

	}

}
