package org.turkudragons.SymphonyDuel;

import java.util.ArrayList;

import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class Turn extends Thread {
	
	private Player caster;
	
	public Turn(Player caster) {
		this.caster = caster;
	}
	
	@Override
	public void run() {
		int currentGrace = caster.getCurrentGrace();
		int timer = caster.getTimer();
		int tapInterval = caster.getTapInterval();
		boolean crit = caster.isCrit();
		ArrayList<Shape> timerList = new ArrayList<Shape>(caster.getTimerList());
		ArrayList<Integer> inputList = new ArrayList<Integer>(caster.getInputList());
		int chantReaction = caster.getChantReaction();
		int castSpeed = caster.getCastSpeed();
		try {
			if (currentGrace <= 0) {
				if (LocalPvP.input.isKeyDown(inputList.get(0))) {
					if (timerList.get(1).intersects(timerList.get(3)))
						caster.addChant("W");
					else if (timerList.get(0).intersects(timerList.get(3))) {
						caster.addChant("W");
						crit = false;
					} else
						caster.setChant("");
					caster.setCurrentGrace(300);
					timerList.remove(3);
				} else if (LocalPvP.input.isKeyDown(inputList.get(1))) {
					if (timerList.get(1).intersects(timerList.get(3)))
						caster.addChant("S");
					else if (timerList.get(0).intersects(timerList.get(3))) {
						caster.addChant("S");
						crit = false;
					} else
						caster.setChant("");
					caster.setCurrentGrace(300);
					timerList.remove(3);
				} else if (LocalPvP.input.isKeyDown(inputList.get(2))) {
					if (timerList.get(1).intersects(timerList.get(3)))
						caster.addChant("A");
					else if (timerList.get(0).intersects(timerList.get(3))) {
						caster.addChant("A");
						crit = false;
					} else
						caster.setChant("");
					caster.setCurrentGrace(300);
					timerList.remove(3);
				} else if (LocalPvP.input.isKeyDown(inputList.get(3))) {
					if (timerList.get(1).intersects(timerList.get(3)))
						caster.addChant("D");
					else if (timerList.get(0).intersects(timerList.get(3))) {
						caster.addChant("D");
						crit = false;
					} else
						caster.setChant("");
					caster.setCurrentGrace(300);
					timerList.remove(3);
				} else if (LocalPvP.input.isKeyDown(inputList.get(4))) {
					LocalPvP.checkSpell(caster.getChant(), caster, crit);
					caster.setChant("");
					crit = true;
				}
				caster.setTimerList(timerList);
			}
		} catch (IndexOutOfBoundsException e) {}
		
		int i = 0;
		for (Shape s : timerList) {
			if (i < 3)
				i++;
			else {
				s.setX(s.getX() - LocalPvP.getDelta() / chantReaction);
			}
		}

		if (timer >= tapInterval / castSpeed) {
			timerList.add(new Rectangle(timerList.get(0).getX() + 400, 100, 3, 20));
			timer = 0;
		} else
			timer += 1 + LocalPvP.getDelta();
		try {
			if (timerList.get(3).intersects(timerList.get(2)) || timerList.get(3).getX() < timerList.get(0).getX()) {
				timerList.remove(3);
				caster.setChant("");
				currentGrace = LocalPvP.getDelta();
				crit = true;
			}
		} catch (IndexOutOfBoundsException e) {}

		if (caster.getCurrentGrace() > 0) {
			caster.setCurrentGrace(caster.getCurrentGrace() - LocalPvP.getDelta());
		}
		caster.setTimerList(timerList);
		caster.setTimer(timer);
		caster.setCrit(crit);
	}
}
