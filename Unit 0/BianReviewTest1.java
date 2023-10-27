package unit_0_java_basics;

/**
 * Program that shifts shifts each character in a string a user inputs by an inputed number (different amount than string length) - Level 4
 * @author Bianca
 * @version Oct 11, 2023
 */

import java.util.*;

public class BianReviewTest1 {

	public static void main(String[] args) {
		String str;
		ArrayList <Integer> num = new ArrayList<Integer>();
		int place = 0;
		String substr = null;
		
		num.add(1);
		num.add(2);
		num.add(3);
		num.add(1);
		num.add(-1);
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a message: ");
		str = input.nextLine();
		
		/*System.out.print("Enter shift values (end with -1): ");
		while (input.nextInt() != -1) {
			System.out.print("Enter shift values (end with -1): ");
			num.add(new Integer(input.nextInt()));
		}*/

		for (int j = 0; j < str.length(); j++) {
			for (int k = 0; k < num.size() - 1; k++) {
				if ((int)str.charAt(j) != 32) {
					System.out.println(str.charAt(j) + " " + j + " " + num.get(k) + " " + k);
					place = (int)str.charAt(j)+num.get(k);
					
					
				}
				
				else {
					System.out.print(str.charAt(j));
				}
				substr += (char)place;
				//System.out.print(substr.substring(j));
			}
			
			
		}
		
		
		input.close();

	}

}
