package unit_2_Robots;

import becker.robots.*;

/**
 * Cleaner robot that cleans up an avenue.
 * @author Bianca
 * @version Nov 7, 2023
 */

public class A3E3_CleanerRobot extends RobotSE {

	/**
	 * Constructor method for the cleaner robot.
	 * @param c - city the robot is in.
	 * @param a - avenue of the robot.
	 * @param s - street of the robot.
	 * @param d - direction the robot is facing.
	 */
	public A3E3_CleanerRobot(City c, int a, int s, Direction d) {
		super(c, a, s, d);
	}

	/**
	 * Makes the robot go to the things and stack them.
	 */
	public void clean() {
		// the robot is not at the end of the tunnel.
		while (true) {
			boolean run = this.goThing();
			this.putDown();
			// the robot went to the end of the tunnel.
			if (run == false) {
				break;
			}
		}

	}

	/**
	 * Make the robot go to the next thing or the end of the tunnel.
	 * @return the robot is at the end of the tunnel or not.
	 */
	private boolean goThing() {
		// go forward until found a thing or reached the end of the tunnel.
		while (this.canPickThing() == false && this.frontIsClear()) {
			this.move();
		}
		this.pickThing();

		return this.atTunnelEnd();

	}
	
	/**
	 * The robot is at the end of the tunnel.
	 * @return the robot is at the end of the tunnel or not.
	 */
	private boolean atTunnelEnd() {
		// at the end of the tunnel
		if (this.frontIsClear() == false) {
			this.turnAround();
			return false;
		}
		
		// not at the end of the tunnel
		else {
			this.turnAround();
			return true;
		}
	}
	
	/**
	 * Makes the robot go to the pile to put down the Thing.
	 */
	private void putDown() {
		// go to the pile to drop the Thing.
		while (this.frontIsClear()) {
			this.move();
		}
		
		this.finish();
	}
	
	/**
	 * Makes the robot finish cleaning.
	 */
	private void finish() {
		this.putThing();
		this.turnAround();
		this.move();
	}
	
}
