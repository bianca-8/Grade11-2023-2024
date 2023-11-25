package unit_2_Robots;

import java.util.Random;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Thing;
import becker.robots.Wall;

public class A4E1 {

	public static void main(String[] args) {
		// variables
		Wall [] [] walls = new Wall[4][5];
		Random r = new Random();

		// drawing
		City oakville = new City();
		RobotVersion2 guy = new RobotVersion2(oakville, 1, 1, Direction.EAST);
		for (int i = 0; i < 5; i++) {
			Thing dot = new Thing(oakville, r.nextInt(4)+1, r.nextInt(5)+1);
		}

		// walls
		for (int j = 0; j < 5; j++) { // vert column
			// row 1 -- top
			walls[0][j] = new Wall(oakville, 1, j+1, Direction.NORTH);;
			// row 4 -- bottom
			walls[3][j] = new Wall(oakville, 4, j+1, Direction.SOUTH);;
		}	
		for (int i = 0; i < 4; i++) { // horizontal row
			// column 1 -- left
			walls[i][0] = new Wall(oakville, i+1, 1, Direction.WEST);;
			// column 5 -- right
			walls[i][4] = new Wall(oakville, i+1, 5, Direction.EAST);;
		}

		// robot collecting things
		// guy at thing
		guy.pickAllThings();
		guy.turnRight();
		for (int j = 0; j < 3; j++) {
			guy.move();
			guy.pickAllThings();
		}

		// move up and down columns
		for (int i = 0; i < 2; i++) {
			guy.turnLeft();
			guy.move();
			guy.pickAllThings();
			guy.turnLeft();

			for (int j = 0; j < 3; j++) {
				guy.move();
				guy.pickAllThings();
			}
			guy.turnRight();
			guy.move();
			guy.pickAllThings();
			guy.turnRight();
			for (int j = 0; j < 3; j++) {
				guy.move();
				guy.pickAllThings();
			}
		}

		// go back to top left corner
		guy.turnAround();
		guy.move(3);
		guy.turnLeft();
		guy.move(4);

		guy.putAllThings();

	}

}
