package unit_2_Robots;

import java.awt.*;
import javax.swing.JFrame;

public class Drawer extends Canvas{

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		Canvas canvas = new Drawer();
		canvas.setSize(150,150);
		frame.add(canvas);
		frame.pack();
		frame.setVisible(true);
	}
	
	public void paint(Graphics g) {
		Minion drawing = new Minion(0, 0, g);
		drawing.draw();
	}
	
}
