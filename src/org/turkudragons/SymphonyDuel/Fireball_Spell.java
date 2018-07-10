package org.turkudragons.SymphonyDuel;

import java.util.ArrayList;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

public class Fireball_Spell extends Spell {

	public Fireball_Spell() {
		//(int power, int count, boolean collidable, Type type, Target target, Element element, float speed, String chant, String name)
		super(10, 1, true, Type.ATTACK, Target.ENEMY, Element.HEAT, 1, "DDD", "Fireball");
	}
	
	public void cast(Player caster, Player opponent, ArrayList<Object> oList) {
		super.cast(caster, opponent, oList);
		hitbox = new Rectangle(caster.x, caster.y+8, 8, 8);
		oList.add(this);
	}

	public void update(ArrayList<Object> oList, int delta) {
		super.update(oList, delta);
	}

	public void display(Graphics g) {
		super.display(g);
	}
}
