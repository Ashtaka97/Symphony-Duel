package org.turkudragons.SymphonyDuel;

import java.util.ArrayList;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Main extends StateBasedGame {
	
	ArrayList<Player> players = new ArrayList<Player>();
	static boolean turnTimeout;
	
	public Main(String name) {
		super(name);
	}

	public static void main(String[] args) {

		AppGameContainer appgc;
		
		try {
			appgc = new AppGameContainer(new Main("Symphony Duel"));
			appgc.setDisplayMode(800, 600, false);
			appgc.setAlwaysRender(true);
			appgc.start();
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		addState(new Menu()); //id = 0
		
		this.getState(0).init(gc, this);
	}

}
