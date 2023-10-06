package unit_0_java_basics;

import java.io.*;
import java.util.*;

/**
 * Find average word length from a file.
 * @author Bianca
 * @version Sept 22, 2023
 */

public class A6E1 {

	public static void main(String[] args) {
		
		// Variables
		String file = "File_A6E1";
		String word;
		//String sentence;
		//int sLength; // sentence length
		int wLength; // word length
		//int sCounter = 0; // number of sentences
		int wCounter = 0; // number of words
		int wSum = 0; // sum of length of words
		//int sSum = 0; // sum of length of sentences
		double wAvg; // average length of words
		//double sAvg; // average length of sentences
		final String punctuation = "!~`-=_+[]\\{}|;':'<>?,./"; // punctuation
				
		// File
		Scanner input;
		try {
			input = new Scanner(new File(file));
			
			while (input.hasNext()) {
				// Length of Words
				word = input.next();
				wLength = word.length();
				for (int i = 0; i < punctuation.length(); i++) {
					while (word.endsWith(punctuation.substring(i,i+1)) == true) {
						wLength -= 1;
						word = word.substring(0,wLength);
					}
				}
				wSum += wLength;
				wCounter++;
				
				/*// Length of Sentences
				sentence = input.nextLine();
				//System.out.print(sentence);
				sLength = sentence.length();
				//System.out.print("length" + sLength);
				sSum += sLength;
				sCounter++;*/
			}
		}
		catch (FileNotFoundException ex) {
			System.out.print("File not Found");
			System.exit(0);
		}
		
		// Math
		wAvg = wSum/wCounter; // average of letters
		//sAvg = sSum/sCounter; // average number of words in a sentence
		
		System.out.format("The average word length is %.0f.\n", wAvg);
		//System.out.format("The average sentence length is %.0f.", sAvg);

	}
}
