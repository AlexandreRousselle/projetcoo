package game.model;

import game.model.joueur.Joueur;
import game.model.partie.Partie;

/**
 * 
 * @author roussellea
 *
 */
public abstract class Visiteur {

	/**
	 * 
	 * @param v
	 */
	public void visit(Visitable v){
		v.accept(this);
	}
	/**
	 * 
	 * @param j
	 */
	public abstract void visit(Joueur j);
	
	/**
	 * 
	 * @param p
	 */
	public abstract void visit(Partie p);
}
