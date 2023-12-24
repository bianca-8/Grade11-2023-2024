package unit_3_recur_sort;

import java.util.Scanner;
import java.io.*;

/**
 * Determines if a number 1-10000 from is in the file text.txt.
 * @author Bianca
 * @version Dec 5, 2023
 */

public class A2E1 {

	public static void main(String[] args) {
		// variables
		final int size = 8000;
		int num; // numbers the program is trying to find
		String file = "numbers.txt";
		int [] numbers = new int[size];
		boolean inFile = false;
		
		// input
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number you are trying to find: ");
		num = input.nextInt();
		input.close();

		// file
		try {
			Scanner scanner = new Scanner(new File(file));
			
			// goes through size numbers and finds the number
			for (int i = 0; i < size; i++) {
				
				// put numbers in an array
				if (scanner.hasNext()) {
					numbers[i] = scanner.nextInt();
				}

				// the number is in the file
				if (numbers[i] == num) {
					inFile = true;
				}
			}
			
		}
		// file not found
		catch(FileNotFoundException ex){
			System.out.println("File not Found");
			System.exit(0);
		}
		
		// number is in the file
		if (inFile == true) {
			System.out.print(num + " is in the file.");
		}
		// number is not in the file
		else {
			System.out.print(num + " is not in the file.");
		}

	}

}
