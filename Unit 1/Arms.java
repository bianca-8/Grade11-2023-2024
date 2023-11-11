package unit_1_OOP;
import java.awt.*;
/**This program contains various methods that are responsible for creating a drawing of a robot arm.
 * @author Nyna Pinnamaraju
 * @version October 24, 2023
 */

public class Arms {
	/**
	 * This method creates the right arm of a robot.
	 * @param Graphics, x coordinate, y coordinate
	 */
	private static void drawRightArm(Graphics g, int x, int y) {
		g.setColor(Color.BLACK);
		g.fillRect(x, y, 20, 10); 	//attachment piece
		//Claw - Thumb
		for (int i=(x+30);i<=(x+50);i++) {
			g.drawLine(i, y+250, i-20, y+275);
		}
		//Claw - Long Finger Part 1
		for (int i=(x+55);i<=(x+75);i++) {
			g.drawLine(i, y+250, i+20, y+275);
		}
		//Claw - Long Finger Part 2
		for (int i=(x+75);i<=(x+95);i++) {
			g.drawLine(i, y+275, i-20, y+300);
		}
		for (int i=(x+30);i<=(x+70);i++) {	 //Top grey part
			if (i<=(x+40) ||i>=(x+60)) {
				g.setColor(Color.BLACK);
			}
			else {
				g.setColor(Color.GRAY);
			}
			g.drawLine(i, y+30, i+65, y+130);
		}
		for (int i=(x+135);i>=(x+95);i--) {	//Bottom grey part
			if (i>=(x+125) ||i<=(x+105)) {
				g.setColor(Color.BLACK);
			}
			else {
				g.setColor(Color.GRAY);
			}
			g.drawLine(i, y+130, i-65, y+230);	
		}
		g.setColor(Color.ORANGE);
		//Bottom part of the arm (Orange)
		g.fillRect(x+30, y+220, 45, 31);
		g.fillOval(x+20, y+219, 32, 32);
		g.fillOval(x+55, y+219, 32, 32);
		//Top part of the arm (Orange)
		g.fillRect(x+20, y-25, 85, 50);
		g.fillOval(x+20, y-55, 85, 60);
		g.fillOval(x+20, y, 85, 60);
		//Creates the yellow segment of the upper arm
		g.setColor(Color.YELLOW);
		g.fillRect(x+20, y-15, 86, 40);
		//Creates orange circles on the upper arm
		for (int i=(x+22);i<(x+100);i+=30) {
			g.setColor(Color.ORANGE);
			g.fillOval(i, y-6, 20, 20);
		}			
	}
	
	/**
	 * This method creates the right left of a robot.
	 * @param Graphics, x coordinate, y coordinate
	 */
	private static void drawLeftArm(Graphics g, int x, int y) {
		g.setColor(Color.BLACK);
		g.fillRect(x-18, y, 20, 10); //attachment piece
		//Claw - Long Finger Part 1
		for (int i=(x-70);i<=(x-50);i++) {
			g.drawLine(i, y+250, i-20, y+275);
		}
		//Claw - Thumb
		for (int i=(x-45);i<=(x-25);i++) {
			g.drawLine(i, y+250, i+20, y+275);
		}
		//Claw - Long Finger Part 2
		for (int i=(x-90);i<=(x-70);i++) {
			g.drawLine(i, y+275, i+20, y+300);
		}	
		for (int i=(x-25);i>=(x-65);i--) {	//Top grey part
			if (i>=(x-35) ||i<=(x-55)) {
				g.setColor(Color.BLACK);
			}
			else {
				g.setColor(Color.GRAY);
			}
			g.drawLine(i, y+35, i-65, y+135);	
		}
		for (int i=(x-130);i<=(x-90);i++) {	 //Bottom grey part
			if (i<=(x-120) ||i>=(x-100)) {
				g.setColor(Color.BLACK);
			}
			else {
				g.setColor(Color.GRAY);
			}
			g.drawLine(i, y+135, i+65, y+225);
		}
		g.setColor(Color.ORANGE);
		//Bottom part of the arm (Orange)
		g.fillRect(x-70, y+220, 45, 31);
		g.fillOval(x-80, y+219, 32, 32);
		g.fillOval(x-50, y+219, 32, 32);
		//Top part of the arm (Orange)
		g.fillRect(x-103, y-25, 85, 50);
		g.fillOval(x-103, y-55, 85, 60);
		g.fillOval(x-103, y, 85, 60);
		//Creates the yellow segment of the upper arm
		g.setColor(Color.YELLOW);
		g.fillRect(x-104, y-15, 86, 40);
		//Creates orange circles on the upper arm
		for (int i=(x-101);i<(x-20);i+=30) {
			g.setColor(Color.ORANGE);
			g.fillOval(i, y-6, 20, 20);
		}
	}
	
	/**
	 * This method can draw either the left or right arm
	 * @param Graphics,direction (0 = left arm, 1 = right arm), x coordinate, y coordinate
	 */
	public void drawArm(Graphics g, int direction, int x, int y) {
		if (direction==0) {
			drawLeftArm(g,x,y);
		}
		else if (direction==1) {
			drawRightArm(g,x,y);
		}
		else {
			System.out.println("Enter a valid integer (0 or 1)");
		}
	}
}
