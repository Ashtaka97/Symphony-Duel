package org.turkudragons.SymphonyDuel;

public class Fireball_Spell extends Spell {

	int power = 10;
	int count = 1;
	boolean aoe = false;
	Type type = Type.ATTACK;
	Element element = Element.HEAT;
	public Fireball_Spell(int power, int count, boolean aoe, Type type, Element element) {
		super(power, count, aoe, type, element);
		
	}
	
}
