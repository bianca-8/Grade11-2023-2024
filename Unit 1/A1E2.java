package unit_1_introOOP;

import java.util.*;

/**
 * Program that creates a signature for the end of an email.
 * @author Bianca
 * @version Oct 6, 2023
 */

public class A1E2 {

	public static void main(String[] args) {
		// Variables
		String name;
		int grade;
		String school;
		
		// Input
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter name: ");
		name = input.nextLine();
		
		System.out.print("Enter grade: ");
		grade = input.nextInt();
		
		input.nextLine();
		
		System.out.print("Enter school: ");
		school = input.nextLine();
		
		input.close();
		
		// Call Methods
		print(name, grade, school);
		
	}
	
	/**
	 * Method that prints out the full name and grade of the sender.
	 * @param name - full name of person
	 * @param grade - grade of person
	 */
	public static void print(String name, int grade, String school) {
		// Variables
		String lname;
		String email;
		
		// Find email
		lname = name.substring(name.indexOf(" ")+1);
		email = lname.toLowerCase() + name.substring(0,1).toLowerCase();
		
		System.out.format("%s, Grade %d\n", name, grade);
		System.out.format("%s@hdsb.ca\n", email);
		System.out.print(school);
	}

}
