package org.turkudragons.SymphonyDuel;

import java.util.ArrayList;

import org.newdawn.slick.Graphics;

public class GiftOfLife_Spell extends Spell {
	
	public GiftOfLife_Spell() {
		//(int power, int count, boolean collidable, Shape area, Type type, Target target, Element element, float speed, String chant, String name)
		super(50, 1, false, Type.BUFFDEBUFF, Target.SELF, Element.RADIANT, 1, "WWW", "Gift Of Life");
	}
	
	public void cast(Player caster, Player opponent, ArrayList<Object> oList, boolean crit) {
		if(crit) {
			power = power*2;
		}
		caster.hp += power;
	}

	public void update(ArrayList<Object> o, int delta) {
		
	}

	public void display(Graphics g) {
		
	}
}
