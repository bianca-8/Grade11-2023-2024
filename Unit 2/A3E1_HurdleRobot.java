package unit_2_Robots;

import becker.robots.*;

/**
 * Robot that jumps over robots.
 * @author Bianca
 * @version Nov 7, 2023 
 */

public class A3E1_HurdleRobot extends RobotSE {

	/**
	 * Constructor method
	 * @param c - city the robot is in
	 * @param a - avenue the robot is on
	 * @param s - street the robot is on
	 * @param d - direction the robot is facing
	 */
	public A3E1_HurdleRobot(City c, int a, int s, Direction d) {
		super(c, a, s, d);
	}

	/**
	 * make the robot run its portion of the race by jumping over the hurdle
	 */
	public void runRace() {
		this.pickBaton();
		for (int i = 0; i < 2; i++) {
			this.runToHurdle();
			this.jumpHurdle();
		}
		this.passBaton();

	}

	/**
	 * Makes the robot pick up the baton.
	 * pre: The robot is starting on the baton.
	 */
	private void pickBaton() {
		this.pickThing();
	}

	/**
	 * Makes the robot run to the hurdle
	 * pre: facing the hurdle
	 */
	private void runToHurdle() {
		while (this.frontIsClear()) {
			this.move();
		}
	}

	/**
	 * Makes the robot run over the hurdle.
	 * pre: not facing the hurdle
	 */
	private void jumpHurdle() {
		this.jumpUp();
		this.goAcross();
		this.land();
	}
	
	/**
	 * Makes the robot jump vertically for a hurdle.
	 * pre: assume the robot is facing the hurdle and right at the 
	 * post: up the height of the hurdle and facing the sky
	 */
	private void jumpUp() {
		this.turnLeft();
		this.move(2);
	}
	
	/**
	 * Makes the robot go across the hurdle.
	 * pre: robot is not facing the hurdle
	 */
	private void goAcross() {
		this.turnRight();
		this.move();
	}
	
	/**
	 * Makes the robot land on the other side of the hurdle.
	 * pre: the robot is not facing downwards.
	 */
	private void land() {
		this.turnRight();
		this.move(2);
		this.turnLeft();
	}
	
	/**
	 * Makes the robot pass the baton by dropping it
	 */
	private void passBaton() {
		this.putThing();
	}
	
	/**
	 * Makes the ground the robot is on.
	 * @param c - city the robot is in
	 * @param y - y coordinate of the robot
	 * @param x - x coordinate of the robot
	 * @param d - direction the robot is facing
	 */
	@SuppressWarnings("unused")
	public void ground(City c, int y, int x, Direction d) {
		Wall ground = new Wall(c, y, x, d);
	}
	
	/**
	 * Makes the hurdles the robot jumps over
	 * @param c - city the robot is in
	 * @param y - y coordinate of the robot
	 * @param x - x coordinate of the robot
	 * @param d - direction the robot is facing
	 */
	@SuppressWarnings("unused")
	public void hurdle(City c, int y, int x, Direction d) {
		Wall hurdle = new Wall(c, y, x, d);
		Wall hurdle1 = new Wall(c, y-1, x, d);
	}
}
