package unit_2_Robots;

import java.util.Random;

import becker.robots.*;

/**
 * Robot that draws a spiral with Things.
 * @author Bianca
 * @version Nov 7, 2023
 */

public class A3E4 {

	public static void main(String[] args) {
		
		Random r = new Random();
		int a = r.nextInt(10); // starting avenue for the robot (vertical)
		int s = r.nextInt(10); // starting street for the robot (horizontal)
		int num = r.nextInt(3); // random number for the length of spiral
		int l = (num+2)*2; // length of the spiral (amounts of streets or avenues), is even  
		Direction [] direc = {Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST};
		
		City oakville = new City(a-l/2, s-l/2, l+1, l+1); // starting ave, starting str, add on to ave, add on to str
		oakville.showThingCounts(true);
		A3E4_SpiralBot bot = new A3E4_SpiralBot(oakville, s, a, direc[r.nextInt(4)]);
		
		bot.makeSpiral(num+1);

	}

}
