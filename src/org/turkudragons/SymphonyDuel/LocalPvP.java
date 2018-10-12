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

	private int timer1;
	int tapInterval1;
	private int timer2;
	int tapInterval2;
	private int currentGrace1;
	private int currentGrace2;
	private final int grace = 300;
	private Input input;
	private Player p1;
	private Player p2;
	private String chantP1;
	private String chantP2;
	private boolean P1Crit;
	private boolean P2Crit;
	static ArrayList<Object> oList;
	private ArrayList<Shape> timerList1;
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
		timer1 = 0;
		tapInterval1 = 750;
		timer2 = 0;
		tapInterval2 = 750;
		currentGrace1 = 0;
		currentGrace2 = 0;
		input = gc.getInput();
		chantP1 = "";
		chantP2 = "";
		P1Crit = true;
		P2Crit = true;
		p1 = new Player(200, 500);
		p2 = new Player(1000, 500);
		oList = new ArrayList<Object>();
		oList.add(p1);
		oList.add(p2);
		timerList1 = new ArrayList<Shape>();
		timerList1.add(new Rectangle(100, 100, 50, 20));
		timerList1.add(new Rectangle(115, 100, 6, 20));
		timerList1.add(new Rectangle(85, 100, 15, 20));
		timerList2 = new ArrayList<Shape>();
		timerList2.add(new Rectangle(800, 100, 50, 20));
		timerList2.add(new Rectangle(815, 100, 6, 20));
		timerList2.add(new Rectangle(785, 100, 15, 20));
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawString(timer1+"", 550, 100);
		g.drawString(timer2+"", 600, 100);
		for(Object v : oList) {
			((Visible)v).display(g);
		}
		g.drawString(P1Crit + "", 200, 420);
		g.drawString(P2Crit + "", 1000, 420);
		g.drawString(chantP1, 200, 465);
		g.drawString(chantP2, 1000, 465);
		g.drawString("Hp: " + p1.hp, 200, 450);
		g.drawString("Hp: " + p2.hp, 1000, 450);
		g.drawString(p1LastSpell, 200, 435);
		g.drawString(p2LastSpell, 1000, 435);
		for(Shape s : timerList1) {
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
			if(((Active)oList.get(i)).getDelete()) oList.remove(i);
		}
		
		try {
			
			// Player 1 chanting
			if(currentGrace1 <= 0) {
				if (input.isKeyDown(Input.KEY_W)) {
					if(timerList1.get(1).intersects(timerList1.get(3))) chantP1 += "W";
					else if(timerList1.get(0).intersects(timerList1.get(3))) {
						chantP1 += "W";
						P1Crit = false;
					}
					else chantP1 = "";
					currentGrace1 = grace;
					timerList1.remove(3);
				}
				else if (input.isKeyDown(Input.KEY_S)) {
					if(timerList1.get(1).intersects(timerList1.get(3))) chantP1 += "S";
					else if(timerList1.get(0).intersects(timerList1.get(3))) {
						chantP1 += "S";
						P1Crit = false;
					}
					else chantP1 = "";
					currentGrace1 = grace;
					timerList1.remove(3);
				}
				else if (input.isKeyDown(Input.KEY_A)) {
					if(timerList1.get(1).intersects(timerList1.get(3))) chantP1 += "A";
					else if(timerList1.get(0).intersects(timerList1.get(3))) {
						chantP1 += "A";
						P1Crit = false;
					}
					else chantP1 = "";
					currentGrace1 = grace;
					timerList1.remove(3);
				}
				else if (input.isKeyDown(Input.KEY_D)) {
					if(timerList1.get(1).intersects(timerList1.get(3))) chantP1 += "D";
					else if(timerList1.get(0).intersects(timerList1.get(3))) {
						chantP1 += "D";
						P1Crit = false;
					}
					else chantP1 = "";
					currentGrace1 = grace;
					timerList1.remove(3);
				}
				else if (input.isKeyDown(Input.KEY_SPACE)) {
					checkSpell(chantP1, p1, p2);
					chantP1 = "";
				}
				else if(input.isKeyDown(Input.KEY_0)) {
					checkSpell("DDD", p1, p2);
					checkSpell("DDD", p2, p1);
					currentGrace1 = grace;
					currentGrace2 = grace;
				}
			}
			
		} catch(IndexOutOfBoundsException e) {
			
		} try {
			
			// Player 2 chanting
			if(currentGrace2 <= 0) {
				if (input.isKeyDown(Input.KEY_UP)) {
					if(timerList2.get(1).intersects(timerList2.get(3))) chantP2 += "W";
					else if(timerList2.get(0).intersects(timerList2.get(3))) {
						chantP2 += "W";
						P2Crit = false;
					}
					else chantP2 = "";
					currentGrace2 = grace;
					timerList2.remove(3);
				}
				else if (input.isKeyDown(Input.KEY_DOWN)) {
					if(timerList2.get(1).intersects(timerList2.get(3))) chantP2 += "S";
					else if(timerList2.get(0).intersects(timerList2.get(3))) {
						chantP2 += "S";
						P2Crit = false;
					}
					else chantP2 = "";
					currentGrace2 = grace;
					timerList2.remove(3);
				}
				else if (input.isKeyDown(Input.KEY_LEFT)) {
					if(timerList2.get(1).intersects(timerList2.get(3))) chantP2 += "A";
					else if(timerList2.get(0).intersects(timerList2.get(3))) {
						chantP2 += "A";
						P2Crit = false;
					}
					else chantP2 = "";
					currentGrace2 = grace;
					timerList2.remove(3);
				}
				else if (input.isKeyDown(Input.KEY_RIGHT)) {
					if(timerList2.get(1).intersects(timerList2.get(3))) chantP2 += "D";
					else if(timerList2.get(0).intersects(timerList2.get(3))) {
						chantP2 += "D";
						P2Crit = false;
					}
					else chantP2 = "";
					currentGrace2 = grace;
					timerList2.remove(3);
				}
				else if (input.isKeyDown(Input.KEY_ENTER)) {
					checkSpell(chantP2, p2, p1);
					chantP2 = "";
				}
			}
		} catch(IndexOutOfBoundsException e) {
			
		}
		
		int i = 0;
		for(Shape s : timerList1) {
			if(i < 3) i++;
			else{
				s.setX(s.getX()-delta/p1.chantReaction);
			}
		}
		int i2 = 0;
		for(Shape s : timerList2) {
			if(i2 < 3) i2++;
			else{
				s.setX(s.getX()-delta/p2.chantReaction);
			}
		}
		
		if(timer1 >= tapInterval1/p1.castSpeed) {
			timerList1.add(new Rectangle(500, 100, 3, 20));
			timer1 = 0;
		}
		else timer1 += 1+delta;
		
		if(timer2 >= tapInterval2/p2.castSpeed) {
			timerList2.add(new Rectangle(1200, 100, 3, 20));
			timer2 = 0;
		}
		else timer2 += 1+delta;
		
		try {
			if(timerList1.get(3).intersects(timerList1.get(2))) {
				timerList1.remove(3);
				chantP1 = "";
				currentGrace1 = grace;
				P1Crit = true;
			}
		} catch(IndexOutOfBoundsException e) {
			
		}
		
		if(currentGrace1 > 0) {
			currentGrace1 -= delta;
		}
		
		try {
			if(timerList2.get(3).intersects(timerList2.get(2))) {
				timerList2.remove(3);
				chantP2 = "";
				currentGrace2 = grace;
				P2Crit = true;
			}
		} catch(IndexOutOfBoundsException e) {
			
		}
		
		if(currentGrace2 > 0) {
			currentGrace2 -= delta;
		}
		
	}

	private void checkSpell(String chant, Player caster, Player opponent) {
		Spell s = null;
		boolean crit;
		if(caster.equals(p1)) {
			crit = P1Crit;
			P1Crit = true;
		}
		else {
			crit = P2Crit;
			P2Crit = true;
		}
		for(Spell spell : spells) {
			if(spell.getChant().equals(chant)) {
				s = spell;
			}
		}
		try {
			if(!s.equals(null)) {
				s.cast(caster, opponent, oList, crit);
				if(caster.equals(p1)) p1LastSpell = s.getName();
				else p2LastSpell = s.getName();
			}
		} catch(NullPointerException e) {
			
		}
	}

	@Override
	public int getID() {
		return 1;
	}

}
