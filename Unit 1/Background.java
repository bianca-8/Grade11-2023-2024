package unit_1_OOP;

/**
 * Program that draws a halloween haunted castle.
 * @author Bianca
 * @version Oct 27, 2023
 */

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Background {

	int R = 118;
	int G = 85;
	int B = 43;
	
	Color DARKBLUE = new Color(62, 62, 87);
	Color LIGHTBLUE = new Color(101, 101, 132);
	Color BLUE = new Color(77, 76, 102);
	Color ORANGE = new Color(238, 141, 74);
	Color DARK = new Color(39, 39, 38);
	Color DOOR = new Color(55, 55, 87);
	Color BROWN = new Color(69, 61, 39);
	Color DIRT = new Color(R,G,B);

	public void background(Graphics g, int x, int y, int l, int w, double factor) {
		Random r = new Random();

		l = (int) (l * factor);
		w = (int) (w * factor);
		int Y = y+50; // Y of dirt ground box
		
		g.setColor(DIRT);
		g.fillRect(0, y+50, 800, y+50); // dirt ground
		
		// dirt ground change color to black
		for (int j = 0; j <= y-200; j++) {
			g.setColor(new Color(R,G,B));
			g.drawLine(0, Y, 800, Y);

			R -= 2;
			G -= 2;
			B -= 2;
			Y -= 1;

			// invalid color
			if (R <= 0) {
				R = 0;
			}
			if (G <= 0) {
				G = 0;
			}
			if (B <= 0) {
				B = 0;
			}
		}

		// Castle
		path(g, x-50, y+50, l+200, w+75); //450, 300, 300, 200
		sideTower(g, x-100, y, l, w, r.nextInt(2)); // 400, 250, 100, 125
		sideTower(g, x+100, y, l, w, r.nextInt(2)); // 600, 250, 100, 125
		middleTower(g, x, y, l, w + 5, r.nextInt(2)); // 500, 250, 100, 130

	}

	/**
	 * Method that draws the middle tower
	 * @param g - Graphics
	 * @param x - top left corner x coordinate of tower
	 * @param y - top left corner y coordinate of tower
	 * @param l - length of tower
	 * @param w - width of tower
	 */
	public void middleTower(Graphics g, int x, int y, int l, int w, int color) {
		g.setColor(LIGHTBLUE);
		g.fillRect(x, y, l, w); // bottom tower 500, 250, 100, 130
		g.setColor(DARKBLUE);
		tri(g, x-15, y-75, l, w); // middle roof 485, 175, 100, 130
		g.setColor(LIGHTBLUE);
		g.fillRect(x, y-100, l, w-30); // top tower x, 150, 100, 100
		g.setColor(DARKBLUE);
		tri(g, x-25, y-200, l, w+20); // top roof 475, 50, 100, 150

		window(g, x+30, y-75, l-60, w-85, 3, color); // attic window

		// Door
		g.setColor(DOOR);
		g.fillRect(x+25, y+50, l-50, w-55); // Door 525, 300, 50, 75
		g.setColor(DARKBLUE);
		g.fillRect(x+25, y+125, l-50, w-120); // doorstep 525, 375, 50, 10

		g.setColor(new Color(121, 121, 173));
		g.drawLine(x+25, y+125, l+475, w+245); // bottom door line 525, 375, 575, 375
		g.drawLine(x+25, y+50, l+475, w+170); // top door line 525, 300, 575, 300
		g.fillOval(x+66, y+85, 7, 7); // doorknob 566, 335, 7, 7

		// Draw lines on door
		for (int i = 0; i <= 5; i++) { // Door lines
			g.drawLine(x+25+10*i, y+50, x+25+10*i, y+125); // Door 525+10*i, 300, 525+10*i, 375
		}
	}

	/**
	 * Method that draws a side tower.
	 * @param g - Graphics
	 * @param x - top left corner x coordinate of tower
	 * @param y - top left corner y coordinate of tower
	 * @param l - length of tower
	 * @param w - width of tower
	 * @param DB - dark blue color
	 * @param B - blue color
	 * @param D - dark color
	 * @param O - color orange
	 */
	public void sideTower(Graphics g, int x, int y, int l, int w, int color) {
		g.setColor(BLUE);
		g.fillRect(x+12, y-100, l-25, w-25); // top tower 412, 150, 75, 100
		g.setColor(DARKBLUE);
		tri(g, x, y-160, l-25, w-25); //400, 90, 75, 100
		g.setColor(BLUE);
		g.fillRect(x, y, l, w); // bottom tower 400, 250, 100, 125
		g.setColor(DARKBLUE);
		tri(g, x-20, y-60, l-25, w+15); //380, 190, 75, 140

		window(g, x+28, y+45, l-55, w-75, 3, color); //428, 295, 45, 50

	}

	/**
	 * Method that draws a path from the door of the castle
	 * @param g - Graphics
	 * @param x - top left corner x coordinate of path
	 * @param y - top left corner y coordinate of path
	 * @param l - length of path
	 * @param w - width of path
	 */
	public void path(Graphics g, int x, int y, int l, int w) {
		g.setColor(BROWN);
		tri(g, x, y, l, w);
	}

	/**
	 * Method that draws a triangle
	 * @param g - Graphics
	 * @param x - top left corner x coordinate of triangle
	 * @param y - top left corner y coordinate of triangle
	 * @param l - length of triangle
	 * @param w - width of triangle
	 */
	public void tri(Graphics g, int x, int y, int l, int w) {
		int[]X = {x, (x + w/2), x+w};
		int[]Y = {y+l, y, y+l};
		g.fillPolygon(X, Y, 3);
	}

	/**
	 * Method that draws a window
	 * @param g - Graphics
	 * @param x - top left corner x coordinate of window
	 * @param y - top left corner y coordinate of window
	 * @param l - length of window
	 * @param w - width of window
	 * @param b - border width
	 */
	public void window(Graphics g, int x, int y, int l, int w, int b, int color) {
		g.setColor(DARK);
		g.fillRect(x - b, y - b, l + b * 2, w + b * 2); // window outline
		// choice 1 - color orange
		if (color == 1) {
			g.setColor(ORANGE);
		}
		// choice 2 - color yellow
		else {
			g.setColor(new Color(255, 187, 0)); // Yellow
		}
		g.fillRect(x, y, l, w); // window
		g.setColor(DARK);
		g.drawLine(x, y + w/2, x + l, y + w/2);
		g.drawLine(x + l/2, y, x + l/2, y + w);
	}
}
