package unit_1_OOP;

import java.awt.Color;
import java.awt.Graphics;

/**
 * draw the stem of the pumpkin
 * @author Tianyan He
 * @version Oct 25, 2023
 */
public class Stem {
	//private var
	public int x ,y, w,h,gdtValue, rOg, gOg, bOg;
	private Graphics g;
	private Color objColor, bgColor;

	/**
	 * constructor : create obj and assign values to global var
	 * @param x : the x coordinate of left up corner of stem
	 * @param y : the y coordinate of left up corner of stem
	 * @param w : the width of stem
	 * @param h : the height of stem
	 * @param objValue : color of the object
	 * @param gdtValue : gradient value
	 * @param bgColor : color of the background
	 * @param g : graphics
	 */
	public void stem(int x, int y, int w,int h, double factor, Color objColor, int gdtValue, Color bgColor, Graphics g) {
		//assign value
		this.x = x-(int)((w/10*6));
		this.y = y+(int)((h/200));
		this.w = (int)(w*factor);
		this.h = (int)(h*factor);
		this.gdtValue = gdtValue;
		this.bgColor = bgColor;
		this.g = g;
		this.changeColor(objColor);

	}
	
	/**
	 * get the original color of the obj and run drawing
	 * @param objColor : color of the obj
	 */
	public void changeColor(Color objColor) {
		this.objColor = objColor;

		//run the drawing
		this.drawStem();
	}
	
	/**
	 * drawing the stem
	 */
	private void drawStem() {
		
		//var initiation
		final int gradient = this.gdtValue * 100/this.w;

		//draw the round rect with color gradient
		for(int i = 0 ;i < w/10; i++) {

			//get the color after change gradient
			g.setColor(new Color(crctCValue((int)this.objColor.getRed()-i*gradient),crctCValue((int)this.objColor.getGreen()-i*gradient),crctCValue((int)this.objColor.getBlue()-i*gradient)));

			g.fillRoundRect(this.x-i, this.y+i, this.w, this.h, this.w/2, this.h/2);
		}

		//cover the useless part with bg color
		g.setColor(this.bgColor);
		g.fillRoundRect(this.x-this.w/3, this.y, this.w+this.w/5, this.h+this.h/2, this.w/2, this.h/2);
	}
	
	
	
	/**
	 * make sure the value is a color value which can't be smaller than 0 or bigger than 255
	 * @param value :  the value to test
	 * @return return the correct value
	 */
	private int crctCValue(int value) {
		//judge if the value is bigger than 255 or smaller than 0 and change it.
		if (value > 255) {
			value = 255;
		}else if (value < 0){
			value = 0;
		}
		
		return value;
	}
	

}
