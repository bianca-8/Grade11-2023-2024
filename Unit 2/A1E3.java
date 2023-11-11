package unit_2_Robots;

import becker.robots.*;

import java.util.Random;

/**
 * Program that puts 5 things in the city and has a robot to clean it up.
 * @author Bianca
 * @version Oct 31, 2023
 */

public class A1E3 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// variables
		Wall [] [] walls = new Wall[4][5];
		Random r = new Random();

		// drawing
		City oakville = new City();
		Robot guy = new Robot(oakville, 1, 1, Direction.EAST);
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
		while (guy.canPickThing() == true) {
			guy.pickThing();
		}
		// turn right
		for (int i = 0; i < 3; i++) {
			guy.turnLeft();
		}
		// move down column
		for (int j = 0; j < 3; j++) {
			guy.move();
			// guy at thing
			while (guy.canPickThing() == true) {
				guy.pickThing();
			}
		}

		// move up and down columns
		for (int i = 0; i < 2; i++) {
			guy.turnLeft();
			guy.move();
			// guy at thing
			while (guy.canPickThing() == true) {
				guy.pickThing();
			}
			guy.turnLeft();

			// move up column
			for (int j = 0; j < 3; j++) {
				guy.move();
				// guy at thing
				while (guy.canPickThing() == true) {
					guy.pickThing();
				}
			}

			// turn right
			for (int j = 0; j < 3; j++) {
				guy.turnLeft();
			}
			guy.move();
			// guy at thing
			while (guy.canPickThing() == true) {
				guy.pickThing();
			}
			// turn right
			for (int j = 0; j < 3; j++) {
				guy.turnLeft();
			}
			// move down column
			for (int j = 0; j < 3; j++) {
				guy.move();
				// guy at thing
				while (guy.canPickThing() == true) {
					guy.pickThing();
				}
			}
		}
		
		// go back to top left corner
		// turn 180 degrees
		for (int j = 0; j < 2; j++) {
			guy.turnLeft();
		}
		for (int i = 0; i < 3; i++) {
			guy.move();
		}
		guy.turnLeft();
		for (int i = 0; i < 4; i++) {
			guy.move();
		}

		// picked up things
		while (guy.countThingsInBackpack() > 0) {
			guy.putThing();
		}

	}

}

