package unit_2_Robots;

import becker.robots.*;

/**
 * Program that tests RobotVersion2
 * @author Bianca
 * @version Nov 2, 2023
 */

public class A2E1 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		City oakville = new City();
		RobotVersion2 guy = new RobotVersion2(oakville, 1, 1, Direction.EAST);
		Thing dot = new Thing(oakville, 3, 1);
		Thing dot1 = new Thing(oakville, 3, 1);
		Thing dot2 = new Thing(oakville, 3, 1);
		guy.turnRight();
		guy.move(2);
		guy.turnAround();
		guy.pickThing(3);
		guy.pickAllThings();
		guy.putAllThings();
		System.out.print(guy.countThings());

	}

}
