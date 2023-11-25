package unit_2_Robots;

import becker.robots.*;

/**
 * Information for robot making a bar graph.
 * @author Bianca
 * @version Nov 7, 2023
 */

public class A3E2_BarRobot extends RobotVersion2 {

	/**
	 * Constructor method for the bar graph robot.
	 * @param c - city the robot is in.
	 * @param a - avenue the robot is on.
	 * @param s - street the robot is on.
	 * @param d - direction the robot is facing.
	 */
	public A3E2_BarRobot(City c, int a, int s, Direction d) {
		super(c, a, s, d);
	}
	
	/**
	 * Makes the robot move forward, drop Things, go back, and go to the next avenue.
	 */
	public void create() {
		// there are more rows with Things on them
		while (this.canPickThing()) {
			this.pickAllThings();
			int steps = steps();
			this.go();
			this.goBack(steps);
			this.goDown();
		}
	}
	
	/**
	 * Make the robot move forward and drop Things.
	 */
	private void go() {
		steps();
		// there are still Things in backpack
		while (this.countThingsInBackpack() > 0) {
			// no wall in front of robot
			if (this.frontIsClear()) {
				this.move();
			}
			this.putThing();
		}
	}
	
	/**
	 * Make the robot go back to the start of the row.
	 * @param steps - number of steps the robot took
	 */
	private void goBack(int steps) {
		this.turnAround();
		this.move(steps);
	}
	
	/**
	 * Makes the robot go down to the next row.
	 * pre: facing west
	 * post: facing east
	 */
	private void goDown() {
		this.turnLeft();
		this.move();
		this.turnLeft();
	}
	
	/**
	 * Counts the number of Things in the robot's backpack
	 * @return the number of Things in the robot's backpack
	 */
	private int steps() {
		int num = this.countThingsInBackpack();
		return num;
	}
}
