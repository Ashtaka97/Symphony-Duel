package org.turkudragons.SymphonyDuel;

import java.util.ArrayList;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class Player implements Visible, Active{

	protected int hp;
	protected int x;
	protected int y;
	protected Shape hitbox;
	protected int castSpeed;
	protected int chantReaction;
	protected int maxHp;
	
	public Player(int x, int y) {
		hp = 100;
		maxHp = 100;
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
		if(hp > maxHp) {
			hp = maxHp;
		}
	}

}
