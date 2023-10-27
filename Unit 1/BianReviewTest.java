package unit_0_java_basics;

/**
 * Program that shifts shifts each character in a string a user inputs by inputed numbers (same amount of #s as length of string), spaces stay the same - Level 3
 * @author Bianca
 * @version Oct 11, 2023
 */

import java.util.*;

public class BianReviewTest {

	@SuppressWarnings("removal")
	public static void main(String[] args) {
		String str;
		ArrayList <Integer> num = new ArrayList<Integer>();
		int place;
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a message: ");
		str = input.nextLine();
		
		System.out.print("Enter shift values: ");
		for (int i = 0; i < str.length(); i++) {
			num.add(new Integer(input.nextInt()));
		}
		
		for (int j = 0; j < str.length(); j++) {
			if ((int)str.charAt(j) != 32) {
				place = (int)str.charAt(j)+num.get(j);
				System.out.print((char)place);
			}
			else {
				System.out.print(str.charAt(j));
			}
		}
		
		input.close();
		
		

	}

}
