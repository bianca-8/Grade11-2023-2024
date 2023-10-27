package unit_1_introOOP;

import java.awt.*;
import javax.swing.JFrame;

import java.util.* ;

public class Scrum extends Canvas {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		Canvas canvas = new Scrum();
		canvas.setSize(800,600);
		frame.add(canvas);
		frame.pack(); 
		frame.setVisible(true);
		
		
	}
	
	public void paint(Graphics g) {
		this.setBackground(Color.WHITE);
		Random r = new Random();
		
		Stem stem = new Stem();
		stem.stem(230,40,200,200,0.4,new Color(130,50,0),7,Color.WHITE,g);

		Pumpkin pumpkin = new Pumpkin();
		pumpkin.pumpkin(g, 70, 270, 200, 300, 0.7); // body
		pumpkin.pumpkin(g, 85, 100, 200, 300, 0.6); // head
		
		Mouth mouth = new Mouth();
		mouth.mouth(g, 10, 10, 40, 10, 1.0);
		
		Eye eye1 = new Eye(120,150,80,80,8,0.6,new Color(255,165,0),new Color(50,50,50),g);
		Eye eye2 = new Eye(200,150,80,80,8,0.6,new Color(255,165,0),new Color(50,50,50),g);

		eye1.changeColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)),new Color(50,50,50));
		eye2.changeColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)),new Color(50,50,50));
	}
	
	

}
