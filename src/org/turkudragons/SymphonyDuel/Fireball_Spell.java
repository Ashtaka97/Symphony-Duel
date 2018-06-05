package org.turkudragons.SymphonyDuel;

import java.util.ArrayList;

public class Fireball_Spell extends Spell {

	public Fireball_Spell() {
		//(int power, int count, boolean collidable, boolean aoe, Shape area, Type type, Element element, float speed, String chant)
		super(10, 1, true, false, null, Type.ATTACK, Element.HEAT, 1, "DDD", "Fireball");		
	}
	
	public void cast(Player caster, Player opponent, ArrayList<Player> oList) {
		
	}
}
