package unit_2_Robots;

import becker.robots.*;

/**
 * Program that creates a walled city.
 * @author Bianca
 * @version Oct 31, 2023
 */

public class A1E2 {

	public static void main(String[] args) {
		// variables
		Wall [] [] walls = new Wall[4][5];

		// drawing
		City oakville = new City();

		for (int j = 0; j < 5; j++) { // vert column
			// row 1 -- top
			walls[0][j] = new Wall(oakville, 1, j+1, Direction.NORTH);
			// row 4 -- bottom
			walls[3][j] = new Wall(oakville, 4, j+1, Direction.SOUTH);
		}	
		for (int i = 0; i < 4; i++) { // horizontal row
			// column 1 -- left
			walls[i][0] = new Wall(oakville, i+1, 1, Direction.WEST);
			// column 5 -- right
			walls[i][4] = new Wall(oakville, i+1, 5, Direction.EAST);
		}
	}
}
