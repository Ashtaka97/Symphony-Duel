package org.turkudragons.SymphonyDuel;

public abstract class Spell {
	protected int power;
	protected int count;
	protected boolean aoe;
	protected Type type;
	protected Element element;
	protected float defx;
	protected float defy;
	
	public Spell(int power, int count, boolean aoe, Type type, Element element, float defx, float defy) {
		this.power = power;
		this.count = count;
		this.aoe = aoe;
		this.type = type;
		this.element = element;
		this.defx = defx;
		this.defy = defy;
	}
	
	public void cast() {
		
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
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

	public Element getElement() {
		return element;
	}

	public void setElement(Element element) {
		this.element = element;
	}
}
