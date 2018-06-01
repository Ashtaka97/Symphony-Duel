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
	private Input input;
	private Player p1;
	private Player p2;
	private String chantP1;
	private String chantP2;
	static ArrayList<Object> oList;
	private ArrayList<Shape> timerList;

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		timer = 0;
		tapInterval = 500;
		input = gc.getInput();
		chantP1 = "";
		chantP2 = "";
		p1 = new Player(200, 200);
		p2 = new Player(1000, 200);
		oList = new ArrayList<Object>();
		oList.add(p1);
		oList.add(p2);
		timerList = new ArrayList<Shape>();
		timerList.add(new Rectangle(200, 100, 10, 20));
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawString(timer+"", 550, 100);
		for(Object o : oList) {
			
		}
		for(Shape s : timerList) {
			g.draw(s);
		}
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {

		if(timer >= tapInterval) {
			timerList.add(new Rectangle(3, 20, 0, 0));
			timer = 0;
		}
		else timer += 1+delta;
		
		
		
		// Player 1 chanting
		if (input.isKeyPressed(Input.KEY_W)) {
			if(timerList.get(0).intersects(timerList.get(1))) chantP1 += "W";
			else chantP1 = "";
		}
		else if (input.isKeyPressed(Input.KEY_S)) {
			if(timerList.get(0).intersects(timerList.get(1))) chantP1 += "S";
			else chantP1 = "";
		}
		else if (input.isKeyPressed(Input.KEY_A)) {
			if(timerList.get(0).intersects(timerList.get(1))) chantP1 += "A";
			else chantP1 = "";
		}
		else if (input.isKeyPressed(Input.KEY_D)) {
			if(timerList.get(0).intersects(timerList.get(1))) chantP1 += "D";
			else chantP1 = "";
		}
		else if (input.isKeyPressed(Input.KEY_SPACE)) {
			checkSpell(chantP1);
			chantP1 = "";
		}

		// Player 2 chanting
		if (input.isKeyPressed(Input.KEY_UP)) {
			if(timerList.get(0).intersects(timerList.get(1))) chantP2 += "W";
			else chantP2 = "";
		}
		else if (input.isKeyPressed(Input.KEY_DOWN)) {
			if(timerList.get(0).intersects(timerList.get(1))) chantP2 += "S";
			else chantP2 = "";
		}
		else if (input.isKeyPressed(Input.KEY_LEFT)) {
			if(timerList.get(0).intersects(timerList.get(1))) chantP2 += "A";
			else chantP2 = "";
		}
		else if (input.isKeyPressed(Input.KEY_RIGHT)) {
			if(timerList.get(0).intersects(timerList.get(1))) chantP2 += "D";
			else chantP2 = "";
		}
		else if (input.isKeyPressed(Input.KEY_ENTER)) {
			checkSpell(chantP2);
			chantP2 = "";
		}
	}

	private void checkSpell(String s) {
		
	}

	@Override
	public int getID() {
		return 1;
	}

}
