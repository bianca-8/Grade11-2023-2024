package unit_2_Robots;

import becker.robots.*;

public class Bian_RobberRobot extends RobotSE {

	/**
	 * Constructor method for the robber robot.
	 * @param c - city the robot is in.
	 * @param a - avenue the robot is on.
	 * @param s - street the robot is on.
	 * @param d - direction the robot is facing.
	 * @param storage - number of things the robot can carry.
	 */
	public Bian_RobberRobot(City c, int a, int s, Direction d) {
		super(c, s, a, d);
	}
	
	/**
	 * Makes the robot rob the house.
	 * @param storage - number of things the robot can hold.
	 */
	public void robHouse(int storage) {
		this.findFlag();
		this.goHouse(storage);
		this.goFlag();
		this.hasSpace(storage);
	}
	
	/**
	 * Makes the robot find a flag where a house is unattended.
	 * post: robot ends at a flag
	 */
	private void findFlag() {
		this.move();
		// the robot is not at the flag
		while (this.canPickThing() == false) {
			this.move();
		}
	}
	
	/**
	 * Makes a robot go to a house after it finds a flag and robs it.
	 * @param storage - number of things the robot can hold.
	 */
	private void goHouse(int storage) {
		this.turnLeft();
		// makes the robot go to the house
		while (this.frontIsClear()) {
			this.move();
		}
		
		// there are more things the robot can pick up
		while (this.canPickThing()) {
			// the number of things the robot has picked up is the maximum
			if (this.countThingsInBackpack() >= storage) {
				this.goBackHouse(storage);
				break;
			}
			
			this.pickThing();
		}
	}
	
	/**
	 * Makes the robot go back to the house and get what it missed.
	 * @param storage - number of things the robot can hold.
	 */
	private void goBackHouse(int storage) {
		this.goFlag();
		this.goStarting();
		this.findFlag();
		this.goHouse(storage);
		
	}
	
	/**
	 * Makes the robot find the flag from the house.
	 */
	private void goFlag() {
		this.turnAround();
		this.findFlag();
		this.turnRight();

	}
	
	/**
	 * Makes the robot pick up things if there is space in its backpack
	 * @param storage - number of things the robot can hold.
	 */
	private void hasSpace(int storage) {
		// pick up the thing if there is space in the backpack.
		if (this.countThingsInBackpack() < storage) {
			this.pickThing();
			this.goStarting();
		}
		// there is no space in the backpack
		else {
			getFlag();
		}
	}
	
	/**
	 * Makes the robot put down things and go back for the flag.
	 */
	private void getFlag() {
		this.goStarting();
		this.findFlag();
		this.pickThing();
		this.turnAround();
		this.goStarting();
	}
	
	/**
	 * Makes the robot go back to its starting place.
	 * pre: at the flag
	 */
	private void goStarting() {
		// makes the robot go to its starting place
		while (this.frontIsClear()) {
			this.move();
		}
		this.turnAround();
		
		this.putAllThings();
	}

	
	
}
