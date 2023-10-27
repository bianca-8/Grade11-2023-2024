package unit_0_java_basics;

import java.io.*;
import java.util.*;

/**
 * Find average number of words in a sentence.
 * @author Bianca
 * @version Sept 22, 2023
 */

public class A6E1b {

	public static void main(String[] args) {

		// Variables
		String file = "File_A6E1";
		String line; // line of sentences
		String sentence = null;
		int length = 0; // number of words
		int counter = 0; // number of sentences
		double avg; // average length of sentences
		final String punctuation = ".?!"; // punctuation

		// File
		Scanner input;
		try {
			input = new Scanner(new File(file));

			while (input.hasNextLine()) {
				// Length of Sentences
				line = input.nextLine();
				for (int i = 0; i < line.length(); i++) {
					for (int j = 0; j < punctuation.length(); j++) {
						// end of a sentence
						if (line.substring(i,i+1).equals(punctuation.substring(j,j+1))) {
							sentence = line.substring(0,i);
							line = line.substring(i);
							break;
						}
						else {
							sentence = line;
						}
						System.out.println(sentence);
						for (int k = 0; k < sentence.length(); k++) {
							if (sentence.substring(k,k+1).equals(" ") == true) {
								length += 1;
								System.out.print(length);
								break;
							}
						}
					}
					counter++;
				}
			}
		}
		catch (FileNotFoundException ex) {
			System.out.print("File not Found");
			System.exit(0);
		}

		// Math
		avg = length/counter; // average number of words in a sentence

		// Print
		System.out.format("The average sentence length is %.0f.", avg);

	}
}
