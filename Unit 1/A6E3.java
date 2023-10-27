package unit_0_java_basics;

import java.util.Scanner;
import java.io.*;

/**
 * Removes vowels from a text in a file.
 * @author Bianca
 * @version Sept 22, 2023
 */

public class A6E3 {

	public static void main(String[] args) {

		// Variables
		final String vowels = "aeiou";
		final int vLength = vowels.length(); // length of vowels
		String file = "File_A6E3";
		String word;
		String front = ""; // letters before the vowel
		String back = ""; // letters after the vowel
		int length; // length of word

		// Input from file
		Scanner input;
		try {
			input = new Scanner(new File(file));

			while (input.hasNext()) {
				word = input.next();
				length = word.length();

				for (int i = 0; i<length; i++) { // range of length of word
					for (int j = 0; j<vLength; j++) { // range of length of vowels
						if (word.substring(i,i+1).compareToIgnoreCase(vowels.substring(j,j+1)) == 0) { // letter is a vowel
							front = word.substring(0,i);
							back = word.substring(i+1,length);
							word = front + back;
							i = 0;
							length -= 1;
							break;
						}
					}
				}
				// Print
				System.out.print(front + back + " ");
			}

		}
		catch (FileNotFoundException ex) { // exit when file not found
			System.out.print("File not found.");
			System.exit(0);
		}


	}

}
