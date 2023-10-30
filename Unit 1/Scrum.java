package unit_1_introOOP;

/**
 * Program that draws a pumpkin robot.
 * @author Bianca
 * @version Oct 25, 2023
 */

import java.awt.*;
import javax.swing.JFrame;
import java.util.*;

@SuppressWarnings("serial")
public class Scrum extends Canvas {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		Canvas canvas = new Scrum();
		canvas.setSize(800,600);
		frame.add(canvas);
		frame.pack(); 
		frame.setVisible(true);
	}
	
	/**
	 * Draw the pumpkin robot.
	 */
	public void paint(Graphics g) {
		this.setBackground(Color.BLACK);
		Random r = new Random();
		
		Stem stem = new Stem();
		stem.stem(230,40,200,200,0.4,new Color(130,50,0),7,Color.BLACK,g);

		Pumpkin pumpkin = new Pumpkin();
		pumpkin.pumpkin(g, 70, 270, 200, 300, 0.7); // body
		pumpkin.pumpkin(g, 85, 100, 200, 300, 0.6); // head
		
		@SuppressWarnings("unused")
		Mouth mouth = new Mouth(125,220,125,25,g);
		
		Background bg = new Background();
		bg.background(g, 500,250,100,125,1.0);
		
		Eye eye1 = new Eye(120,150,80,80,8,0.6,new Color(255,165,0),new Color(50,50,50),g);
		Eye eye2 = new Eye(200,150,80,80,8,0.6,new Color(255,165,0),new Color(50,50,50),g);

		eye1.changeColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)),new Color(50,50,50));
		eye2.changeColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)),new Color(50,50,50));
	}
	
	//public void paint(Graphics g) {	
		// EYES MOVE
		/*int x = 8;
		for (int i = 0; i <= 20; i++) {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			Stem stem = new Stem();
			stem.stem(230,40,200,200,0.4,new Color(130,50,0),7,new Color(238,238,238),g);

			Pumpkin pumpkin = new Pumpkin();
			pumpkin.pumpkin(g, 70, 270, 200, 300, 0.7); // body
			pumpkin.pumpkin(g, 85, 100, 200, 300, 0.6); // head
			
			Mouth mouth = new Mouth();
			mouth.mouth(g, 10, 10, 40, 10, 1.0);
			
			Eye eye5 = new Eye(120,150,80,80,x,0.6,new Color(255,165,0),new Color(50,50,50),g);
			Eye eye6 = new Eye(200,150,80,80,x,0.6,new Color(255,165,0),new Color(50,50,50),g);
			
			if (i < 10) {
				x += 2;
			}
			if (i >= 10) {
				x -= 2;
			}
			
		}*/
	//}
	

}
