package unit_3_recur_sort;

import javax.swing.JFrame;
import java.awt.*;

/**
 * Program that draws Cantor's Set.
 * @author Bianca
 * @version Nov 29, 2023
 */

@SuppressWarnings("serial")
public class A1E7 extends Canvas {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		Canvas canvas = new A1E7();
		canvas.setSize(650,400);
		frame.add(canvas);
		frame.pack();
		frame.setVisible(true);

	}
	
	/**
	 * Function that draws the 
	 * @param x - x coordinate of the left leg.
	 * @param y - y coordinate of the line.
	 * @param size - size of Cantor's set.
	 * @param g - Graphics.
	 */
	public static void cantor(int x, int y, int size, Graphics g) {
		// draw top part
		g.fillRect(x, y, size, 20);
		
		
		// draw 2 legs
		if (size > 5) {
			cantor(x, y + 50, size/3, g);
			cantor(x + 2*(size/3), y + 50, size/3, g);
		}

	}
	
	public void paint(Graphics g) {
		this.setBackground(Color.YELLOW);
		g.setColor(Color.BLUE);
		cantor(10, 10, 600, g);
	}

}
