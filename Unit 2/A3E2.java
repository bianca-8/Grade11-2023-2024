package unit_2_Robots;

import becker.robots.*;
import java.util.Random;

/**
 * Makes a robot that creates a bar graph out of Things.
 * @author Bianca
 * @version Nov 7, 2023
 */

public class A3E2 {

	public static void main(String[] args) {
		Random r = new Random();
		City oakville = new City(10,10);
		A3E2_BarRobot robot = new A3E2_BarRobot(oakville, 1, 1, Direction.EAST);
		oakville.showThingCounts(true);
		
		drawThings(r, oakville);
		
		robot.create();

	}
	
	/**
	 * Puts the things on the map.
	 * @param r - random number generator
	 * @param oakville - city the robot is in.
	 */
	@SuppressWarnings("unused")
	public static void drawThings(Random r, City oakville) {
		// put random # of dots in rows
		// number of rows
		for (int i = 1; i < r.nextInt(10)+2; i++) {
			// number of dots at each row
			for (int j = 1; j < r.nextInt(10)+2; j++) {
				Thing dot = new Thing(oakville, i, 1);
			}
		}
	}

}
