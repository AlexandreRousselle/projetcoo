package game.main;

import game.joueur.Joueur;
import game.joueur.JoueurType;
import game.joueur.factory.BarbaresFactory;
import game.map.territoire.Territoire;
import game.map.tile.Case;
import game.map.tile.Montagne;
import game.map.tile.Plaine;
import game.map.tile.decorator.CaseAttaque;
import game.map.tile.decorator.CaseSante;

public class TestCase {
	
	public static void main(String[] args) {
		BarbaresFactory bf = new BarbaresFactory();
		Joueur j = bf.creerJoueur("Jean", JoueurType.JOUEURHUMAIN);
		Territoire t1 = new Territoire(j);
		Case c1 = new Plaine(0.5, 0.4);
		Case c2 = new Montagne(0.7, 1.5);
		Case c3 = new Montagne(1, 5);
		c1 = new CaseAttaque(c1);
		c2 = new CaseSante(c2);
		t1.ajouterCase(c1);
		t1.ajouterCase(c2);
		t1.ajouterCase(c3);
		System.out.println(c1.getLibelle());
		System.out.println(c2.getLibelle());
		System.out.println(c3.getLibelle());
		t1.afficherTerritoire();
	}

}
