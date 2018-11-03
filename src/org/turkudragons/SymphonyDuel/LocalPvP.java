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

	private Input input;
	private static Player p1;
	private static Player p2;
	private Turn turn1;
	private Turn turn2;
	static ArrayList<Object> oList;
	private static ArrayList<Spell> spells;
	private static int delta;

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		spells = new ArrayList<Spell>();
		spells.add(new Fireball_Spell());
		spells.add(new GiftOfLife_Spell());
		input = gc.getInput();
		p1 = new Player(200, 500);
		p2 = new Player(1000, 500);
		oList = new ArrayList<Object>();
		oList.add(p1);
		oList.add(p2);
		ArrayList<Shape> timerList1 = new ArrayList<Shape>();
		timerList1.add(new Rectangle(100, 100, 50, 20));
		timerList1.add(new Rectangle(115, 100, 6, 20));
		timerList1.add(new Rectangle(85, 100, 15, 20));
		ArrayList<Shape> timerList2 = new ArrayList<Shape>();
		timerList2.add(new Rectangle(800, 100, 50, 20));
		timerList2.add(new Rectangle(815, 100, 6, 20));
		timerList2.add(new Rectangle(785, 100, 15, 20));
		ArrayList<Integer> inputList1 = new ArrayList<Integer>();
		inputList1.add(Input.KEY_W);
		inputList1.add(Input.KEY_A);
		inputList1.add(Input.KEY_S);
		inputList1.add(Input.KEY_D);
		inputList1.add(Input.KEY_SPACE);
		ArrayList<Integer> inputList2 = new ArrayList<Integer>();
		inputList2.add(Input.KEY_UP);
		inputList2.add(Input.KEY_LEFT);
		inputList2.add(Input.KEY_DOWN);
		inputList2.add(Input.KEY_RIGHT);
		inputList2.add(Input.KEY_ENTER);
		turn1 = new Turn(input, p1, p2, timerList1, inputList1);
		turn2 = new Turn(input, p2, p1, timerList2, inputList2);
		turn1.start();
		turn2.start();
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		for(Object v : oList) {
			((Visible)v).display(g);
		}
		turn1.display(g);
		turn2.display(g);
		turn1.interrupt();
		turn2.interrupt();
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		
		for(int i = oList.size()-1; i >= 0 ; i--) {
			((Active)oList.get(i)).update(oList, delta);
			if(((Active)oList.get(i)).getDelete()) oList.remove(i);
		}
		
		LocalPvP.delta = delta;
		
		if(input.isKeyDown(Input.KEY_0) && turn1.currentGrace <= 0) {
			LocalPvP.checkSpell("DDD", p1, p2, true);
			LocalPvP.checkSpell("DDD", p2, p1, true);
			turn1.currentGrace = 300;
		}
	}

	public synchronized static void checkSpell(String chant, Player caster, Player opponent, boolean crit) {
		Spell s = null;
		for(Spell spell : spells) {
			if(spell.getChant().equals(chant)) {
				s = spell;
			}
		}
		try {
			if(!s.equals(null)) {
				s.cast(caster, opponent, oList, crit);
				caster.pLastSpell = s.getName();
			}
		} catch(NullPointerException e) {
			
		}
	}
	
	public synchronized static int getDelta() {
		return delta;
	}

	@Override
	public int getID() {
		return 1;
	}

}
