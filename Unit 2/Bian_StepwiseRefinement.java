package unit_2_Robots;

import becker.robots.*;
import java.util.Random;

/**
 * Gets a robot to stack chairs in a room.
 * @author Bianca
 * @version Nov 10, 2023 
 */

public class Bian_StepwiseRefinement {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Direction [] direc = {Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST};
		
		City woss = new City(10,10);
		woss.showThingCounts(true);
		Random r = new Random();
		int [] coordinates = {1, 1, 8, 5, 5, 8}; // wall avenue, wall street, storage street, door avenue, wall length, wall width
		int ave = r.nextInt(coordinates[4])+1;
		int str = r.nextInt(coordinates[5])+1;
		int maxThing = coordinates[5]*10;
		Bian_ChairMoverRobot robot = new Bian_ChairMoverRobot(woss, ave, str, direc[r.nextInt(4)]);
		
		// coordinates[1]
		// sides of storage area
		Wall leftWall = new Wall(woss, coordinates[2], coordinates[0], Direction.WEST);
		Wall rightWall = new Wall(woss, coordinates[2], coordinates[0] + coordinates[5] - 1, Direction.EAST);
		
		// top horizontal coordinates[1]
		for (int i = coordinates[0]; i <= coordinates[0] + coordinates[5] - 1; i++) {
			Wall wall = new Wall(woss, coordinates[1], i, Direction.NORTH);
			Wall wall1 = new Wall(woss, coordinates[2], i, Direction.SOUTH); // storage area
		}
		
		// bottom horizontal coordinates[1] before door
		for (int i = coordinates[0]; i <= coordinates[3] - 1; i++) {
			Wall wall = new Wall(woss, coordinates[1] + coordinates[4] - 1, i, Direction.SOUTH);
		}
		
		// bottom horizontal coordinates[1] after door
		for (int i = coordinates[3] + 1; i <= coordinates[0] + coordinates[5] - 1; i++) {
			Wall wall = new Wall(woss, coordinates[1] + coordinates[4] - 1, i, Direction.SOUTH);
		}
		
		// left and right vertical coordinates[1]
		for (int i = coordinates[1]; i <= coordinates[1] + coordinates[4] - 1; i++) {
			Wall wall = new Wall(woss, i, coordinates[0], Direction.WEST);
			Wall wall1 = new Wall(woss, i, coordinates[0] + coordinates[5] - 1, Direction.EAST);
		}
		
		// randomly place garbage
		for (int i = 0; i < r.nextInt(maxThing) + 1; i++) {
			Thing garbage = new Thing(woss, coordinates[1] + r.nextInt(coordinates[4]), coordinates[0] + r.nextInt(coordinates[5]));
		}
		
		robot.moveChairs();

	}

}
