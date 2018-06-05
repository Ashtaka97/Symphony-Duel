package org.turkudragons.SymphonyDuel;

public class GiftOfLife_Spell extends Spell {
	public GiftOfLife_Spell() {
		//(int power, int count, boolean collidable, boolean aoe, Shape area, Type type, Element element, float speed, String chant)
		super(100, 1, false, false, null, Type.BUFFDEBUFF, Element.RADIANT, 1, "WWW", "Gift Of Life");
	}
	
	public void cast(Player caster, Player opponent) {
		
	}
}
