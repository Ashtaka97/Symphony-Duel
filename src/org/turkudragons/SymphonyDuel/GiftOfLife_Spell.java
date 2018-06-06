package org.turkudragons.SymphonyDuel;

import java.util.ArrayList;

import org.newdawn.slick.Graphics;

public class GiftOfLife_Spell extends Spell {
	
	public GiftOfLife_Spell() {
		//(int power, int count, boolean collidable, Shape area, Type type, Target target, Element element, float speed, String chant, String name)
		super(100, 1, false, null, Type.BUFFDEBUFF, Target.SELF, Element.RADIANT, 1, "WWW", "Gift Of Life");
	}
	
	public void cast(Player caster, Player opponent, ArrayList<Object> oList) {
		
	}

	public void update(ArrayList<Object> o, int delta) {
		
	}

	public void display(Graphics g) {
		
	}
}
