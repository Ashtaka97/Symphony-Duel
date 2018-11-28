package org.turkudragons.SymphonyDuel;

import java.util.ArrayList;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class Player implements Visible, Active{

	protected int hp;
	protected int x;
	protected int y;
	protected Shape hitbox;
	protected int castSpeed;
	protected int chantReaction;
	protected int maxHp;
	protected boolean delete = false;
	protected String pLastSpell;
	private int timer;
	private int tapInterval;
	private int currentGrace;
	private String chant;
	private boolean crit;
	private ArrayList<Shape> timerList;
	private ArrayList<Integer> inputList;
	private Turn turn;
	
	public Player(int x, int y, ArrayList<Shape> timerList, ArrayList<Integer> inputList) {
		hp = 100;
		maxHp = 100;
		this.x = x;
		this.y = y;
		hitbox = new Rectangle(x, y, 16, 32);
		castSpeed = 1;
		chantReaction = 3;
		pLastSpell = "";
		timer = 0;
		tapInterval = 750;
		currentGrace = 0;
		chant = "";
		crit = true;
		this.timerList = new ArrayList<Shape>(timerList);
		this.inputList = new ArrayList<Integer>(inputList);
	}
	
	public void display(Graphics g) {
		g.draw(hitbox);
	}

	public void update(ArrayList<Object> o, int delta) {
		if(hp > maxHp) {
			hp = maxHp;
		}
		turn = new Turn(this);
	}

	public boolean getDelete() {
		return delete;
	}
	
	public synchronized int getTimer() {
		return timer;
	}

	public synchronized void setTimer(int timer) {
		this.timer = timer;
	}

	public synchronized int getTapInterval() {
		return tapInterval;
	}

	public synchronized void setTapInterval(int tapInterval) {
		this.tapInterval = tapInterval;
	}

	public synchronized int getCurrentGrace() {
		return currentGrace;
	}

	public synchronized void setCurrentGrace(int currentGrace) {
		this.currentGrace = currentGrace;
	}

	public synchronized String getChant() {
		return chant;
	}

	public synchronized void setChant(String chant) {
		this.chant = chant;
	}
	
	public synchronized void addChant(String chant) {
		this.chant += chant;
	}

	public synchronized boolean isCrit() {
		return crit;
	}

	public synchronized void setCrit(boolean crit) {
		this.crit = crit;
	}

	public synchronized ArrayList<Shape> getTimerList() {
		return timerList;
	}

	public synchronized void setTimerList(ArrayList<Shape> timerList) {
		this.timerList = timerList;
	}

	public synchronized ArrayList<Integer> getInputList() {
		return inputList;
	}

	public synchronized void setInputList(ArrayList<Integer> inputList) {
		this.inputList = inputList;
	}

	public synchronized Turn getTurn() {
		return turn;
	}

	public synchronized void setTurn(Turn turn) {
		this.turn = turn;
	}

	public synchronized int getCastSpeed() {
		return castSpeed;
	}

	public synchronized void setCastSpeed(int castSpeed) {
		this.castSpeed = castSpeed;
	}

	public synchronized int getChantReaction() {
		return chantReaction;
	}

	public synchronized void setChantReaction(int chantReaction) {
		this.chantReaction = chantReaction;
	}
}
