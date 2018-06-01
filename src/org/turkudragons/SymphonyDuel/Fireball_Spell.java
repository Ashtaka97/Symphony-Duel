package org.turkudragons.SymphonyDuel;

import org.newdawn.slick.geom.Shape;

public class Fireball_Spell extends Spell {

	public Fireball_Spell() {
		//(int power, int count, boolean collidable, boolean aoe, Shape area, Type type, Element element, float defx, float defy, float speed, String chant)
		super(10, 1, true, false, null, Type.ATTACK, Element.HEAT,((Player)LocalPvP.oList.get(0)).x,((Player)LocalPvP.oList.get(0)).y, 1, "DDD");		
	}
	
	public void cast() {
		
	}
}
