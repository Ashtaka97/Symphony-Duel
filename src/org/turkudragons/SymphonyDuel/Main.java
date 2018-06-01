package org.turkudragons.SymphonyDuel;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Main extends StateBasedGame {
	
	public Main(String name) {
		super(name);
	}

	public static void main(String[] args) {

		AppGameContainer appgc;
		
		try {
			appgc = new AppGameContainer(new Main("Symphony Duel"));
			appgc.setDisplayMode(800, 600, false);
			appgc.setAlwaysRender(true);
			appgc.setTargetFrameRate(60);
			appgc.start();
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		addState(new Menu()); //id = 0
		addState(new LocalPvP()); //id = 1
		this.getState(0).init(gc, this);
		this.getState(1).init(gc, this);
	}

}
