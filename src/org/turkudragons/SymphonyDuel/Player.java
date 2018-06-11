package org.turkudragons.SymphonyDuel;

import java.util.ArrayList;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class Player implements Visible, Active{

	int hp;
	int x;
	int y;
	Shape hitbox;
	int castSpeed;
	int chantReaction;
	
	public Player(int x, int y) {
		hp = 100;
		this.x = x;
		this.y = y;
		hitbox = new Rectangle(x, y, 16, 32);
		castSpeed = 1;
		chantReaction = 3;
	}
	
	public void display(Graphics g) {
		g.draw(hitbox);
	}

	public void update(ArrayList<Object> o, int delta) {
		
	}

}
