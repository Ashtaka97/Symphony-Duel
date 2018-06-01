package org.turkudragons.SymphonyDuel;

import org.newdawn.slick.geom.Shape;

public abstract class Spell {
	protected int power; //Is the power of an offensive spell, the amount of buff, the id of monster, the power of shield
	protected int count; //how many times spell is cast aka. amount of summons
	protected boolean collidable;
	protected boolean aoe;
	protected Shape area;
	protected Type type;
	protected Element element;
	protected float defx;
	protected float defy;
	protected float speed;
	protected String chant;
	
	public Spell(int power, int count, boolean collidable, boolean aoe, Shape area, Type type, Element element, float defx, float defy, float speed, String chant) {
		this.power = power;
		this.count = count;
		this.aoe = aoe;
		this.area = area;
		this.type = type;
		this.element = element;
		this.defx = defx;
		this.defy = defy;
		this.speed = speed;
		this.chant = chant;
		this.collidable = collidable;
		
	}
	
	public void cast() {
		
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public boolean isAoe() {
		return aoe;
	}

	public void setAoe(boolean aoe) {
		this.aoe = aoe;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Element getElement() {
		return element;
	}

	public void setElement(Element element) {
		this.element = element;
	}
}
