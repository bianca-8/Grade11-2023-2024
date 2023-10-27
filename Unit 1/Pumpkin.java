package unit_1_introOOP;

import java.awt.Color;
import java.awt.Graphics;

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
		
		int lineX = x;
		int lineX1 = x;
		int G = 110;
		
		// Colors
		Color ORANGE = new Color(242, 134, 70);
		
		// Pumpkin orange body
		g.setColor(ORANGE);
		g.fillOval(x, y, l, w);
		g.fillOval(x+l/3, y, l, w);
		g.fillOval(x+2*(l/3), y, l, w);
		
		// Cover top
		//g.setColor(Color.BLACK);
		g.fillArc(x-20,y,l+(l/2),w,95,-50);
		g.fillArc(x+50,y,l+(l/2),w,90,50);
		
		for (int i = 0; i < 40; i++) {
			// Shading for middle lines
			g.setColor(new Color(242, G, 70));
			g.drawArc((int)(lineX+30*scale),(int)(y-50*scale),l,(int)(w+100*scale),45,-90);
			g.drawArc((int)(lineX1+105*scale),(int)(y-50*scale),l,(int)(w+100*scale),135,90);
			
			// Shading for side lines
			g.setColor(new Color(242, G, 70));
			g.drawArc(lineX,y,l,w,90,200);
			g.drawArc(lineX1+2*(l/3),y,l,w,250,200);
			
			
			G += 1;
			if (G > 255 || G < 0 || G == 134) {
				break;
			}
			
			lineX += 1;
			lineX1 -= 1;
		}
		
	}
}
