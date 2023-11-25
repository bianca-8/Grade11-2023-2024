package unit_2_Robots;

import java.awt.*;

public class A4E0_Minion extends A4E0_Character{
	
	public A4E0_Minion(int x, int y, Graphics g) {
		this.x = x;
		this.y = y;
		this.g = g;
	}
	
	public void draw() {
		g.setColor(Color.BLUE);
		g.fillRect((int)(this.x+A4E0_Character.WIDTH*0.1), (int)(this.y+A4E0_Character.HEIGHT*0.7), A4E0_Character.WIDTH/6, A4E0_Character.HEIGHT/4); // left leg
		g.fillRect((int)(this.x+A4E0_Character.WIDTH*0.4), (int)(this.y+A4E0_Character.HEIGHT*0.7), A4E0_Character.WIDTH/6, A4E0_Character.HEIGHT/4); // right leg
		g.setColor(Color.BLACK);
		g.drawRect((int)(this.x+A4E0_Character.WIDTH*0.1), (int)(this.y+A4E0_Character.HEIGHT*0.7), A4E0_Character.WIDTH/6, A4E0_Character.HEIGHT/4); // left leg
		g.drawRect((int)(this.x+A4E0_Character.WIDTH*0.4), (int)(this.y+A4E0_Character.HEIGHT*0.7), A4E0_Character.WIDTH/6, A4E0_Character.HEIGHT/4); // right leg
		
		// arm
		g.setColor(Color.YELLOW);
		g.fillRect((int)(this.x), (int)(this.y+A4E0_Character.WIDTH*0.4), (int)(A4E0_Character.WIDTH*0.1), (int)(A4E0_Character.HEIGHT*0.4)); // left arm
		g.fillRect((int)(this.x+A4E0_Character.WIDTH*0.6), (int)(this.y+A4E0_Character.WIDTH*0.4), (int)(A4E0_Character.WIDTH*0.1), (int)(A4E0_Character.HEIGHT*0.4)); // right arm
		// arm outline
		g.setColor(Color.BLACK);
		g.drawRect((int)(this.x), (int)(this.y+A4E0_Character.WIDTH*0.4), (int)(A4E0_Character.WIDTH*0.1), (int)(A4E0_Character.HEIGHT*0.4)); // left arm
		g.drawRect((int)(this.x+A4E0_Character.WIDTH*0.6), (int)(this.y+A4E0_Character.WIDTH*0.4), (int)(A4E0_Character.WIDTH*0.1), (int)(A4E0_Character.HEIGHT*0.4)); // right arm
		// body
		g.setColor(Color.YELLOW);
		g.fillOval(this.x, this.y, (int)(A4E0_Character.WIDTH/1.5), (int)(A4E0_Character.HEIGHT*0.8));
		g.setColor(Color.BLACK);
		g.drawOval(this.x, this.y, (int)(A4E0_Character.WIDTH/1.5), (int)(A4E0_Character.HEIGHT*0.8));
		g.setColor(Color.RED);
		g.drawArc((int)(this.x+A4E0_Character.WIDTH*0.05), (int)(this.y+A4E0_Character.HEIGHT*0.2), (int)(A4E0_Character.WIDTH*0.6), A4E0_Character.HEIGHT/15, 180, 5);
		
		// glasses
		g.setColor(Color.BLACK);
		g.fillRect((int)(this.x+A4E0_Character.WIDTH*0.05), (int)(this.y+A4E0_Character.HEIGHT*0.2), (int)(A4E0_Character.WIDTH*0.6), A4E0_Character.HEIGHT/15); // strap
		g.setColor(new Color(105,105,105));
		g.fillOval((int)(this.x+A4E0_Character.WIDTH*0.1), (int)(this.y+A4E0_Character.HEIGHT*0.15), A4E0_Character.WIDTH/5, A4E0_Character.HEIGHT/5); // left goggle
		g.fillOval((int)(this.x+A4E0_Character.WIDTH*0.4), (int)(this.y+A4E0_Character.HEIGHT*0.15), A4E0_Character.WIDTH/5, A4E0_Character.HEIGHT/5); // right goggle
		g.setColor(Color.WHITE);
		g.fillOval((int)(this.x+A4E0_Character.WIDTH*0.135), (int)(this.y+A4E0_Character.HEIGHT*0.17), A4E0_Character.WIDTH/7, A4E0_Character.HEIGHT/7); // left eye
		g.fillOval((int)(this.x+A4E0_Character.WIDTH*0.435), (int)(this.y+A4E0_Character.HEIGHT*0.17), A4E0_Character.WIDTH/7, A4E0_Character.HEIGHT/7); // right eye
		g.setColor(Color.BLACK);
		g.fillOval((int)(this.x+A4E0_Character.WIDTH*0.135), (int)(this.y+A4E0_Character.HEIGHT*0.17), A4E0_Character.WIDTH/10, A4E0_Character.HEIGHT/10); // left pupil
		g.fillOval((int)(this.x+A4E0_Character.WIDTH*0.435), (int)(this.y+A4E0_Character.HEIGHT*0.17), A4E0_Character.WIDTH/10, A4E0_Character.HEIGHT/10); // right pupil
		
		// clothes
		g.setColor(Color.BLUE);
		g.fillRect((int)(this.x+A4E0_Character.WIDTH*0.2), (int)(this.y+A4E0_Character.HEIGHT*0.55), (int)(A4E0_Character.WIDTH*0.3), A4E0_Character.HEIGHT/5);
		g.fillRect((int)(this.x), (int)(this.y+A4E0_Character.HEIGHT*0.45), (int)(A4E0_Character.WIDTH*0.3),(int)(A4E0_Character.HEIGHT*0.1));
		g.fillRect((int)(this.x+A4E0_Character.WIDTH*0.3), (int)(this.y+A4E0_Character.HEIGHT*0.45), (int)(A4E0_Character.WIDTH*0.35), (int)(A4E0_Character.HEIGHT*0.1));

	}
	
	

}
