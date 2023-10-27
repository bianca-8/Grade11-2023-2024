package unit_0_java_basics;

import java.util.Scanner;

/**
 * Program that calculates the amount of touchdowns.
 * @author Bianca
 * @version Sept. 15, 2023
 */

public class PaperPractice2 {

	public static void main(String[] args) {
		
		int points;
		double touchdowns;
		final int TOUCHDOWN = 7;
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the team's points: ");
		points = input.nextInt();
		input.close();
		
		touchdowns = points / TOUCHDOWN;
				
		System.out.format("The team could have scored %.0f touchdowns.", touchdowns);

	}

}
