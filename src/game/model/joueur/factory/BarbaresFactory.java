package game.model.joueur.factory;

import game.model.joueur.Joueur;
import game.model.joueur.JoueurHumain;
import game.model.joueur.JoueurIA;
import game.model.joueur.JoueurTribu;
import game.model.joueur.JoueurType;

public class BarbaresFactory {

	public Joueur creerJoueur(String nom_joueur, JoueurType joueur_type) {
		Joueur joueur = null;
		switch(joueur_type)
        {
            case JOUEURHUMAIN:joueur = new JoueurHumain(nom_joueur, JoueurTribu.BARBARES);break;
            case JOUEURIA:joueur = new JoueurIA(nom_joueur, JoueurTribu.BARBARES);break;
        }
		return joueur;
	}
	
}
