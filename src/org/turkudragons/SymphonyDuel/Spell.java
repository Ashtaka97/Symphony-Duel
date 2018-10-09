package org.turkudragons.SymphonyDuel;

import java.util.ArrayList;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class Spell implements Active, Visible {
	protected int power; //Is the damage of an offensive spell, the amount of buff, the id of monster, the power of shield
	protected int count; //how many times spell is cast aka. amount of summons
	protected int x;
	protected int y;
	protected boolean collidable;
	protected Shape hitbox;
	protected Type type;
	protected Target target;
	protected Element element;
	protected float speed;
	protected String chant;
	protected String name;
	protected Player caster;
	protected Player opponent;
	protected boolean delete;
	
	public Spell(int power, int count, boolean collidable, Shape hitbox, Type type, Target target, Element element, float speed, String chant, String name) {
		this.power = power;
		this.count = count;
		this.type = type;
		this.target = target;
		this.element = element;
		this.speed = speed;
		this.chant = chant;
		this.collidable = collidable;
		this.hitbox = hitbox;
		this.name = name;
	}
	
	public Spell(Spell s) {
		this.power = s.power;
		this.count = s.count;
		this.type = s.type;
		this.target = s.target;
		this.element = s.element;
		this.speed = s.speed;
		this.chant = s.chant;
		this.collidable = s.collidable;
		this.hitbox = s.hitbox;
		this.name = s.name;
	}
	
	public void cast(Player caster, Player opponent, ArrayList<Object> oList, boolean crit) {
		if(crit) {
			power = power*2;
		}
		this.caster = caster;
		this.opponent = opponent;
		if(this.type == Type.ATTACK) {
			if(this.collidable) {
				if(this.target == Target.HOSTILE) {
					hitbox = new Rectangle(caster.x+4, caster.y+10, 8, 8);
				}
			}
		}
		else if(this.type == Type.BUFFDEBUFF) {
			if(this.target == Target.SELF) {
				if(this.element == Element.RADIANT) {
					caster.hp += power;
				}
			}
		}
		for(int i = 0; i < count; i++)
			oList.add(this);
	}
	
	public void update(ArrayList<Object> oList, int delta) {
		for(int i = 2; i < oList.size(); i++) {
			Spell s = (Spell)oList.get(i);
			if(collidable && s.hitbox.intersects(hitbox) && s.collidable && !(s.equals(this))) {
				this.delete = true;
				s.delete = true;
			}
		}
		if(hitbox.intersects(opponent.hitbox)) {
			opponent.hp -= power;
			delete = true;
		}
		if(caster.hitbox.getX() < opponent.hitbox.getX()) {
			hitbox.setX(hitbox.getX()+((speed*delta)/2));
		} else {
			hitbox.setX(hitbox.getX()-((speed*delta)/2));
		}
	}

	public void display(Graphics g) {
		g.draw(hitbox);
	}
	
	public boolean getDelete() {
		return delete;
	}

}
