package unit_3_recur_sort;

import java.io.*;
import java.util.*;

/**
 * Program that does a binary search on the numbers.txt file.
 * @author Bianca
 * @version Nov 22, 2023
 */

public class A1E5 {

	/**
	 * Function that performs a binary search on an array.
	 * @param array - array the binary search is performed on
	 * @param start - starting index of the binary search
	 * @param end - ending index of the binary search
	 * @param find - number you're trying to find
	 * @return index of the number you're trying to find, or -1 if it isn't found
	 */
	public static int binarySearch(int[] array, int start, int end, int find) {
		int mid; // middle index
		
		// starting point is after ending point
		if (start > end) {
			return (-1);
		} 
		// searching place exists
		else {
			mid = (start + end) / 2;
			
			// number trying to find is at middle
			if (find == array[mid]) {
				return (mid);
			}
			// number trying to find is below middle
			else if (find < array[mid]) {
				return (binarySearch (array, start, mid-1, find));
			}
			// number trying to find is above middle
			else {
				return (binarySearch (array, mid+1, end, find));
			}
		}
	}

	public static void main(String[] args) {
		int find = 3; // number you're trying to find
		int len = 8000;
		int [] numbers = new int[len];
		int count = 0;
		String file = "numbersSorted.txt";

		// Add numbers in file to array
		try {
			Scanner scanner = new Scanner(new File(file));
			
			// keep looking for more input
			while(scanner.hasNext()) {
				numbers[count] = scanner.nextInt();
				count += 1;
			}
		}
		// file not found
		catch(FileNotFoundException ex) {
			System.out.println("File not Found");
			System.exit(0);
		}
		
		System.out.print("Index: " + binarySearch(numbers, 0, len, find));

	}

}
