package game.joueur.factory;

import game.joueur.Joueur;
import game.joueur.JoueurHumain;
import game.joueur.JoueurIA;
import game.joueur.JoueurTribu;
import game.joueur.JoueurType;

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
