package unit_2_Robots;

import becker.robots.*;

/**
 * Program that makes A1E3 (and A2E2) with RobotSE and top-down approach.
 */

public class A4E1_CleaningRobot extends RobotSE {
	
	public A4E1_CleaningRobot(City c, int a, int s, Direction d) {
		super(c, s, a, d);
	}
	
	public void cleanRoom() {
		this.goCorner(Direction.NORTH, Direction.EAST);
		
	}
	
	public void move() {
		super.move();
		while (this.canPickThing()) {
			this.pickThing();
		}
	}
	
	private void goCorner(Direction d1, Direction d2) {
		turnDirection(d1);
		// go to north wall
		while (this.frontIsClear()) {
			this.move();
		}
		turnDirection(d2);
		// go to east wall
		
		while (this.frontIsClear()) {
			this.move();
		}
	}
	
	private void turnDirection(Direction d) {
		while (this.getDirection() != d) {
			this.turnLeft();
		}
	}
}
