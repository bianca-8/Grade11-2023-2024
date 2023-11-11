package unit_1_OOP;

import java.awt.*;
import javax.swing.JFrame;

/**
 * Program that draws a traffic light.
 * @author Bianca
 * @version Oct 16, 2023
 */

@SuppressWarnings("serial")
public class A2E1 extends Canvas {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Traffic Light Drawing");
		Canvas canvas = new A2E1();
		canvas.setSize(800,500);
		frame.add(canvas);
		frame.pack();
		frame.setVisible(true);
	}
	
	public void paint(Graphics g) {
		this.setBackground(Color.WHITE);

		g.setColor(Color.YELLOW);
		g.fillRect(50, 0, 200, 500);
		
		g.setColor(Color.GRAY);
		g.fillOval(50 + 50, 50, 100, 100);
		g.fillOval(50 + 50, 200, 100, 100);
		g.fillOval(50 + 50, 350, 100, 100);
		
		// Green Light
		g.setColor(Color.GREEN);
		g.fillOval(50 + 50,  + 350, 100, 100);
		
		// Yellow Light
		g.setColor(Color.BLACK);
		g.drawOval(50 + 50,  + 200, 100, 100);
		g.setColor(Color.YELLOW);
		g.fillOval(50 + 50, 200, 100, 100);
		
		// Red Light
		g.setColor(Color.RED);
		g.fillOval(50 + 50,  + 50, 100, 100);
		
	}

}
