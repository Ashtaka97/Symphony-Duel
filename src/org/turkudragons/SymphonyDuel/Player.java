package org.turkudragons.SymphonyDuel;

import java.util.ArrayList;

public class Player {

	int hp;
	ArrayList<Spell> spellsThisTurn;
	String inputs = "";
	boolean failed;
	
	public Player() {
		hp = 100;
		spellsThisTurn = new ArrayList<Spell>();
	}
	
	public void update() {
		if(Main.turnTimeout) {
			castSpellsThisTurn();
		}
		if(/*input*/ true) {
			inputs += "input";
		}
		if(inputs.length() == 3) {
			if(checkSpell(inputs));
			else failed = true;
		}
	}
	
	public void castSpellsThisTurn() {
		for(Spell s : spellsThisTurn) {
			s.cast();
		}
		
	}
	
	public boolean checkSpell(String inputs) {
		/*if(input.equals(spellRequirement)) {
		 * spells.add(new Spell())
		 * return true;
		 *} * x
		 */
		return false;
	}
}
