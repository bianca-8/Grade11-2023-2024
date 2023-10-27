package unit_1_introOOP;

import java.awt.*;

/**
 * Class that draws stop lights.
 * @author Bianca
 * @version Oct 17, 2023
 */
public class A3E1_StopLight {
	int x;
	int y;
	Graphics g;
	
	/**
	 * Method that takes in values of x and y and draws the traffic light.
	 * @param x - top left corner x-coordinate of the traffic light.
	 * @param y - top left corner y-coordinate of the traffic light.
	 * @param g - The graphics object used for drawing.
	 */
	public void stopLight(int x, int y, Graphics g) {
		this.x = x;
		this.y = y;
		this.g = g;
		drawLight();
	}
	
	/**
	 * Method that draws a traffic light at coordinates (x,y).
	 * @param x - top left corner x-coordinate of the traffic light.
	 * @param y - top left corner y-coordinate of the traffic light.
	 * @param g - The graphics object used for drawing.
	 */
	private void drawLight() {
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, 200, 500);
		
		g.setColor(Color.GRAY);
		g.fillOval(x + 50, y + 50, 100, 100);
		g.fillOval(x + 50, y + 200, 100, 100);
		g.fillOval(x + 50, y + 350, 100, 100);	
	}
	
	/**
	 * Method that draws a green light.
	 * @param x - top left corner x-coordinate of the traffic light.
	 * @param y - top left corner y-coordinate of the traffic light.
	 * @param g - The graphics object used for drawing.
	 */
	public void goGreen() {
		g.setColor(Color.GREEN);
		g.fillOval(this.x + 50, this.y + 350, 100, 100);
	}
	
	/**
	 * Method that draws a yellow light.
	 * @param x - top left corner x-coordinate of the traffic light.
	 * @param y - top left corner y-coordinate of the traffic light.
	 * @param g - The graphics object used for drawing.
	 */
	public void goYellow() {
		g.setColor(Color.BLACK);
		g.drawOval(this.x + 50, this.y + 200, 100, 100);
		g.setColor(Color.YELLOW);
		g.fillOval(this.x + 50, this.y + 200, 100, 100);
	}
	
	/**
	 * Method that draws a red light.
	 * @param x - top left corner x-coordinate of the traffic light.
	 * @param y - top left corner y-coordinate of the traffic light.
	 * @param g - The graphics object used for drawing.
	 */
	public void goRed() {
		g.setColor(Color.RED);
		g.fillOval(this.x + 50, this.y + 50, 100, 100);
	}
	
}
