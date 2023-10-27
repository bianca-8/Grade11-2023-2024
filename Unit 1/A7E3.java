package unit_0_java_basics;

import java.util.Scanner;
import java.io.*;

/**
 * Program that determines if a 3x3 matrix from a file is a perfect square (sum of column, row and diagonal are the same)
 * @author Bianca
 * @version Sept 29, 2023
 */

public class A7E3 {

	public static void main(String[] args) {

		// Variables
		String file = "File_A7E3";
		int [][] matrix = new int[3][3];
		int num;
		int sum1; // sum of first row
		int sum = 0; // Multiplied like below (how many times crossed the place in a perfect square)
		/* 3 2 3
		 * 2 4 2
		 * 3 2 3
		 */
		boolean perfect = false; // perfect square or not

		// File
		Scanner input;
		try {
			input = new Scanner(new File(file));

			while (input.hasNext()) { // There are more lines
				for (int i = 0; i < matrix.length; i++) { // row
					for (int j = 0; j < matrix[0].length; j++) { // column
						// Add numbers in file to matrix
						num = input.nextInt();
						matrix[i][j] = num;
					
						// Math
						if (i == 0 || i == 2) { // 1st or 3rd row
							if (j == 0 || j == 2) { // 1st or 3rd column
								sum += num * 3;
							}
							else { // 2nd column
								sum += num * 2;
							}
						}
						else { // 2nd row
							if (j == 0 || j == 2) { // 1st or 3rd column
								sum += num * 2;
							}
							else { // 2nd column
								sum += num * 4;
							}
						}
					}
				}
			}
			// Sum of first row
			sum1 = matrix[0][0] + matrix[0][1] + matrix[0][2];

			if (sum/8 == sum1) { // Total sum divided by 8 (number of perfect square combinations) = to sum of first row
				perfect = true;
			}
			
			// Print
			System.out.format("The matrix is a perfect square: %b", perfect);
		}

		catch (FileNotFoundException ex) {
			System.out.print("File not found.");
			System.exit(0);
		}

	}

}
