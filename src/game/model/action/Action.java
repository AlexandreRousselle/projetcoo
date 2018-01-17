package game.model.action;

import game.model.map.tile.Case;
import game.persistance.VirtualCase;

public interface Action {

	public String doAction(VirtualCase c);
	
}
