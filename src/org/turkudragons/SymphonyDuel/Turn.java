package org.turkudragons.SymphonyDuel;

import java.util.ArrayList;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class Turn extends Thread implements Visible{
	
	private int timer;
	private int tapInterval;
	public int currentGrace;
	private Input input;
	private String chant;
	private boolean crit;
	private Player caster;
	private Player opponent;
	private ArrayList<Shape> timerList;
	private ArrayList<Integer> inputList;
	
	public Turn(Input input, Player caster, Player opponent, ArrayList<Shape> timerList, ArrayList<Integer> inputList) {
		timer = 0;
		tapInterval = 750;
		currentGrace = 0;
		this.input = input;
		chant = "";
		crit = true;
		this.caster = caster;
		this.opponent = opponent;
		this.timerList = new ArrayList<Shape>(timerList);
		this.inputList = new ArrayList<Integer>(inputList);
	}

	@Override
	public void run() {
		while(true) {
			try {
				sleep(10000);
			} catch (InterruptedException e1) {}
			try {
				if(currentGrace <= 0) {
					if (input.isKeyDown(inputList.get(0))) {
						if(timerList.get(1).intersects(timerList.get(3))) chant += "W";
						else if(timerList.get(0).intersects(timerList.get(3))) {
							chant += "W";
							crit = false;
						}
						else chant = "";
						currentGrace = 300;
						timerList.remove(3);
					}
					else if (input.isKeyDown(inputList.get(1))) {
						if(timerList.get(1).intersects(timerList.get(3))) chant += "S";
						else if(timerList.get(0).intersects(timerList.get(3))) {
							chant += "S";
							crit = false;
						}
						else chant = "";
						currentGrace = 300;
						timerList.remove(3);
					}
					else if (input.isKeyDown(inputList.get(2))) {
						if(timerList.get(1).intersects(timerList.get(3))) chant += "A";
						else if(timerList.get(0).intersects(timerList.get(3))) {
							chant += "A";
							crit = false;
						}
						else chant = "";
						currentGrace = 300;
						timerList.remove(3);
					}
					else if (input.isKeyDown(inputList.get(3))) {
						if(timerList.get(1).intersects(timerList.get(3))) chant += "D";
						else if(timerList.get(0).intersects(timerList.get(3))) {
							chant += "D";
							crit = false;
						}
						else chant = "";
						currentGrace = 300;
						timerList.remove(3);
					}
					else if (input.isKeyDown(inputList.get(4))) {
						LocalPvP.checkSpell(chant, caster, opponent, crit);
						chant = "";
						crit = true;
					}
				}
				
			} catch(IndexOutOfBoundsException e) {
				
			}
			
			int i = 0;
			for(Shape s : timerList) {
				if(i < 3) i++;
				else{
					s.setX(s.getX()-LocalPvP.getDelta()/caster.chantReaction);
				}
			}
			
			if(timer >= tapInterval/caster.castSpeed) {
				timerList.add(new Rectangle(timerList.get(0).getX()+400, 100, 3, 20));
				timer = 0;
			}
			else timer += 1+LocalPvP.getDelta();
			
			
			try {
				if(timerList.get(3).intersects(timerList.get(2)) || timerList.get(3).getX() < timerList.get(0).getX()) {
					timerList.remove(3);
					chant = "";
					currentGrace = LocalPvP.getDelta();
					crit = true;
				}
			} catch(IndexOutOfBoundsException e) {
				
			}
			
			if(currentGrace > 0) {
				currentGrace -= LocalPvP.getDelta();
			}
		}
	}

	@Override
	public void display(Graphics g) {
		g.drawString(crit + "", caster.hitbox.getX(), caster.hitbox.getY()-20);
		g.drawString(chant, caster.hitbox.getX(), caster.hitbox.getY()-65);
		g.drawString("Hp: " + caster.hp, caster.hitbox.getX(), caster.hitbox.getY()-50);
		g.drawString(caster.pLastSpell, caster.hitbox.getX(), caster.hitbox.getY()-35);
		for(Shape s : timerList) {
			g.draw(s);
		}
	}
}
