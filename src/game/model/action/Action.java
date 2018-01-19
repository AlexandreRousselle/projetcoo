package game.model.action;

import game.model.map.tile.Case;
import game.persistance.VirtualCase;

/**
 * Interface Action qui implemente une methode doAction
 * pour les futures sous actions
 * @author roussellea
 *
 */
public interface Action {

	/**
	 * Fait une action grâce à la case passée en paramètre
	 * et retourne un message en String
	 * @param c
	 * @return
	 */
	public String doAction(VirtualCase c);
	
}
