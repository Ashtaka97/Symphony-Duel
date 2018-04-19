/**
 * 
 */
package org.turkudragons.SymphonyDuel;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
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

	private boolean chanting;
	private boolean casting;
	private int turnNumber;
	private int turnTimer;
	private Input input;
	private Player p1;
	private Player p2;
	private String chantP1;
	private String chantP2;

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		turnNumber = 1;
		turnTimer = 0;
		chanting = false;
		casting = false;
		input = gc.getInput();
		chantP1 = "";
		chantP2 = "";
		p1 = new Player();
		p2 = new Player();
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawString(turnNumber + "", 0, 0);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		if (chanting) {

			turnTimer += delta;
			if (turnTimer >= 60000) {
				chanting = false;
				casting = true;
			}

			// Player 1 chanting
			if (!p1.failed) {
				if (input.isKeyPressed(Input.KEY_W)) {

				} else if (input.isKeyPressed(Input.KEY_S)) {

				} else if (input.isKeyPressed(Input.KEY_A)) {

				} else if (input.isKeyPressed(Input.KEY_D)) {

				} else if (input.isKeyPressed(Input.KEY_SPACE)) {
					p1.spellsThisTurn.add(checkSpell(chantP1));
					if (p1.spellsThisTurn.get(p1.spellsThisTurn.size() - 1) == null) {
						p1.failed = true;
					}
				}
			}

			// Player 2 chanting
			if (!p2.failed) {
				if (input.isKeyPressed(Input.KEY_UP)) {

				} else if (input.isKeyPressed(Input.KEY_DOWN)) {

				} else if (input.isKeyPressed(Input.KEY_LEFT)) {

				} else if (input.isKeyPressed(Input.KEY_RIGHT)) {

				} else if (input.isKeyPressed(Input.KEY_ENTER)) {
					p2.spellsThisTurn.add(checkSpell(chantP2));
					if (p2.spellsThisTurn.get(p2.spellsThisTurn.size() - 1) == null) {
						p2.failed = true;
					}
				}
			}
		} else if (casting) {
			p1.castSpellsThisTurn();
			p2.castSpellsThisTurn();
			casting = false;
		} else {
			chanting = true;
		}
	}

	private Spell checkSpell(String s) {
		return null;
	}

	@Override
	public int getID() {
		return 1;
	}

}
