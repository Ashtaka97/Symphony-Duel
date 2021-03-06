package org.turkudragons.SymphonyDuel;

import java.io.Serializable;
import java.util.ArrayList;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class Fireball_Spell implements Spell, Active, Visible, Cloneable, Serializable {

	private static final long serialVersionUID = 1L;
	private int power = 20; //Is the damage of an offensive spell, the amount of buff, the id of monster, the power of shield
	private int count = 1; //how many times spell is cast aka. amount of summons
	private boolean collidable = true;
	private Shape hitbox;
	private Type type = Type.ATTACK;
	private Target target = Target.HOSTILE;
	private Element element = Element.HEAT;
	private float speed = 1;
	private String chant = "DDD";
	private String name = "Fireball";
	private Player caster;
	private Player opponent;
	private boolean delete;
	
	public Fireball_Spell() {}

	@Override
	public void cast(Player caster, Player opponent, ArrayList<Object> oList, boolean crit) {
		try {
			Fireball_Spell f = ((Fireball_Spell)this.clone());
			if(crit) f.power += power;
			f.caster = caster;
			f.opponent = opponent;
			f.hitbox = new Rectangle(0, 0, 9, 9);
			f.hitbox.setCenterX(caster.getHitbox().getCenterX());
			f.hitbox.setCenterY(caster.getHitbox().getCenterY());
			oList.add(f);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void update(ArrayList<Object> oList, int delta) {
		if(!delete) {
			for(int i = 2; i < oList.size(); i++) {
				Spell s = (Spell)oList.get(i);
				if(collidable && s.getHitbox().intersects(hitbox) && s.getCollidable() && !(s.equals(this))) {
					Spell.handleCollision(this, s);
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
	}
	
	@Override
	public void display(Graphics g) {
		g.draw(hitbox);
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

	@Override
	public int getPower() {
		return power;
	}

	@Override
	public void setPower(int power) {
		this.power = power;
	}
	
}
