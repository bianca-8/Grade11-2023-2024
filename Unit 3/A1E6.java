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
	 * @param numbers - array that needs to be sorted
	 * @param start - starting index of the array being sorted
	 * @param end - ending index of the array being sorted
	 */
	public static void mergesort(int[] numbers, int start, int end) {
		int mid;

		// range exists
		if (start < end) {
			mid = (start + end) / 2;

			mergesort(numbers, start, mid);
			mergesort(numbers, mid + 1, end);

			merge1(numbers, start, mid, end);
		}
	}

	/**
	 * Merges the 2 sorted arrays.
	 * pre: numbers[start, mid] and numbers[mid + 1, end] are sorted
	 * post: numbers[start, end] is sorted
	 * @param numbers - array that needs to be sorted
	 * @param start - starting index of the array being sorted
	 * @param mid - middle index of the array being sorted
	 * @param end - ending index of the array being sorted
	 */
	private static void merge1(int[] numbers, int start, int mid, int end) {
		int[] temp = new int[numbers.length];
		int ind = start; // index of place in temporary array
		
		int place1 = start; // start of first section
		int place2 = mid + 1; // start of second section
		
		// ranges exist
		while (place1 > mid == false || place2 > end == false) {
			// 2nd section is smaller, put in temp array first
			if (place1 > mid || place2 <= end && numbers[place2] < numbers[place1]) {
				temp[ind] = numbers[place2];
				place2 += 1;
			}
			// 1st section is smaller, put in temp array first
			else {
				temp[ind] = numbers[place1];
				place1 += 1;
			}
			ind += 1;
		}
		
		// change numbers to temp
		for (int i = start; i <= end; i++) {
			numbers[i] = temp[i];
		}
	}

	/**
	 * Merges the 2 sorted arrays.
	 * @param numbers - array that needs to be sorted
	 * @param start - starting index of the array being sorted
	 * @param mid - middle index of the array being sorted
	 * @param end - ending index of the array being sorted
	 * @return merged array
	 */
	public static int [] merge(int [] numbers, int start, int mid, int end) {
		int num;

		// range exists
		if (start < end) {
			// first number of first sorted list is bigger than first number of second sorted list - 2nd list goes first
			if (numbers[start] > numbers[mid]) {
				num = numbers[start];
				numbers[start] = numbers[mid];
				numbers[mid] = num;
				merge(numbers, start, mid + 1, end);
			}
			// first number of first sorted list is smaller than first number of second sorted list - 1st list goes first
			else {
				merge(numbers, start + 1, mid, end);
			}
		}
		return numbers;
	}


	public static void main(String[] args) {
		final int len = 8000;
		int[] numbers = new int[len];
		String file = "numbers.txt";

		try {
			Scanner scanner = new Scanner(new File(file));

			// add numbers to an array
			for (int i = 0; i < len; i++) {
				numbers[i] = scanner.nextInt();
			}
		}
		catch(FileNotFoundException ex) {
			System.out.println("File not Found");
			System.exit(0);
		}

		mergesort(numbers, 0, len-1);

		for (int i = 0; i < len; i++) {
			System.out.println(numbers[i]);
		}
	}

}
