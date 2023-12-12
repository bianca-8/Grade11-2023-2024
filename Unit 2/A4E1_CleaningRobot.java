package unit_2_Robots;

import becker.robots.*;

/**
 * Program that makes A1E3 (and A2E2) with RobotSE and top-down approach.
 */

public class A4E1_CleaningRobot extends RobotSE {
	
	/**
	 * Constructor method for the cleaning robot.
	 * @param c - city the robot is in.
	 * @param a - avenue the robot is on.
	 * @param s - street the robot is on.
	 * @param d - direction the robot is facing.
	 */
	public A4E1_CleaningRobot(City c, int a, int s, Direction d) {
		super(c, s, a, d);
	}
	
	/**
	 * Makes the robot clean the room.
	 */
	public void cleanRoom() {
		this.goCorner(Direction.NORTH, Direction.WEST);
		while (true) {
			while (this.frontIsClear()) {
				this.move();
			}
			if (this.scanRoom() == false) {
				break;
			}
		}
		
	}
	
	/**
	 * Makes the robot go to the opposite bottom corner of the room.
	 * @return boolean for if the robot is at the end of not
	 */
	private boolean scanRoom() {
		while (this.frontIsClear() == false) {
			// odd row - robot was moving eastwards
			if (this.getDirection() == Direction.EAST) {
				this.turnRight();
				if (this.frontIsClear() == true) {
					this.move();
					this.turnRight();
					return true;
				}
				else {
					this.putDownThings();
					return false;
				}
			}
			// even row - robot was moving westwards
			else if (this.getDirection() == Direction.WEST) {
				this.turnLeft();
				if (this.frontIsClear() == true) {
					this.move();
					this.turnLeft();
					return true;
				}
				else {
					this.putDownThings();
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * Makes the robot go to the corner and put down all the things.
	 */
	private void putDownThings() {
		this.goCorner(Direction.NORTH, Direction.WEST);
		this.putAllThings();
	}
	
	/**
	 * Makes the robot move to the wall and pick things.
	 */
	public void move() {
		super.move();
		
		// there is at least one thing the robot can pick up
		while (this.canPickThing()) {
			this.pickThing();
		}
	}
	
	/**
	 * Makes the robot go to a corner of the room.
	 * post: facing opposite to the second direction.
	 * @param d1 - first direction the robot needs to face.
	 * @param d2 - second direction the robot needs to face.
	 */
	private void goCorner(Direction d1, Direction d2) {
		// go to north wall
		this.turnDirection(d1);
		while (this.frontIsClear()) {
			this.move();
		}
		
		// go to east wall
		this.turnDirection(d2);
		while (this.frontIsClear()) {
			this.move();
		}
		
		this.turnAround();
	}
	
	/**
	 * Makes the robot turn to a direction.
	 * @param d - direction the robot needs to turn to.
	 */
	private void turnDirection(Direction d) {
		while (this.getDirection() != d) {
			this.turnLeft();
		}
	}
}
