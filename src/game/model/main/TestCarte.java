package game.model.main;

import game.model.joueur.Joueur;
import game.model.joueur.JoueurTribu;
import game.model.map.factory.CarteFactory;
import game.model.map.factory.CarteType;
import game.model.partie.Partie;

public class TestCarte {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Partie p = new Partie("P1", new CarteFactory().creerCarte(CarteType.FERMIERE, 10));
		p.ajouterJoueur(new Joueur("Jacques", JoueurTribu.BARBARES));
		p.ajouterJoueur(new Joueur("Paul", JoueurTribu.EGYPTIENS));
		System.out.println(p.toString());
		System.out.println(p.getCarte().toStringModelise());
		System.out.println(p.getCarte().toString());
	}

}
