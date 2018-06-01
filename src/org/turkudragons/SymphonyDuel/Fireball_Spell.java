package org.turkudragons.SymphonyDuel;

public class Fireball_Spell extends Spell {

	
	public Fireball_Spell() {
		//int power, int count, boolean aoe, Type type, Element element, float defx, float defy)
		super(10, 1, false, Type.ATTACK, Element.HEAT,((Player)LocalPvP.oList.get(0)).x,((Player)LocalPvP.oList.get(0)).y);
		
	}
	
}
