package org.turkudragons.SymphonyDuel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

	public static Input input;
	private static Player p1;
	private static Player p2;
	static ArrayList<Object> oList;
	private static ArrayList<Spell> spells;
	private static int delta;
	private ExecutorService turnManager;
	private ArrayList<Callable> turns;

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		spells = new ArrayList<Spell>();
		spells.add(new Fireball_Spell());
		spells.add(new GiftOfLife_Spell());
		input = gc.getInput();
		oList = new ArrayList<Object>();
		ArrayList<Shape> timerList1 = new ArrayList<Shape>();
		timerList1.add(new Rectangle(75, 100, 75, 20));
		timerList1.add(new Rectangle(110, 100, 6, 20));
		timerList1.add(new Rectangle(60, 100, 15, 20));
		ArrayList<Shape> timerList2 = new ArrayList<Shape>();
		timerList2.add(new Rectangle(775, 100, 75, 20));
		timerList2.add(new Rectangle(810, 100, 6, 20));
		timerList2.add(new Rectangle(760, 100, 15, 20));
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
		p1 = new Player(200, 500, timerList1, inputList1);
		p2 = new Player(1000, 500, timerList2, inputList2);
		oList.add(p1);
		oList.add(p2);
		turnManager = Executors.newCachedThreadPool();
		turns = new ArrayList<Callable>();
		turns.add(p1.getTurn());
		turns.add(p2.getTurn());
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		
		for(Object v : oList) {
			((Visible)v).display(g);
		}
		
		g.drawString(p1.isCrit() + "", p1.hitbox.getX(), p1.hitbox.getY()-20);
		g.drawString(p1.getChant(), p1.hitbox.getX(), p1.hitbox.getY()-65);
		g.drawString("Hp: " + p1.hp, p1.hitbox.getX(), p1.hitbox.getY()-50);
		g.drawString(p1.pLastSpell, p1.hitbox.getX(), p1.hitbox.getY()-35);
		int x = p1.getTimerList().size();
		try {
			for(int i = 0; i < x; i++) {
				g.draw(p1.getTimerList().get(i));
			}
		} catch(IndexOutOfBoundsException e) {}
		
		g.drawString(p2.isCrit() + "", p2.hitbox.getX(), p2.hitbox.getY()-20);
		g.drawString(p2.getChant(), p2.hitbox.getX(), p2.hitbox.getY()-65);
		g.drawString("Hp: " + p2.hp, p2.hitbox.getX(), p2.hitbox.getY()-50);
		g.drawString(p2.pLastSpell, p2.hitbox.getX(), p2.hitbox.getY()-35);
		x = p2.getTimerList().size();
		try {
			for(int i = 0; i < x; i++) {
				g.draw(p2.getTimerList().get(i));
			}
		} catch(IndexOutOfBoundsException e) {}
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		for(int i = oList.size()-1; i >= 0 ; i--) {
			((Active)oList.get(i)).update(oList, delta);
			if(((Active)oList.get(i)).getDelete()) oList.remove(i);
		}
		
		LocalPvP.delta = delta;
		
		if(input.isKeyDown(Input.KEY_0) && p1.getCurrentGrace() <= 0) {
			LocalPvP.checkSpell("DDD", p1, true);
			LocalPvP.checkSpell("DDD", p2, true);
			p1.setCurrentGrace(300);
		}
		
		try {
			turnManager.invokeAll((Collection<? extends Callable<Integer>>) turns);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized static void checkSpell(String chant, Player caster, boolean crit) {
		Spell s = null;
		Player opponent;
		if(p1.equals(caster)) opponent = p2;
		else opponent = p1;
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
	
	public static int getDelta() {
		return delta;
	}

	@Override
	public int getID() {
		return 1;
	}

}
