package unit_1_OOP;
import java.awt.Color;
import java.awt.Graphics;

/**
 * draw the mouth of the robot
 * @author Tianyan He
 * @version Oct 29, 2023
 */
public class Mouth {
	private int x, y, w, h;
	private Graphics g;

	/**
	 * constructor : get values needed for drawing
	 * @param x : the x coordinate of upper left corner of the mouth
	 * @param y : the y coordinate of upper left corner of the mouth
	 * @param w : width of the mouth
	 * @param h	: height of the mouth
	 * @param g : graphics
	 */
	public Mouth(int x, int y, int w, int h, Graphics g) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.g =g;
		drawMouth();
	}

	/**
	 * draw the mouth of pumpkin
	 */
	private void drawMouth() {
		this.g.setColor(Color.BLACK);
		int[] xL = {this.x, this.x+this.w/8, this.x+this.w/4, this.x+this.w/2, this.x+this.w/4*3, this.x+this.w/8*7, this.x+this.w, this.x+this.w/8*7, this.x+this.w/4*3, this.x+this.w/2, this.x+this.w/4, this.x+this.w/8, this.x};
		int[] yL = {this.y, this.y+this.h/2, this.y, this.y+this.h/2, this.y, this.y+this.h/2, this.y, this.y+this.h, this.y+this.h/2, this.y+this.h/2*3, this.y+this.h/2, this.y+this.h, this.y};
		g.fillPolygon(xL,yL,xL.length);
	}

}
