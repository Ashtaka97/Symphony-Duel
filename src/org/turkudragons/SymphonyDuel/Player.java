package org.turkudragons.SymphonyDuel;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class Player {

	int hp;
	int x;
	int y;
	Shape hitbox;
	double castSpeed;
	
	public Player(int x, int y) {
		hp = 100;
		this.x = x;
		this.y = y;
		hitbox = new Rectangle(x, y, 16, 32);
		castSpeed = 1.0;
	}
	
	public void draw(Graphics g) {
		g.draw(hitbox);
	}
	
	public void update() {
		
	}

}
