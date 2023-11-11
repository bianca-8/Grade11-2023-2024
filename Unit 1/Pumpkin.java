package unit_1_OOP;

/**
 * Program that draws a pumpkin.
 * @author Bianca
 * @version Oct 25, 2023
 */

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Pumpkin {
	/**
	 * Method that draws a pumpkin
	 * @param g - graphics
	 * @param x - x coordinate of top left corner of pumpkin
	 * @param y - y coordinate of top left corner of pumpkin
	 * @param l - length of the pumpkin
	 * @param w - width of the pumpkin
	 * @param scale - scale to shrink or make the pumpkin bigger
	 * @return 
	 */
	public void pumpkin(Graphics g, int x, int y, int len, int wid, double scale) {
		// Variables
		int w = (int) (wid * scale);
		int l = (int) (len * scale);
		
		int X = x;
		int X1 = x;
		int X2 = x;
		int G = 110;
		int G1 = 240;
		int B = 210;
		
		// Random
		Random r = new Random();
		int R = r.nextInt(60)+190;
		
		// Colors
		Color ORANGE = new Color(R, 134, 70); // 190-255 - originally 242
		
		// Pumpkin orange body
		g.setColor(ORANGE);
		g.fillOval(x, y, l, w); // left circle
		g.fillOval(x+2*(l/3), y, l, w); // right circle
		g.fillOval(x+l/3, y, l, w); // middle circle
		
		// Cover top
		g.fillArc(x-20,y,l+(l/2),w,95,-50);
		g.fillArc(x+50,y,l+(l/2),w,90,50);
		
		// Shading - dark to light orange
		for (int i = 0; i < 40; i++) {
			// Shading for middle lines
			g.setColor(new Color(R, G, 70));
			g.drawArc((int)(X+30*scale),(int)(y-50*scale),l,(int)(w+100*scale),48,-96);
			g.drawArc((int)(X1+105*scale),(int)(y-50*scale),l,(int)(w+100*scale),132,96);
			
			// Shading for side lines
			g.setColor(new Color(R, G, 70));
			g.drawArc(X,y,l,w,90,200);
			g.drawArc(X1+2*(l/3),y,l,w,250,200);
			
			G += 1;
			// Color is same color as rest of pumpkin/255/0
			if (G >= 255 || G <= 0 || G == 134) {
				break;
			}
			
			X += 1;
			X1 -= 1;
		}
		
		// Highlight - shading for light 
		for (int j = 0; j < 10; j++) {
			g.setColor(new Color(255, G1, B));
			g.drawArc((int)(X2+(100*scale)),y,l,w,65,-50);
			X2 += 1;
			G1 -= 10;
			B -= 10;
			// Color is same color as rest of pumpkin/255/0
			if (G1 >= 255 || G1 <= 0 || G1 == 134) {
				break;
			}
		}
		
		
	}
}
