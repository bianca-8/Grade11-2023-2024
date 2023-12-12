package unit_2_Robots;

import java.awt.*;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class A4E0_Drawer extends Canvas{

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		Canvas canvas = new A4E0_Drawer();
		canvas.setSize(150,150);
		frame.add(canvas);
		frame.pack();
		frame.setVisible(true);
	}
	
	public void paint(Graphics g) {
		A4E0_Minion drawing = new A4E0_Minion(0, 0, g);
		drawing.draw();
	}
	
}
