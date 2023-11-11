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
				// Characters in line
				for (int i = 0; i < line.length(); i++) {
					// number of punctuation
					for (int j = 0; j < punctuation.length(); j++) {
						// if letter is a punctuation symbol
						if (line.substring(i,i+1).equals(punctuation.substring(j,j+1))) {
							sentence = line.substring(0,i);
							line = line.substring(i+1);
							counter++;
							for (int k = 0; k < sentence.length(); k++) {
								System.out.println(sentence.substring(k,k+1));
								System.out.println(length);
								if (sentence.substring(k,k+1).equals(" ") == true) {
									length += 1;
									
								}
							}
							break;
						}
						// no punctuation - the line is the whole sentence
						else {
							for (int k = 0; k < line.length(); k++) {
								if (line.substring(k,k+1).equals(" ") == true) {
									length += 1;
									break;
								}
							}
						}
						
					}
				}
			}
		}
		catch (FileNotFoundException ex) {
			System.out.print("File not Found");
			System.exit(0);
		}

		// Math
		System.out.print(length);
		avg = length/counter; // average number of words in a sentence - found by number of words in a sentence divided by number of sentences

		// Print
		System.out.format("The average sentence length is %.0f.", avg);

	}
}
