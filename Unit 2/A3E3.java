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
		int a = r.nextInt(10)+1; // avenue (on y axis)
		int s = r.nextInt(10)+1; // starting street (on x axis)
		int l = r.nextInt(10)+1; // length of tunnel (number of streets)
		System.out.print(a + " " + s + " " + l);
		
		City oakville = new City(a-1, s, a+1, s+l);
		A3E3_CleanerRobot cleaner = new A3E3_CleanerRobot(oakville, a, s, Direction.EAST);

		cleaner.wall(oakville, a, s, l);
	}

}
