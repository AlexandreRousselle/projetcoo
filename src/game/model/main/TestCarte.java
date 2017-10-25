package game.model.main;

import game.model.joueur.JoueurType;
import game.model.joueur.factory.BarbaresFactory;
import game.model.joueur.factory.GauloisFactory;
import game.model.map.Carte;
import game.model.map.factory.CarteFactory;
import game.model.map.factory.CarteType;
import game.model.partie.Partie;

public class TestCarte {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Partie p = new Partie("P1", new CarteFactory().creerCarte(CarteType.FORESTIERE, 10));
		p.ajouterJoueur(new BarbaresFactory().creerJoueur("Jean", JoueurType.JOUEURHUMAIN));
		p.ajouterJoueur(new GauloisFactory().creerJoueur("Paul", JoueurType.JOUEURIA));
		System.out.println(p.toString());
		System.out.println(p.getCarte().toStringModelise());
		System.out.println(p.getCarte().toString());
	}

}
