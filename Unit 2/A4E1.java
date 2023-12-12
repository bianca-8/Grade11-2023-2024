package unit_2_Robots;

import java.util.Random;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Thing;
import becker.robots.Wall;

public class A4E1 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// variables
		Wall [] [] walls = new Wall[4][5];
		Random r = new Random();

		// drawing
		City oakville = new City();
		A4E1_CleaningRobot guy = new A4E1_CleaningRobot(oakville, r.nextInt(4)+1, r.nextInt(5)+1, Direction.EAST);
		for (int i = 0; i < 5; i++) {
			Thing thing = new Thing(oakville, r.nextInt(4)+1, r.nextInt(5)+1);
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

		guy.cleanRoom();

	}

}
