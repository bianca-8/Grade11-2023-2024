package unit_2_Robots;

import becker.robots.*;

public class A4_ParanoidRobot extends RobotSE {

	public A4_ParanoidRobot(City c, int a, int s, Direction d) {
		super(c, a, s, d);
	}
	
	/**
	 * Overriding the move method
	 */
	public void move() {
		System.out.println("I'm nervous, but I'll try to move");
		this.lookBothWays();
		this.move();
	}
	
	/**
	 * Method that makes the robot look left and then right.
	 */
	private void lookBothWays() {
		this.turnLeft();
		this.turnAround();
		this.turnLeft();
	}

}
