package unit_3_recur_sort;

import javax.swing.JFrame;
import java.awt.*;

/**
 * Program that draws Sierpinski's Triangle.
 * @author Bianca
 * @version Nov 29, 2023
 */

@SuppressWarnings("serial")
public class A1E8 extends Canvas {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		Canvas canvas = new A1E8();
		canvas.setSize(600,400);
		frame.add(canvas);
		frame.pack();
		frame.setVisible(true);

	}
	
	/**
	 * Function that makes a sierpinski's triangle.
	 * @param CenterX - x-coordinate of the middle of the triangle.
	 * @param CenterY - y-coordinate of the middle of the triangle.
	 * @param side - side length of the triangle
	 * @param g - Graphics.
	 */
	public static void drawTriangle(int CenterX, int CenterY, int side, Graphics g) {
		double height = side * Math.sqrt(3)/2; // height of triangle (side multiplied by cos30) 
		
		int topY = (int) (CenterY - height/2);
		int bottomY = (int) (CenterY + height/2);
		int leftX = (int) (CenterX - side/2);
		int rightX = (int) (CenterX + side/2);
		
		// size of the triangle is greater than 1 pixel
		if (side > 3) {
			int[] topCenter = {CenterX, topY + (int)(height/4)};
			int[] leftCenter = {leftX + (int)(side/4), bottomY - (int)(height/4)};
			int[] rightCenter = {rightX - side/4, bottomY - (int)(height/4)};
			
			drawTriangle(topCenter[0], topCenter[1], side/2, g); // middle triangle
			drawTriangle(leftCenter[0], leftCenter[1], side/2, g); // left triangle
			drawTriangle(rightCenter[0], rightCenter[1], side/2, g); // right triangle
		}
		// draw the triangle
		else {
			g.drawLine(leftX, bottomY, CenterX, topY); // left line
			g.drawLine(rightX, bottomY, CenterX, topY); // right line
			g.drawLine(leftX, bottomY, rightX, bottomY); // bottom line
		}
		
	}
	
	public void paint(Graphics g) {
		this.setBackground(Color.WHITE);
		g.setColor(Color.BLUE);
		drawTriangle(250, 200, 400, g);
	}

}
