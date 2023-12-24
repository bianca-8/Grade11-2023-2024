package unit_3_recur_sort;

import java.io.*;
import java.util.*;

/**
 * Program that does a binary search on the numbers.txt file.
 * @author Bianca
 * @version Nov 22, 2023
 */

public class A1E5 {

	public static int function(int n) {
		
		return 1;
	}

	public static void main(String[] args) {
		int term = 1;
		int find = 3; // number you're trying to find
		int [] numbers = new int[8000];
		int count = 0;
		String file = "number.txt";

		try {
			Scanner scanner = new Scanner(new File(file));
			
			// keep looking for more input
			while(scanner.hasNext()) {
				numbers[count] = scanner.nextInt();
				count += 1;
			}
		}
		catch(FileNotFoundException ex) {
			System.out.println("File not Found");
			System.exit(0);
		}

		System.out.print(function(term));

	}

}
