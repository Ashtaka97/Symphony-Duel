/**
 * 
 */
package org.turkudragons.SymphonyDuel;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;

public class LocalPvP extends BasicGameState implements GameState {

	/*
	 * /Methods that are usable because of implementation of GameState/
	 * 
	 * 
	 * Methods inherited from interface org.newdawn.slick.MouseListener
	 * 
	 * mouseClicked, mouseDragged, mouseMoved, mousePressed, mouseReleased,
	 * mouseWheelMoved
	 * 
	 * 
	 * 
	 * Methods inherited from interface org.newdawn.slick.KeyListener
	 * 
	 * keyPressed, keyReleased
	 * 
	 * 
	 * 
	 * Methods inherited from interface org.newdawn.slick.ControllerListener
	 * 
	 * controllerButtonPressed, controllerButtonReleased, controllerDownPressed,
	 * controllerDownReleased, controllerLeftPressed, controllerLeftReleased,
	 * controllerRightPressed, controllerRightReleased, controllerUpPressed,
	 * controllerUpReleased
	 * 
	 * 
	 * 
	 * Methods inherited from interface org.newdawn.slick.ControlledInputReciever
	 * 
	 * inputEnded, inputStarted, isAcceptingInput, setInput
	 */

	private int timer;
	int tapInterval;
	private int timer2;
	int tapInterval2;
	private int grace;
	private int grace2;
	private Input input;
	private Player p1;
	private Player p2;
	private String chantP1;
	private String chantP2;
	static ArrayList<Object> oList;
	private ArrayList<Shape> timerList;
	private ArrayList<Shape> timerList2;
	private ArrayList<Spell> spells;
	private String p1LastSpell;
	private String p2LastSpell;

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		spells = new ArrayList<Spell>();
		spells.add(new Fireball_Spell());
		spells.add(new GiftOfLife_Spell());
		p1LastSpell = "";
		p2LastSpell = "";
		timer = 0;
		tapInterval = 750;
		timer2 = 0;
		tapInterval2 = 750;
		grace = 0;
		grace2 = 0;
		input = gc.getInput();
		chantP1 = "";
		chantP2 = "";
		p1 = new Player(200, 500);
		p2 = new Player(1000, 500);
		oList = new ArrayList<Object>();
		oList.add(p1);
		oList.add(p2);
		timerList = new ArrayList<Shape>();
		timerList.add(new Rectangle(100, 100, 50, 20));
		timerList.add(new Rectangle(85, 100, 15, 20));
		timerList2 = new ArrayList<Shape>();
		timerList2.add(new Rectangle(800, 100, 50, 20));
		timerList2.add(new Rectangle(785, 100, 15, 20));
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawString(timer+"", 550, 100);
		g.drawString(timer2+"", 600, 100);
		for(Object v : oList) {
			((Visible)v).display(g);
		}
		g.drawString(chantP1, 200, 465);
		g.drawString(chantP2, 1000, 465);
		g.drawString("Hp: " + p1.hp, 200, 450);
		g.drawString("Hp: " + p2.hp, 1000, 450);
		g.drawString(p1LastSpell, 200, 435);
		g.drawString(p2LastSpell, 1000, 435);
		for(Shape s : timerList) {
			g.draw(s);
		}
		for(Shape s : timerList2) {
			g.draw(s);
		}
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		
		for(int i = oList.size()-1; i >= 0 ; i--) {
			((Active)oList.get(i)).update(oList, delta);
		}
		
		try {
			
			// Player 1 chanting
			if(grace <= 0) {
				if (input.isKeyDown(Input.KEY_W)) {
					if(timerList.get(0).intersects(timerList.get(2))) chantP1 += "W";
					else chantP1 = "";
					grace = 300;
					timerList.remove(2);
				}
				else if (input.isKeyDown(Input.KEY_S)) {
					if(timerList.get(0).intersects(timerList.get(2))) chantP1 += "S";
					else chantP1 = "";
					grace = 300;
					timerList.remove(2);
				}
				else if (input.isKeyDown(Input.KEY_A)) {
					if(timerList.get(0).intersects(timerList.get(2))) chantP1 += "A";
					else chantP1 = "";
					grace = 300;
					timerList.remove(2);
				}
				else if (input.isKeyDown(Input.KEY_D)) {
					if(timerList.get(0).intersects(timerList.get(2))) chantP1 += "D";
					else chantP1 = "";
					grace = 300;
					timerList.remove(2);
				}
				else if (input.isKeyDown(Input.KEY_SPACE)) {
					checkSpell(chantP1, p1, p2);
					chantP1 = "";
				}
			}
			
		} catch(IndexOutOfBoundsException e) {
			
		} try {
			
			// Player 2 chanting
			if(grace2 <= 0) {
				if (input.isKeyDown(Input.KEY_UP)) {
					if(timerList2.get(0).intersects(timerList2.get(2))) chantP2 += "W";
					else chantP2 = "";
					grace2 = 300;
					timerList2.remove(2);
				}
				else if (input.isKeyDown(Input.KEY_DOWN)) {
					if(timerList2.get(0).intersects(timerList2.get(2))) chantP2 += "S";
					else chantP2 = "";
					grace2 = 300;
					timerList2.remove(2);
				}
				else if (input.isKeyDown(Input.KEY_LEFT)) {
					if(timerList2.get(0).intersects(timerList2.get(2))) chantP2 += "A";
					else chantP2 = "";
					grace2 = 300;
					timerList2.remove(2);
				}
				else if (input.isKeyDown(Input.KEY_RIGHT)) {
					if(timerList2.get(0).intersects(timerList2.get(2))) chantP2 += "D";
					else chantP2 = "";
					grace2 = 300;
					timerList2.remove(2);
				}
				else if (input.isKeyDown(Input.KEY_ENTER)) {
					checkSpell(chantP2, p2, p1);
					chantP2 = "";
				}
			}
		} catch(IndexOutOfBoundsException e) {
			
		}
		
		int i = 0;
		for(Shape s : timerList) {
			if(i < 2) i++;
			else{
				s.setX(s.getX()-delta/p1.chantReaction);
			}
		}
		int i2 = 0;
		for(Shape s : timerList2) {
			if(i2 < 2) i2++;
			else{
				s.setX(s.getX()-delta/p2.chantReaction);
			}
		}
		
		if(timer >= tapInterval/p1.castSpeed) {
			timerList.add(new Rectangle(500, 100, 3, 20));
			timer = 0;
		}
		else timer += 1+delta;
		
		if(timer2 >= tapInterval2/p1.castSpeed) {
			timerList2.add(new Rectangle(1200, 100, 3, 20));
			timer2 = 0;
		}
		else timer2 += 1+delta;
		
		try {
			if(timerList.get(2).intersects(timerList.get(1))) {
				timerList.remove(2);
				chantP1 = "";
				grace = 300;
			}
		} catch(IndexOutOfBoundsException e) {
			
		}
		
		if(grace > 0) {
			grace -= delta;
		}
		
		try {
			if(timerList2.get(2).intersects(timerList2.get(1))) {
				timerList2.remove(2);
				chantP2 = "";
				grace2 = 300;
			}
		} catch(IndexOutOfBoundsException e) {
			
		}
		
		if(grace2 > 0) {
			grace2 -= delta;
		}
		
	}

	private void checkSpell(String chant, Player caster, Player opponent) {
		for(Spell spell : spells) {
			if(spell.chant.equals(chant)) {
				spell.cast(caster, opponent, oList);
				if(caster.equals(p1)) p1LastSpell = spell.name;
				else p2LastSpell = spell.name;
			} else {
				if(caster.equals(p1)) p1LastSpell = "";
				else p2LastSpell = "";
			}
		}
	}

	@Override
	public int getID() {
		return 1;
	}

}
