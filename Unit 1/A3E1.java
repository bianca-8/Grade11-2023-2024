package unit_1_OOP;

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
		A3E1_StopLight light1 = new A3E1_StopLight(0,0,g);
		A3E1_StopLight light2 = new A3E1_StopLight(500,0,g);
		A3E1_StopLight light3 = new A3E1_StopLight(250,0,g);
		
		this.setBackground(Color.WHITE);
		
		// green light
		light1.goGreen();
		// yellow light
		light2.goYellow();
		// red light
		light3.goRed();
	}

}
