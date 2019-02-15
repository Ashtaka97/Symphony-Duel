package org.turkudragons.SymphonyDuel;

import java.io.Serializable;
import java.util.ArrayList;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class WallOfIce_Spell implements Spell, Active, Visible, Cloneable, Serializable {

	private static final long serialVersionUID = 3L;
	private int power = 80; //Is the damage of an offensive spell, the amount of buff, the id of monster, the power of shield
	private int count = 1; //how many times spell is cast aka. amount of summons
	private boolean collidable = true;
	private Shape hitbox;
	private Type type = Type.DEFENSE;
	private Target target = Target.HOSTILE;
	private Element element = Element.COLD;
	private float speed = 0;
	private String chant = "AAA";
	private String name = "Wall Of Ice";
	private Player caster;
	private Player opponent;
	private boolean delete;
	
	public WallOfIce_Spell(){}
	
	@Override
	public void cast(Player caster, Player opponent, ArrayList<Object> oList, boolean crit) {
		try {
			WallOfIce_Spell woi = ((WallOfIce_Spell)this.clone());
			if(crit) woi.power += power;
			woi.caster = caster;
			woi.opponent = opponent;
			woi.hitbox = new Rectangle(0, 0, 8, 40);
			woi.hitbox.setCenterY(caster.getHitbox().getCenterY());
			if(caster.hitbox.getX() < opponent.hitbox.getX()) {
				woi.hitbox.setCenterX(caster.getHitbox().getCenterX()+24);
			} else {
				woi.hitbox.setCenterX(caster.getHitbox().getCenterX()-24);
			}
			oList.add(woi);
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
