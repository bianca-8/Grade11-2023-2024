package unit_0_java_basics;

import java.util.*;
import java.io.*;

/**
 * Program that reads marks from a file.
 * @author Bianca
 * @version Sept 18, 2023
 */

public class A5E2b {

	public static void main(String[] args) {

		// Variables
		int amount = 0;
		int marks = 0;
		double average = 0;
		String file = "marks";

		// File
		Scanner input;
		try {
			input = new Scanner(new File(file));

			while (input.hasNext()) {
				marks = input.nextInt();
				if (marks >= 0 && marks <= 100) {
					average += marks;
					amount++;
				}

				else {
					System.out.println("Please enter a valid mark.");
				}

			}
		}
		catch (FileNotFoundException ex) {
			System.out.print("File not found.");
			System.exit(0);
		}

		// Math
		average /= amount;

		// Print
		System.out.format("The average is %.2f.", average);

	}

}
