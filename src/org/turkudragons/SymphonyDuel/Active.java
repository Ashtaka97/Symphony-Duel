package org.turkudragons.SymphonyDuel;

import java.util.ArrayList;

public interface Active {
	void update(ArrayList<Object> oList, int delta);
	boolean getDelete();
}
