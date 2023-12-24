package unit_3_recur_sort;

import java.io.*;
import java.util.Scanner;

/**
 * Program that sorts the numbers in the numbers.txt using mergesort.
 * @author Bianca
 * @version Nov 22, 2023
 */

public class A1E6 {

	/**
	 * Splits the array in half and sorts each half until the whole array is sorted.
	 * @param numbers
	 * @param start
	 * @param end
	 * @return
	 */
	public static int [] mergeSort(int [] numbers, int start, int end) {
		int mid;
		
		if (start < end) {
			mid = (start + end) / 2;
			mergeSort(numbers, start, mid);
			mergeSort(numbers, mid + 1, end);
			numbers = merge(numbers, start, mid, end);
		}

		return numbers;
	}
	
	/**
	 * Merges the 2 sorted arrays.
	 * @param numbers
	 * @param start
	 * @param mid
	 * @param end
	 * @return
	 */
	public static int [] merge(int [] numbers, int start, int mid, int end) {
		int num;
		
		// 
		if (start < end) {
			// first number of first sorted list is bigger than first number of second sorted list - 2nd list smaller
			if (numbers[start] > numbers[mid]) {
				num = numbers[start];
				numbers[start] = numbers[mid];
				numbers[mid] = num;
				merge(numbers, start, mid + 1, end);
			}
			// first number of first sorted list is smaller than first number of second sorted list - 1st list smaller
			else {
				merge(numbers, start + 1, mid, end);
			}
		}
		return numbers;
	}
	
	
	public static void main(String[] args) {
		final int len = 8000;
		int[] numbers = new int[len];
		int count = 0;
		String file = "numbers.txt";
		
		try {
			Scanner scanner = new Scanner(new File(file));
			
			// add numbers to an array
			while(scanner.hasNext()) {
				numbers[count] = scanner.nextInt();
				count += 1;
			}
		}
		catch(FileNotFoundException ex) {
			System.out.println("File not Found");
			System.exit(0);
		}
		
		System.out.print(mergeSort(numbers, 0, len));

	}

}
