package unit_2_Robots;

import becker.robots.*;

/**
 * Program that writes a B with things.
 * @author Bianca
 * @version Oct 31, 2023
 */

public class A1E1 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		City oakville = new City();
		Robot guy = new Robot(oakville, 0, 0, Direction.EAST);
		for (int i = 0; i < 18; i++) {
			// make 18 things
			Thing dot = new Thing(oakville, 0, 0);
			
			// pick up 14 things
			guy.pickThing();
		}
		// move forward and place thing
		for (int i = 0; i < 4; i++) {
			guy.move();
			guy.putThing();
		}

		// turn right
		for (int i = 0; i < 3; i++) {
			guy.turnLeft();
		}
		// move forward and place thing
		for (int i = 0; i < 2; i++) {
			guy.move();
			guy.putThing();
		}

		// turn right
		for (int i = 0; i < 3; i++) {
			guy.turnLeft();
		}

		for (int i = 0; i < 2; i++) {
			guy.move();
			guy.turnLeft();
			guy.move();
			guy.putThing();
		}

		// turn right
		for (int i = 0; i < 3; i++) {
			guy.turnLeft();
		}

		// move forward and place thing
		for (int i = 0; i < 2; i ++) {
			guy.move();
			guy.putThing();
		}

		// turn right
		for (int i = 0; i < 3; i++) {
			guy.turnLeft();
		}

		// move forward and place thing
		for (int i = 0; i < 3; i++) {
			guy.move();
			guy.putThing();
		}

		// turn right
		for (int i = 0; i < 3; i++) {
			guy.turnLeft();
		}

		// move forward and place thing
		for (int i = 0; i < 5; i++) {
			guy.move();
			guy.putThing();
		}

	}

}
