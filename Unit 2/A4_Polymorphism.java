package unit_2_Robots;

import becker.robots.*;

public class A4_Polymorphism {

	public static void main(String[] args) {

		City oakville = new City();
		
		// declare an array of robots
		Robot [] helper = new Robot[3];

		// initialize the array with 3 different types of robots
		helper[0] = new Robot(oakville, 0, 1, Direction.EAST);
		helper[1] = new RobotSE(oakville, 1, 1, Direction.EAST);
		helper[2] = new A4_ParanoidRobot(oakville, 2, 1, Direction.EAST);

		// make each robot move forward one intersection
		for (int i=0; i<helper.length; i++) {
			helper[i].move();
		}

	}

}
