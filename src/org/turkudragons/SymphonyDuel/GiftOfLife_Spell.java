package org.turkudragons.SymphonyDuel;

import java.util.ArrayList;
import org.newdawn.slick.geom.Shape;

public class GiftOfLife_Spell implements Spell{
	
	private int power = 50; //Is the damage of an offensive spell, the amount of buff, the id of monster, the power of shield
	private int count = 0; //how many times spell is cast aka. amount of summons
	private boolean collidable = false;
	private Shape hitbox = null;
	private Type type = Type.BUFFDEBUFF;
	private Target target = Target.SELF;
	private Element element = Element.RADIANT;
	private String chant = "WWW";
	private String name = "Gift Of Life";
	private boolean delete;
	
	public GiftOfLife_Spell(){}
	
	@Override
	public void cast(Player caster, Player opponent, ArrayList<Object> oList, boolean crit) {
		caster.hp += power;
		if(crit) caster.hp += power;
	}

	@Override
	public boolean getDelete() {
		return this.delete;
	}

	@Override
	public void setDelete(boolean delete) {
		this.delete = delete;
	}

	@Override
	public Shape getHitbox() {
		return hitbox;
	}

	@Override
	public void setHitbox(Shape hitbox) {
		this.hitbox = hitbox;
	}

	@Override
	public boolean getCollidable() {
		return collidable;
	}

	@Override
	public void setCollidable(boolean collidable) {
		this.collidable = collidable;
	}

	@Override
	public int getCount() {
		return count;
	}

	@Override
	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public Type getType() {
		return type;
	}

	@Override
	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public Target getTarget() {
		return target;
	}

	@Override
	public void setTarget(Target target) {
		this.target = target;
	}

	@Override
	public Element getElement() {
		return element;
	}

	@Override
	public void setElement(Element element) {
		this.element = element;
	}

	@Override
	public String getChant() {
		return chant;
	}

	@Override
	public void setChant(String chant) {
		this.chant = chant;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
}
