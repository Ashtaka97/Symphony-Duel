package org.turkudragons.SymphonyDuel;

import java.util.ArrayList;

import org.newdawn.slick.geom.Shape;

public interface Spell {
	
	public void cast(Player caster, Player opponent, ArrayList<Object> oList, boolean crit);
	
	public boolean getDelete();

	public void setDelete(boolean delete);
	
	public Shape getHitbox();
	
	public void setHitbox(Shape hitbox);
	
	public boolean getCollidable();
	
	public void setCollidable(boolean collidable);
	
	public int getCount();

	public void setCount(int count);

	public Type getType();

	public void setType(Type type);

	public Target getTarget();

	public void setTarget(Target target);

	public Element getElement();

	public void setElement(Element element);

	public String getChant();

	public void setChant(String chant);

	public String getName();

	public void setName(String name);

}
