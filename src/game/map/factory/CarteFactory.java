package game.map.factory;

import java.util.ArrayList;
import java.util.List;

import game.map.Carte;
import game.map.tile.Case;
import game.map.tile.CaseAccessible;
import game.map.tile.Plaine;
import game.partie.Partie;
import game.utils.Coordonnees;

public class CarteFactory {
	
	public Carte creerCarte(String nom_joueur, Partie partie, CarteType carte_type) {
		Carte carte = null;
		switch(carte_type)
        {
            case EXOTIQUE:carte = new Carte(carte_type, partie);
            
            break;
            case FORESTIERE:carte = new Carte(carte_type, partie);
            
            break;
            case DESERTIQUE:carte = new Carte(carte_type, partie);
            
            break;
            case OCEANIQUE:carte = new Carte(carte_type, partie);
            
            break;
            case MONTAGNEUSE:carte = new Carte(carte_type, partie);
            
            break;
        }
		return carte;
	}
	
	public List<Coordonnees> genererCoordonnees(int dimension) {
		List<Coordonnees> listCoordonnees = new ArrayList<Coordonnees>();
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				listCoordonnees.add(new Coordonnees(i, j));
			}
		}
		return listCoordonnees;
	}
	
	public List<Case> creerCases(List<Coordonnees> listCoordonnees) {
		List<Case> listCases = new ArrayList<Case>();
		for (int i = 0; i < listCoordonnees.size(); i++) {
			Case c = new Plaine(listCoordonnees.get(i));
			listCases.add(c);
		}
		return listCases;
	}
	
}
