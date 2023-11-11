package unit_2_Robots;

import becker.robots.*;

/**
 * Program that draws 2 robots interacting with a thing.
 * @author Bianca
 * @version Oct 31, 2023
 */

public class MyFirstRobot {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		City oakville = new City();
		Robot karel = new Robot(oakville, 0, 1, Direction.EAST);
		Robot darryl = new Robot(oakville, 2, 1, Direction.EAST);
		Thing toy = new Thing(oakville, 2, 2);
		Wall border = new Wall(oakville, 0, 3, Direction.WEST);
		for (int i = 0; i < 4; i++) {
			karel.move();
		}
		karel.turnLeft();
		if (karel.canPickThing() == true) {
			karel.pickThing();
		}
		
		// darryl's movements
		darryl.move();
		darryl.pickThing();
		for (int i = 0; i < 3; i++) {
			darryl.move();
		}
		darryl.turnLeft();
		for (int i = 0; i < 2; i++) {
			darryl.move();
		}
		if (darryl.countThingsInBackpack() > 0) {
			darryl.putThing();
		}
		
	}

}
