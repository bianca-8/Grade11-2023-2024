package unit_3_recur_sort;

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
		int index = 0;
		int place = -1;
		boolean go = false;
		int tempInd = 0;

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
		
		int num = numbers[0];

		// go through array
		for (int i = 0; i < size; i++) {
			// compare each element in array with others
			for (int j = 0; j < size; j++) {
				// sorted list is empty
				if (place <= 0) {
					// number is smaller than first number
					if (numbers[j] < num) {
						num = numbers[j];
						index = j;
					}
					// at the end of the array
					if (j == size-1) {
						place = 0;
					}
				}
				// sorted list not empty
				else {
					// not found first number yet
					if (go == false) {
						// number is bigger than last number in sorted array
						if (numbers[j] > numbers[index]) {
							num = numbers[j];
							go = true;
							tempInd = j;
						}
					}
					// found first number
					if (go) {
						// number is bigger than last number in sorted array and smaller than previously stored number
						if (numbers[j] > numbers[index] && numbers[j] < num) {
							num = numbers[j];
							tempInd = j;
						}
					}
					// at the end of the array
					if (j == size-1) {
						index = tempInd;
					}
				}
			}
			sortNum[place] = num;
			place += 1;
			go = false;
		}

		// print out sorted list
		for (int i = 0; i < size; i++) {
			System.out.println(sortNum[i]);
		}

	}

}
