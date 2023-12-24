package unit_3_recur_sort;

import java.io.*;
import java.util.*;

/**
 * Sorts numbers in a file by checking each with every number and storing it in a new list if it is smaller than each one but bigger than the last one of the list.
 * @author Bianca
 * @version Dec 5, 2023
 */

public class A2E2b {

	public static void main(String[] args) {
		// variables
		final int size = 4; //119, 4
		String file = "numbers3.txt";
		int [] numbers = new int[size];
		int [] sortNum = new int[size];
		int count = 0;
		int sortPlace = 0;
		int times = 1;

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

		// find smallest number
		for (int k = 0; k < size; k++) {
			// goes through each number
			for (int i = 0; i < size; i++) {
				// checks with all other numbers
				for (int j = 0; j < size; j++) {
					System.out.println(numbers[i] + " " + numbers[j] + " " + count);
					// sorted array is empty
					if (sortPlace == 0) {
						// no numbers smaller at the end of the array and sorted array is empty
						if (numbers[i] <= numbers[j] && count <= size-k-1) {
							count += 1;
						}
					}
					// sorted array is not empty
					else {
						// no numbers smaller at the end of the array and sorted array is not empty and number is bigger than last number in sorted array
						if (numbers[i] <= numbers[j] && count <= size-k-1 && numbers[i] > sortNum[sortPlace-1]) {
							count += 1;

						}
						if (numbers[i] <= numbers[j] && count <= size-k-1 && numbers[i] == sortNum[sortPlace-1]) {
							times += 1;
							count += 1;
						}
					}
					// arrived at the end of the array without any smaller number
					if (count == size-k) {
						System.out.println("hi" + sortPlace + " " + numbers[i] + " " + times);
						for (int l = 0; l < times; l++) {
							sortNum[sortPlace] = numbers[i];
							sortPlace += 1;
						}
						break;
					}
					times = 1;
				}
				count = 0;

			}
		}

		// print out sorted list
		for (int i = 0; i < size; i++) {
			System.out.println(sortNum[i]);
		}

	}

}
