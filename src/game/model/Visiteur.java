package game.model;

import game.model.joueur.Joueur;
import game.model.partie.Partie;

public abstract class Visiteur {

	public void visit(Visitable v){
		v.accept(this);
	}
	
	public abstract void visit(Joueur j);
	public abstract void visit(Partie p);
}
