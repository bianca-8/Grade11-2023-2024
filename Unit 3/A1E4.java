package unit_3_recurSort;

/**
 * Program that checks if a word is a palindrome and returns the word reversed.
 * @author Bianca
 * @version Nov 22, 2023
 */

public class A1E4 {

	/**
	 * Function that reverses a word.
	 * @param s - the word that needs to be reversed.
	 * @return the word reversed.
	 */
	public static String palindrome(String s) {
		// base case
		if (s.length() <= 1) {
			return s.substring(0);
		}
		// not base case
		else {
			return s.substring(s.length()-1,s.length()) + palindrome(s.substring(0,s.length()-1));
		}
		
	}
	
	public static void main(String[] args) {
		String word = "ab";
		
		System.out.println(palindrome(word));
		
		// the word is a palindrome
		if (palindrome(word).equals(word) == true) {
			System.out.print("\n" + word + " is a palindrome.");
		}
		// the word is not a palindrome
		else {
			System.out.print("\n" + word + " is not a palindrome.");
		}

	}

}
