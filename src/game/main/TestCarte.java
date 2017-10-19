package game.main;

import game.joueur.JoueurType;
import game.joueur.factory.BarbaresFactory;
import game.joueur.factory.GauloisFactory;
import game.map.Carte;
import game.map.factory.CarteFactory;
import game.map.factory.CarteType;
import game.partie.Partie;

public class TestCarte {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Partie p = new Partie("P1", new CarteFactory().creerCarte(CarteType.DESERTIQUE, 10));
		p.ajouterJoueur(new BarbaresFactory().creerJoueur("Jean", JoueurType.JOUEURHUMAIN));
		p.ajouterJoueur(new GauloisFactory().creerJoueur("Paul", JoueurType.JOUEURIA));
		System.out.println(p.toString());
		System.out.println(p.getCarte().toStringModelise());
		System.out.println(p.getCarte().toString());
	}

}
