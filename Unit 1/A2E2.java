package unit_1_OOP;

import java.awt.*;
import javax.swing.JFrame;

/**
 * Program that draws a traffic light.
 * @author Bianca
 * @version Oct 16, 2023
 */

@SuppressWarnings("serial")
public class A2E2 extends Canvas{

	public static void main(String[] args) {
		JFrame frame = new JFrame("Traffic Light Drawing");
		Canvas canvas = new A2E2();
		canvas.setSize(800,500);
		frame.add(canvas);
		frame.pack();
		frame.setVisible(true);
		
	}
	
	/**
	 * Method that draws a traffic light at coordinates (x,y).
	 * @param x - top left corner x-coordinate of the traffic light.
	 * @param y - top left corner y-coordinate of the traffic light.
	 * @param g - The graphics object used for drawing.
	 */
	public void drawLight(int x, int y, Graphics g) {
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
	public void goGreen(int x, int y, Graphics g) {
		g.setColor(Color.GREEN);
		g.fillOval(x + 50, y + 350, 100, 100);
	}
	
	/**
	 * Method that draws a yellow light.
	 * @param x - top left corner x-coordinate of the traffic light.
	 * @param y - top left corner y-coordinate of the traffic light.
	 * @param g - The graphics object used for drawing.
	 */
	public void goYellow(int x, int y, Graphics g) {
		g.setColor(Color.BLACK);
		g.drawOval(x + 50, y + 200, 100, 100);
		g.setColor(Color.YELLOW);
		g.fillOval(x + 50, y + 200, 100, 100);
	}
	
	/**
	 * Method that draws a red light.
	 * @param x - top left corner x-coordinate of the traffic light.
	 * @param y - top left corner y-coordinate of the traffic light.
	 * @param g - The graphics object used for drawing.
	 */
	public void goRed(int x, int y, Graphics g) {
		g.setColor(Color.RED);
		g.fillOval(x + 50, y + 50, 100, 100);
	}
	
	/**
	 * Draws red, yellow and green traffic lights.
	 */
	public void paint(Graphics g) {
		// Variables
		int x = 50;
		int y = 0;
		
		this.setBackground(Color.WHITE);
		drawLight(x,y,g);
		goGreen(x,y,g);
		
		drawLight(x+250,y,g);
		goYellow(x+250,y,g);
		
		drawLight(x+500,y,g);
		goRed(x+500,y,g);
	}

}
