package org.turkudragons.SymphonyDuel;

import java.util.ArrayList;
import org.newdawn.slick.geom.Shape;

public interface Spell {
	
	public static void handleCollision(Spell s1, Spell s2){
		
		int pmod1 = 1;
		int pmod2 = 1;
		
		if(compareElements(s1.getElement(), s2.getElement()) == -1) {
			pmod2 = 2;
		}
		if(compareElements(s1.getElement(), s2.getElement()) == 1) {
			pmod1 = 2;
		}
		
		if(s1.getPower()*pmod1 > s2.getPower()*pmod2) {
			s1.setPower(s1.getPower() - s2.getPower());
			s2.setDelete(true);
		}
		if(s1.getPower()*pmod1 < s2.getPower()*pmod2) {
			s2.setPower(s2.getPower() - s1.getPower());
			s1.setDelete(true);
		}
		if ((s1.getPower()*pmod1 == s2.getPower()*pmod2)) {
			s1.setDelete(true);
			s2.setDelete(true);
		}
		
/*		if(s1.getType() == Type.ATTACK && s2.getType() == Type.ATTACK) {
			if(s1.getElement() == s2.getElement()) {
				if(s1.getPower() > s2.getPower()) {
					s1.setPower(s1.getPower() + s2.getPower());
					s2.setDelete(true);
				}
				if(s1.getPower() < s2.getPower()) {
					s2.setPower(s2.getPower() + s1.getPower());
					s1.setDelete(true);
				}
				else {
					s1.setDelete(true);
					s2.setDelete(true);
				}
			}
			if(compareElements(s1.getElement(), s2.getElement()) == -1) {
				
			}
			if(compareElements(s1.getElement(), s2.getElement()) == 0) {
				
			}
			if(compareElements(s1.getElement(), s2.getElement()) == 1) {
				
			}
		}*/
	}
	
	/**
	 * Returns 1 if e1 is superior, 0 if equal, -1 if inferior to e2.
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static int compareElements(Element e1, Element e2) {
		if(e1 == Element.HEAT && e2 == Element.WATER) return -1;
		if(e2 == Element.HEAT && e1 == Element.WATER) return 1;
		
		if(e1 == Element.HEAT && e2 == Element.EARTH) return -1;
		if(e2 == Element.HEAT && e1 == Element.EARTH) return 1;
		
		if(e1 == Element.HEAT && e2 == Element.NATURE) return 1;
		if(e2 == Element.HEAT && e1 == Element.NATURE) return -1;
		
		
		
		return 0;
	}

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

	public int getPower();
	
	public void setPower(int power);
}
