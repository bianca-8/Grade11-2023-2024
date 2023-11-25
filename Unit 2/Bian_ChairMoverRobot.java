package unit_2_Robots;

import becker.robots.*;

/**
 * Creates a robot that stacks chairs in a room.
 * @author Bianca
 * @version Nov 10, 2023
 */

public class Bian_ChairMoverRobot extends RobotSE {

	/**
	 * Initialize the robot
	 * @param c - city the robot is in
	 * @param a - avenue the robot is on
	 * @param s - street the robot is on
	 * @param d - direction the robot is facing
	 */
	public Bian_ChairMoverRobot(City c, int a, int s, Direction d) {
		super(c, a, s, d);
	}

	/**
	 * Makes the robot move all the chairs to the storage area.
	 */
	public void moveChairs() {
		int [] door = this.findDoor();
		this.findChair(door);
		this.end(door);

	}

	/**
	 * Finds the door of the room.
	 * post: ends up facing north at the door.
	 * @return the coordinates of the door
	 */
	private int [] findDoor() {
		this.goDirection(Direction.EAST);
		int ave = this.getAvenue();
		this.goDirection(Direction.SOUTH);
		int [] door = this.ScanWall(ave);
		return door;
	}

	/**
	 * Scans the south wall for the door.
	 * pre: in the bottom right corner of the room.
	 * post: facing north at the door.
	 * @param ave - avenue of where the 
	 * @return coordinates of the door
	 */
	private int [] ScanWall(int ave) {
		int [] door = new int[2];
		
		// when the left has a wall (no door)
		while (this.frontIsClear() == false) {
			this.turnRight();

			// if there is no wall west
			if (this.frontIsClear()) {
				this.move();
			}

			// door is in directly south of where robot spawned
			else {
				this.turnAround();

				// caf is 1 block wide
				if (this.frontIsClear() == false) {
					this.turnLeft();
					
					// go to top of caf
					while (this.frontIsClear()) {
						this.move();
					}
					this.turnAround();
					
					// go to door
					this.turnLeft();
					// check for street of door
					while (this.frontIsClear() == false) {
						this.turnRight();
						this.move();
						this.turnLeft();
					}
					
					this.turnLeft();
					this.move();
						
					break;
				}

				// the robot is in the storage area, the door is on the right corner
				else {
					// go to avenue before door
					while (this.getAvenue() != ave-1) {
						this.move();
					}

					this.turnLeft();

					// go to the wall before the door
					while (this.frontIsClear()) {
						this.move();
					}
					this.turnRight();
					this.move();
					this.turnLeft();
					this.move();
				}

			}

			this.turnLeft();
		}
		this.turnRight();
		door[0] = this.getAvenue();
		door[1] = this.getStreet();
		return door;
	}

	/**
	 * Makes the robot sweep the room starting from the top left corner to find chairs.
	 * pre: The robot is in the room, facing east.
	 * post: The robot picks up a Thing.
	 * @param door - coordinates of the door.
	 * @return coordinates of the last Thing.
	 */
	private int [] findChair(int [] door) {
		int [] coord = new int[2]; // coordinates of where the robot found garbage
		int counter = 1; // row number (1 is top)

		this.goDirection(Direction.NORTH);
		this.goDirection(Direction.WEST);
		this.turnAround();

		// not at the bottom row of room
		while (this.getStreet() != door[1]) {
			findGarbage(door, coord);

			// go through to the end of the row
			while (this.frontIsClear()) {
				this.move();
				findGarbage(door, coord);
			}
			this.nextRow(counter, door, coord);
			counter += 1;
		}
		findGarbage(door, coord);
		return coord;
	}

	/**
	 * Makes the robot find garbage and put it in the storage room then go back.
	 * @param door - coordinates of the caf door.
	 * @param coord - coordinates of the last position of the robot when finding garbage.
	 */
	private void findGarbage(int [] door, int [] coord) {
		// there is garbage for the robot to pick up
		if (this.canPickThing()) {
			this.pickThing();
			Direction d = this.getDirection();
			coord[0] = this.getAvenue();
			coord[1] = this.getStreet();
			this.goStorage(door);
			this.putThing();
			this.goBack(door, coord, d);
		}
	}

	/**
	 * Makes the robot go to a wall facing a certain direction.
	 * @param d - direction the robot should be facing
	 */
	private void goDirection(Direction d) {
		// turn to direction
		while (this.getDirection() != d) {
			this.turnLeft();
		}

		// go to wall
		while (this.frontIsClear()) {
			this.move();
		}
	}

	/**
	 * Makes the robot go to the next row.
	 * pre: the robot is facing the left or right wall.
	 * post: facing east in the bottom right corner.
	 * @param row - row the robot is on.
	 * @param door - coordinates of the door.
	 * @param coord - coordinates of the last place of the robot before going to the storage room.
	 */
	private void nextRow(int row, int [] door, int [] coord) {
		// even row
		if (row % 2 == 0) {
			this.turnLeft();
			
			// move if clear, pick up garbage if it's there
			if (this.frontIsClear()) {
				this.move();
				findGarbage(door, coord);
			}
			this.turnLeft();
		}

		// odd row
		else {
			this.turnRight();
			
			// move if clear, pick up garbage if it's there
			if (this.frontIsClear()) {
				this.move();
				findGarbage(door, coord);
			}
			this.turnRight();
		}

		// go to the end of the row
		while (this.frontIsClear()) {
			this.move();
			findGarbage(door, coord);
		}
	}

	/**
	 * The robot goes in the storing area at the next stack of chairs.
	 * pre: The robot has a chair in its backpack.
	 * post: The robot drops is in the storage area.
	 * @param door - coordinates of the door.
	 */
	private void goStorage(int [] door) {
		goAve(door[0], Direction.SOUTH);
		
		// go to storage area
		while (this.frontIsClear()) {
			this.move();
		}

		// pile of chairs not at door avenue
		if (this.canPickThing() == false) {
			this.turnRight();
			
			// go to first stack that has Things
			while (this.canPickThing() == false && this.frontIsClear()) {
				this.move();
			}

			this.turnLeft();
		}

		// pile of chairs at door avenue
		if (this.canPickThing() == true) {
			this.turnLeft();
		}

		// there are 10 Things, need to move to next stack
		while (this.countThings() >= 10) {
			this.move();
		}

	}

	/**
	 * Returns the number of things at the intersection.
	 * @return amount of things at the intersection.
	 */
	private int countThings() {
		int amount = 0;

		// there is a Thing
		while (this.canPickThing()) {
			this.pickThing();
			amount++;
		}

		// put down the same amount of things picked up to count
		for (int i = 0; i < amount; i++) {
			this.putThing();
		}

		return amount;
	}

	/**
	 * Makes the robot go back to its spot from where it was scanning.
	 * pre: The robot is in the storage area.
	 * post: The robot is at its last location in the caf.
	 * @param door - coordinates of the caf door.
	 * @param coord - coordinates of the last location of the robot before getting a Thing.
	 * @param d - direction the robot should end facing.
	 */
	private void goBack(int [] door, int [] coord, Direction d) {
		goAve(door[0], Direction.NORTH);

		// go to caf entrance
		while (this.getStreet() != door[1]) {
			this.move();
		}

		// go to avenue of thing (vertical)
		while (this.getAvenue() != coord[0]) {
			goAve(coord[0], Direction.EAST);
		}

		// go to street of thing (horizontal)
		while (this.getStreet() != coord[1]) {
			goStr(coord[1], Direction.EAST);
		}

		// make the robot face the direction it was facing before
		while (this.getDirection() != d) {
			this.turnLeft();
		}

		findGarbage(door, coord);
	}

	/**
	 * Makes the robot go the avenue given and facing the direction given.
	 * @param ave - avenue the robot needs to go to.
	 * @param d - direction the robot needs to face at the end.
	 */
	private void goAve(int ave, Direction d) {
		// robot is on right side of door
		while (this.getAvenue() > ave) {
			
			// make the robot turn to facing west
			while (this.getDirection() != Direction.WEST) {
				this.turnLeft();
			}
			this.move();

		}

		// robot is on left side of door
		while (this.getAvenue() < ave) {

			// make the robot turn to facing east
			while (this.getDirection() != Direction.EAST) {
				this.turnRight();
			}	
			this.move();
		}

		// turn to facing direction
		while (this.getDirection() != d) {
			this.turnLeft();
		}
	}
	
	/**
	 * Makes the robot go to the street given and facing the direction given.
	 * @param str - street the robot needs to go to.
	 * @param d - direction the robot needs to face at the end.
	 */
	private void goStr(int str, Direction d) {
		// robot is on right side of door
		while (this.getStreet() > str) {

			// make the robot turn to facing west
			while (this.getDirection() != Direction.NORTH) {
				this.turnLeft();
			}
			this.move();
		}

		// robot is on left side of door
		while (this.getStreet() < str) {

			// make the robot turn to facing east
			while (this.getDirection() != Direction.SOUTH) {
				this.turnRight();
			}
			this.move();
		}

		// turn to facing direction
		while (this.getDirection() != d) {
			this.turnLeft();
		}
	}

	/**
	 * Makes the robot go to above the last stack of chairs.
	 * @param door - coordinates of the door.
	 */
	private void end(int [] door) {
		this.goStorage(door);
		this.turnLeft();
		this.move();
	}
}