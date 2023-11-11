package unit_2_Robots;

import becker.robots.*;

/**
 * Program that makes a robot that jumps over hurdles.
 * @author Bianca
 * @version Nov 7, 2023
 */

public class A3E1 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		City oakville = new City (5, 12);
		A3E1_HurdleRobot r = new A3E1_HurdleRobot(oakville, 5, 12, Direction.NORTH);
		Thing baton = new Thing(oakville, 3, 0);

		A3E1_HurdleRobot runner1 = new A3E1_HurdleRobot(oakville, 3, 0, Direction.EAST);
		A3E1_HurdleRobot runner2 = new A3E1_HurdleRobot(oakville, 3, 4, Direction.EAST);
		
		// Make the obstacle ground and r.hurdles
		// ground
		for (int i = 0; i <= 9; i++) {
			r.ground(oakville, 3, i, Direction.SOUTH);
		}
		// hurdles
		for (int j = 1; j <= 7; j += 2) {
			r.hurdle(oakville, 3, j, Direction.EAST);
		}
		
		runner1.runRace();
		runner2.runRace();
	}

}
