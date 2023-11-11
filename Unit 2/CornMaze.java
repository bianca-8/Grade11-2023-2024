package unit_2_Robots;

import becker.robots.*;
import java.util.Random;

/**
 * Program that get a robot to find a thing in a maze.
 * @author Bianca
 * @version Nov 3, 2023
 */

public class CornMaze {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Random r = new Random();

		MazeCity cornField = new MazeCity(10,10); // dimensions of maze
		RobotSE guy = new RobotSE(cornField, r.nextInt(10), r.nextInt(10), Direction.NORTH);
		Thing dot = new Thing(cornField, r.nextInt(10), r.nextInt(10));

		// not at a Thing
		while (guy.canPickThing() == false) {
			guy.turnLeft();
			// no wall left -- go left
			if (guy.frontIsClear()) {
				guy.move();
			}
			// wall is left -- turn forward
			else {
				guy.turnRight();
				// forward has no wall -- go forward
				if (guy.frontIsClear()) {
					guy.move();
				}
				// forward has wall -- turn right
				else {
					guy.turnRight();
					// right has no wall -- go right
					if (guy.frontIsClear()) {
						guy.move();
					}
					// right has wall -- go backwards
					else {
						guy.turnRight();
					}
				}
			}
		}
		guy.pickThing();
	}
}
