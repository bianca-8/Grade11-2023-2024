package unit_3_recur_sort;

import java.util.Random;

/**
 * Program that determines the median of a list of n marks not using bubble sort.
 * @author Bianca
 * @version Jan 1, 2024
 */

public class A3E2 {

	public static void main(String[] args) {
		int amount;
		int size = 10;
		int range = 10;
		
		Random r = new Random();
		
		amount = r.nextInt(size);
		int[] list = new int[amount+1];
		
		// add random numbers to the list
		for (int i = 0; i < list.length; i++) {
			list[i] = r.nextInt(range)+1;
		}
		System.out.print("Unsorted List: ");
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + " ");
		}
		System.out.print("\n\nSorted List: ");
		selectSort(list);
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + " ");
		}
		
		System.out.print("\n\nMedian: " + median(list));

	}
	/**
	 * Performs a selection sort on an array of integers
	 * @param numbers - array of numbers to sort
	 * @return sorted array
	 */
	private static int [] selectSort(int [] numbers) {
		// go through names
		for (int i = 0; i < numbers.length; i++) {
			// compare with all other names
			for (int j = i; j < numbers.length; j++) {
				// name at j is before name at i
				if (numbers[j] < numbers[i]) {
					swap(numbers, i, j);
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
	private static void swap(int [] numbers, int i, int j) {
		int num = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = num;
	}
	
	/**
	 * Finds the median of an array
	 * pre: array is sorted
	 * @return the median of the array
	 */
	public static double median(int[] numbers) {
		int index;
		double median;
		int median2;
		
		// even amount of numbers
		if (numbers.length % 2 == 0) {
			index = numbers.length/2;
			median = numbers[index-1];
			median2 = numbers[index];
			
			median = (median + median2) / 2;
		}
		// odd amount of numbers
		else {
			index = numbers.length/2;
			median = numbers[index];
		}
		
		return median;
	}

}
