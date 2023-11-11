package unit_2_Robots;

import becker.robots.*;

/**
 * Cleaner robot that cleans up an avenue.
 * @author Bianca
 * @version Nov 7, 2023
 */

public class A3E3_CleanerRobot extends RobotSE {
	
	public A3E3_CleanerRobot(City c, int a, int s, Direction d) {
		super(c, a, s, d);
	}
	
	/**
	 * 
	 * @param c - city the robot is in
	 */
	@SuppressWarnings("unused")
	public void wall(City c, int ave, int str, int len) {
		
		for (int i = str+2; i <= len+str+2; i++) {
			Wall wall = new Wall(c, ave, i, Direction.NORTH);
			Wall wall1 = new Wall(c, ave, i, Direction.SOUTH);
		}
		Wall wallStart = new Wall(c, ave, str, Direction.WEST);
		Wall wallEnd = new Wall(c, ave, str+len, Direction.EAST);
		
	}
	
	
	
}
