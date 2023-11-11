package unit_2_Robots;

import becker.robots.*;

/**
 * Information for robot making a bar graph.
 * @author Bianca
 * @version Nov 7, 2023
 */

public class A3E2_BarRobot extends RobotVersion2 {

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
			this.go();
			this.goBack(steps());
			System.out.print(steps());
			this.goDown();
		}
	}
	
	/**
	 * Make the robot move forward and drop Things.
	 */
	public void go() {
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
	public void goBack(int steps) {
		this.turnAround();
		this.move(steps);
	}
	
	/**
	 * Makes the robot go down to the next row.
	 * pre: facing west
	 * post: facing east
	 */
	public void goDown() {
		this.turnLeft();
		this.move();
		this.turnLeft();
	}
	
	/**
	 * Counts the number of Things in the robot's backpack
	 * @return the number of Things in the robot's backpack
	 */
	public int steps() {
		int num = this.countThingsInBackpack();
		return num;
	}
}
