package unit_2_Robots;

import java.awt.*;
import javax.swing.JFrame;


public abstract class A4E0_Character extends Canvas{
	public static void main(String[] args) {
		JFrame frame = new JFrame("Traffic Light Drawing");
		Canvas canvas = new A4E0_Character();
		canvas.setSize(150,150);
		frame.add(canvas);
		frame.pack();
		frame.setVisible(true);
	}
	
	
	public static final int WIDTH = 150;
	public static final int HEIGHT = 150;
	
	protected int x, y;
	protected Graphics g;
	
	public abstract void draw();
	
}
