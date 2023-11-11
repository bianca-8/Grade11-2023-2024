package unit_2_Robots;

import becker.robots.*;

/**
 * Defines a better robot that can turnRight
 * @author Bianca
 * @version Nov 2, 2023
 */

public class RobotVersion2 extends Robot {

	/**
	 * The constructor method for making RobotVersion2 objects
	 * @param c - city where the robot is in
	 * @param ave - initial avenue location of the robot
	 * @param str - initial street location of the robot
	 * @param d - initial direction the robot is facing
	 */
	public RobotVersion2(City c, int ave, int str, Direction d) {
		super(c, ave, str, d); // new robot(...)
	}

	/**
	 * Makes the robot turn right by turning left 3 times.
	 */
	public void turnRight() {
		// 3 left turns = 1 right
		for (int i = 0; i < 3; i++) {
			this.turnLeft();
		}
	}

	/**
	 * Makes the robot turning around 180 degrees by turning left 2 times.
	 */
	public void turnAround() {
		// 2 left turns = 180 degree turn
		for (int i = 0; i < 2; i++) {
			this.turnLeft();
		}
	}

	/**
	 * Makes the robot move a set number of times.
	 * @param numSteps - number of steps for the robot to move
	 */
	public void move(int numSteps) {
		// move "numSteps" forward
		for (int i = 0; i < numSteps; i++) {
			// there is no wall in front of the robot
			if (this.frontIsClear() == true) {
				this.move();
			}
		}
	}

	/**
	 * Makes the robot pick up a certain number of things.
	 * @param numThings - number of things for the robot to pick up.
	 */
	public void pickThing(int numThings) {
		// pick things "numThings" times
		for (int i = 0; i < numThings; i++) {
			// there is a thing at the robot
			if (this.canPickThing() == true) {
				this.pickThing();
			}
		}
	}

	/**
	 * Returns the number of things at the intersection.
	 * @return amount of things at the intersection.
	 */
	public int countThings() {
		int amount = 0;
		while (this.canPickThing()) {
			this.pickThing();
			amount++;
		}
		for (int i = 0; i < amount; i++) {
			this.putThing();
		}
		
		return amount;
	}

	/**
	 * Makes the robot pick up all the things at the intersection.
	 */
	public void pickAllThings() {
		// there is a thing at the robot
		while (this.canPickThing() == true) {
			this.pickThing();
		}
	}

	/**
	 * Makes the robot put down all the things in its backpack.
	 */
	public void putAllThings() {
		// there are things in the backpack
		while (this.countThingsInBackpack() > 0) {
			this.putThing();
		}
	}
}
