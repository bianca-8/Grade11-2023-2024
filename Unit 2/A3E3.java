package unit_2_Robots;

import becker.robots.*;
import java.util.Random;

/**
 * Robot that clears a 1 avenue tunnel of things and deposits them outside the tunnel.
 * @author Bianca
 * @version Nov 7, 2023
 */

public class A3E3 {

	public static void main(String[] args) {
		Random r = new Random();
		int a = r.nextInt(10)+1; // avenue for start of tunnel on west (vertical)
		int s = r.nextInt(10)+1; // starting street for tunnel (horizontal)
		int l = r.nextInt(10)+1; // length of tunnel (number of streets)
		
		City oakville = new City(s-2, a-3, 5, l+4); // starting street, starting avenue, add on to street, add on to avenue
		A3E3_CleanerRobot cleaner = new A3E3_CleanerRobot(oakville, s, a-2, Direction.EAST);
		
		// generate the map
		wall(oakville, a, s, l);
		thing(oakville, a, s, l);
		
		// make the robot clean
		cleaner.clean();
	}
	
	/**
	 * Make the walls of the tunnel.
	 * @param c - city the robot is in
	 * @param ave - avenue of the start of the tunnel.
	 * @param str - street of the tunnel start of the tunnel.
	 * @param len - length of the tunnel.
	 */
	@SuppressWarnings("unused")
	public static void wall(City c, int ave, int str, int len) {
		// make the north and south walls of the tunnel.
		for (int i = ave; i <= ave+len-1; i++) {
			Wall wall = new Wall(c, str, i, Direction.NORTH);
			Wall wall1 = new Wall(c, str, i, Direction.SOUTH);
		}
		Wall wallStart = new Wall(c, str, ave-2, Direction.WEST);
		Wall wallEnd = new Wall(c, str, ave+len-1, Direction.EAST);
		
	}
	
	/**
	 * Puts the things in the tunnel.
	 * @param c - city the robot is in
	 * @param ave - avenue of the start of the tunnel.
	 * @param str - street of the tunnel start of the tunnel.
	 * @param len - length of the tunnel.
	 */
	@SuppressWarnings("unused")
	public static void thing(City c, int ave, int str, int len) {
		// put a thing in each intersection in the tunnel.
		for (int i = ave; i < ave+len; i++) {
			Thing thing = new Thing(c, str, i);
		}
	}

}
