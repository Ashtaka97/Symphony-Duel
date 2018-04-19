package org.turkudragons.SymphonyDuel;

import java.util.ArrayList;

public class Player {

	int hp;
	ArrayList<Spell> spellsThisTurn;
	boolean failed;
	
	public Player() {
		hp = 100;
		spellsThisTurn = new ArrayList<Spell>();
	}
	
	public void update() {
		
	}
	
	public void castSpellsThisTurn() {
		for(Spell s : spellsThisTurn) {
			s.cast();
		}
		spellsThisTurn = new ArrayList<Spell>();
	}
	
}
