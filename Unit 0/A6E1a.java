package unit_0_java_basics;

import java.io.*;
import java.util.*;

/**
 * Find average word length from a file.
 * @author Bianca
 * @version Sept 22, 2023
 */

public class A6E1a {

	public static void main(String[] args) {
		
		// Variables
		String file = "File_A6E1";
		String word;
		int length; // word length
		int counter = 0; // number of words
		int sum = 0; // sum of length of words
		double avg; // average length of words
		final String punctuation = "~`-=_+[]\\{}|;':<>?,./!@#$%^&*()\""; // punctuation
				
		// File
		try {
			Scanner input = new Scanner(new File(file));
			
			// Goes through each word
			while (input.hasNext()) {
				// Length of Words
				word = input.next();
				length = word.length();
				
				// Go through punctuation list
				for (int i = 0; i < punctuation.length(); i++) {
					while (word.substring(length-1).equals(punctuation.substring(i,i+1))) { // last letter = punctuation
						punctuation.replace(punctuation.substring(i,i+1), "");
						length -= 1;
						word = word.substring(0,length);
						i = 0;
					}
				}
				sum += length;
				counter++;
			}
		}
		catch (FileNotFoundException ex) {
			System.out.print("File not Found");
			System.exit(0);
		}
		
		// Math
		avg = sum/counter; // average of letters
		
		// Print
		System.out.format("The average word length is %.0f.\n", avg);

	}
}
