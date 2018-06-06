package org.turkudragons.SymphonyDuel;

import java.util.ArrayList;

import org.newdawn.slick.Graphics;

public class Fireball_Spell extends Spell {

	public Fireball_Spell() {
		//(int power, int count, boolean collidable, Shape area, Type type, Target target, Element element, float speed, String chant, String name)
		super(10, 1, true, null, Type.ATTACK, Target.ENEMY, Element.HEAT, 1, "DDD", "Fireball");
	}
	
	public void cast(Player caster, Player opponent, ArrayList<Object> oList) {
		
	}

	public void update(ArrayList<Object> o, int delta) {
		
	}

	public void display(Graphics g) {
		
	}
}
