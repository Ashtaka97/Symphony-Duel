package org.turkudragons.SymphonyDuel;

import java.util.ArrayList;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Shape;

public class Spell implements Active, Visible {
	protected int power; //Is the damage of an offensive spell, the amount of buff, the id of monster, the power of shield
	protected int count; //how many times spell is cast aka. amount of summons
	protected int x;
	protected int y;
	protected Spell spell;
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
	
	public Spell(int power, int count, boolean collidable, Type type, Target target, Element element, float speed, String chant, String name) {
		this.power = power;
		this.count = count;
		this.type = type;
		this.target = target;
		this.element = element;
		this.speed = speed;
		this.chant = chant;
		this.collidable = collidable;
		this.name = name;
	}
	
	public Spell(Spell s) {
		this.spell = s;
	}
	
	public void cast(Player caster, Player opponent, ArrayList<Object> oList, boolean crit) {
		
	}
	
	public void update(ArrayList<Object> oList, int delta) {
		ArrayList<Object> spellList = new ArrayList<Object>(oList);
		spellList.remove(this);
		for(int i = 2; i < spellList.size(); i++) {
			Spell s = (Spell)spellList.get(i);
			if(collidable && s.hitbox.intersects(hitbox) && s.collidable && !s.equals(this)) {
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
