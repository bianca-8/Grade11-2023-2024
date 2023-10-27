package unit_1_introOOP;

import java.awt.*;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class A3E1 extends Canvas {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Traffic Light Drawing");
		Canvas canvas = new A3E1();
		canvas.setSize(800,500);
		frame.add(canvas);
		frame.pack();
		frame.setVisible(true);
		
	}
	
	/**
	 * Draws red, yellow and green traffic lights.
	 */
	public void paint(Graphics g) {
		A3E1_StopLight draw = new A3E1_StopLight();
		
		this.setBackground(Color.WHITE);
		
		draw.stopLight(0,0,g);
		draw.goGreen();
		
		draw.stopLight(500,0,g);
		draw.goYellow();
		
		draw.stopLight(250,0,g);
		draw.goRed();
	}

}
