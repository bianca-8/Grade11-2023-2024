package unit_1_OOP;
import java.awt.Color;
import java.awt.Graphics;

/**
 * draw the eye of the robot
 * @author Tianyan He
 * @version Oct 25, 2023
 */
public class Eye {
	//init global var
	private int x, y, w, h, l;
	private Graphics g;
	private Color eyeC, frameC;
	
	/**
	 * constructor : create obj and assign values to global var
	 * @param x : the x coordinate of left up corner of the eye
	 * @param y : the y coordinate of left up corner of the eye
	 * @param w : the width of eye
	 * @param h : the height of eye
	 * @param l : the length of eye
	 * @param eyeC : color of the center eye
	 * @param frameC : color of the frame
	 * @param g : graphics
	 */
	public Eye(int x, int y, int w, int h, int l, double scale, Color eyeC, Color frameC, Graphics g) {
		//assign value
		this.x = x;
		this.y = y;
		this.w = (int)(w*scale);
		this.h = (int)(h*scale);
		this.l = (int)(l*scale);
		this.g = g;
		this.changeColor(eyeC, frameC);
		
	}
	
	/**
	 * get the original color of the eye and frame and run drawing
	 * @param eyeC : color of the eye
	 * @param frameC : color of the frame
	 */
	public void changeColor(Color eyeC, Color frameC) {
		this.eyeC = eyeC;
		this.frameC = frameC;


		//run the drawing
		this.drawEye();
	}
	
	/**
	 * draw the eye and frame
	 */
	private void drawEye() {
		//the side of eye with BLACK
		for(int i = 0; i < this.l; i++) {
			g.setColor(new Color(crctCValue(this.frameC.getRed()-i),crctCValue(this.frameC.getGreen()-i),crctCValue(this.frameC.getBlue()-i)));
			this.g.fillOval(this.x+i, this.y, this.w-this.l/2, this.h);
		}
		
		//the frame of eye with black color
		g.setColor(this.frameC);
		this.g.fillOval(this.x+this.l, this.y, this.w-this.l/2, this.h);
		
		//reflection
		g.setColor(Color.WHITE);
		this.g.drawArc(this.x+this.l*9/8, this.y, this.w-this.l/2, this.h, 30,50);
		this.g.drawArc(this.x+this.l*9/8, this.y, this.w-this.l/2, this.h, 210,50);
		
		//draw the center of the eye
		drawCenterEye();
		
	/**
	 * drawing the center eye
	 */
	}
	private void drawCenterEye() {
		//draw the eye
		g.setColor(this.eyeC);
		this.g.fillOval(this.x+this.l+this.w/9, this.y+this.h/9, this.w-this.l/2 - this.w/9*2, this.h-this.h/9*2);
		
		//shadow
		//get the correct color of the shadow
		g.setColor(new Color(crctCValue(this.eyeC.getRed()-50),crctCValue(this.eyeC.getGreen()-50),crctCValue(this.eyeC.getBlue()-50)));
		this.g.fillArc(this.x+this.l+this.w/9, this.y+this.h/9, this.w-this.l/2 - this.w/9*2, this.h-this.h/9*2,-90,180);
		
		//cover the redundant part of shadow with eye color
		g.setColor(this.eyeC);
		this.g.fillOval(this.x+this.l+this.w/9, this.y+this.h/9, this.w-this.l/2 - this.w/9*3, this.h-this.h/9*2);

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
