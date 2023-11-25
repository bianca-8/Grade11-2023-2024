package unit_2_Robots;

import becker.robots.*;

/**
 * Robot that makes a spiral.
 * @author Bianca
 * @version Nov 7, 2023
 */

public class A3E4_SpiralBot extends RobotSE {
	
	/**
	 * Constructor method for the spiral bot.
	 * @param c - city the robot is in.
	 * @param a - avenue the robot is at.
	 * @param s - street the robot is at.
	 * @param d - direction the robot is facing.
	 */
	public A3E4_SpiralBot(City c, int a, int s, Direction d) {
		super(c, s, a, d);
	}
	
	/**
	 * Makes the robot make a spiral out of Things.
	 * @param numLoops - number of loops the robot does
	 */
	public void makeSpiral(int numLoops) {
		this.getThings(numLoops);
		this.moveForward(numLoops);
		
	}
	
	/**
	 * Makes the things in the robot's backpack.
	 * @param amount - amount of spirals.
	 */
	private void getThings(int amount) {
		// number of things the robot needs to make
		for (int i = 0; i < Math.pow(amount*2+1, 2); i++) {
			this.makeThing(i, (int)(Math.pow(amount*2+1, 2)));
		}
		
	}
	
	/**
	 * Makes the robot move and put things.
	 * @param numLoops - number of loops the robot needs to do.
	 */
	private void moveForward(int numLoops) {
		// put a Thing on the starting block
		this.canPutThing();
		this.makeLoop(numLoops);

	}
	
	/**
	 * Makes the robot do the amount of loops.
	 * @param numLoops - number of loops the robot needs to do
	 */
	private void makeLoop(int numLoops) {
		int steps = 1;
		int turnCount = 1;
		
		// make the robot make a loop for the given value.
		for (int k = 0; k < numLoops; k++) {
			turnCount = this.goFirstTurn(turnCount);
			
			// amount of turns for 1 spiral
			for (int i = 0; i < 4; i++) {
				this.moveAndPut(steps);
				this.onLastTurn();
				
				steps = changeSteps(steps, turnCount);
				turnCount += 1;
			}
			
		}
	}
	
	/**
	 * Checks if the robot is on the last turn.
	 */
	private void onLastTurn() {
		// not on the last turn
		if (this.countThingsInBackpack() > 0) {
			this.turnLeft();
		}
	}
	
	/**
	 * Makes the robot go the first turn.
	 * @param turnCount - number of turns made.
	 */
	private int goFirstTurn(int turnCount) {
		// the first turn
		if (turnCount == 1) {
			this.move();
			this.turnLeft();
			this.putThing();
			turnCount += 1;
		}
		return turnCount;
	}
	
	/**
	 * Makes the robot move a number of steps and pick up a Thing each step.
	 * @param steps - the number of steps the robot needs to move.
	 */
	private void moveAndPut(int steps) {
		// move the number of steps.
		for (int j = 0; j < steps; j++) {
			this.move();
			this.canPutThing();
		}	
	}
	
	/**
	 * Makes the robot put down a Thing if there is one in its backpack.
	 */
	private void canPutThing() {
		// there is something in the backpack of the robot.
		if (this.countThingsInBackpack() > 0) {
			this.putThing();
		}
	}

	/**
	 * Changes the amount of steps the robot takes by 1 more if it has turned 2 times already.
	 */
	private int changeSteps(int steps, int turnCount) {
		// change the number of steps by 1 if the robot has turned 2 times.
		if (turnCount % 2 == 0) {
			steps += 1;
		}
		return steps;
	}

}
