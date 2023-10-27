package unit_0_java_basics;

import java.util.Scanner;
import java.io.*;

/**
 * Pig Latin generator for a file.
 * @author Bianca
 * @version Sept 22, 2023
 */

public class A6E2 {

	public static void main(String[] args) {
		
		// Variables
		String file = "File_A6E2";
		String word;
		String firstLet; // First letter of word
		String secondLet; // Second letter of word, first letter of Pig Latin word
		String rest; // Rest of word
		String lastLet; // Last letter of word
		String punctuation = ""; // Punctuation at the end of the word
		int length; // length of word
		int count = 1;
		final String symbols = "~`-=_+[]\\{}|;':<>?,./!@#$%^&*()\""; // all symbol types
		
		// Input
		Scanner input;
		try {
			input = new Scanner(new File(file));

			// There are still lines to read
			while (input.hasNext()) { 
				word = input.next();
				length = word.length();
				lastLet = word.substring(length-1, length);
				firstLet = word.substring(0,1);
				
				// word ends with punctuation
				for (int i = 0; i < symbols.length(); i++) {
					if (lastLet.equals(symbols.substring(i,i+1)) == true) {
						punctuation = word.substring(length-1,length);
						count = 0;
						length -= 1;
						word = word.substring(0,length);
					}
					// Word doesn't end with punctuation
					else {
						punctuation = "";
					}
				}
				
				// word is at least 2 letters long
				if (length > 1) { 
					secondLet = word.substring(1,2);
					rest = word.substring(2,length);
				}
				
				// word is 1 letter long
				else { 
					secondLet = "";
					rest = "";
				}

				// first word needs to be capitalized
				if (count == 1) { 
					secondLet = secondLet.toUpperCase();
				}

				System.out.print(secondLet + rest + firstLet.toLowerCase() + "ay" + punctuation + " ");

				count++;

			}
		}
		catch (FileNotFoundException ex) {
			System.out.print("File not found");
			System.exit(0);
		}
	}

}
