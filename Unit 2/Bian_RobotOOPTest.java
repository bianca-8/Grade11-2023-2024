package unit_2_Robots;

import becker.robots.*;

/**
 * Program that makes a robot that steals things from a robot.
 * @author Bianca
 * @version Nov 28, 2023
 */

public class Bian_RobotOOPTest {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		City c = new City(10,10);
		c.showThingCounts(true);
		Bian_RobberRobot robber = new Bian_RobberRobot(c, 3, 2, Direction.SOUTH);

		Wall wall = new Wall(c, 2, 3, Direction.NORTH); // Wall of the original place of the robber
		// make the houses
		house(c, 4, 3, Direction.WEST, 5);
		house(c, 6, 8, Direction.WEST, 3);
		// makes the flags
		Thing thing = new Thing(c, 3, 3);
		Thing thing1 = new Thing(c, 8, 3);
		
		robber.robHouse(1);
		robber.robHouse(2);
		
	}

	/**
	 * Makes a house.
	 * @param c - city the wall is in.
	 * @param a - avenue the wall is on.
	 * @param s - street the wall is on.
	 * @param d - side of the wall that is open.
	 * @param things - number of things in the house.
	 * @param origA - starting avenue of the robber.
	 */
	@SuppressWarnings("unused")
	public static void house(City c, int a, int s, Direction d, int things) {
		Direction [] direc = {Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST};

		// Makes 3 walls
		for (int i = 0; i < 4; i++) {
			if (direc[i] != d) {
				Wall wall = new Wall(c, s, a, direc[i]);
			}

		}
		
		// Makes things number of things.
		for (int i = 0; i < things; i++) {
			Thing thing = new Thing(c, s, a);
		}

	}

}
