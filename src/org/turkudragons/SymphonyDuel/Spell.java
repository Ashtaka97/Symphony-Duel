package org.turkudragons.SymphonyDuel;

public class Spell {
	private int power;
	private int range;
	private int count;
	private boolean aoe;
	private Type type;
	
	public Spell(int power, int range, int count, boolean aoe, Type type) {
		this.power = power;
		this.range = range;
		this.count = count;
		this.aoe = aoe;
		this.type = type;
	}
	
	public void cast() {
		
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public boolean isAoe() {
		return aoe;
	}

	public void setAoe(boolean aoe) {
		this.aoe = aoe;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
}
