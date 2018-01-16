package game.model.map.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import game.model.joueur.Joueur;
import game.model.map.Carte;
import game.model.map.Coordonnees;
import game.model.map.tile.Case;
import game.model.map.tile.CaseType;
import game.model.map.tile.decorator.CaseAttaque;
import game.model.map.tile.decorator.CaseDefense;
import game.model.map.tile.decorator.CaseSante;
import game.model.map.tile.decorator.EffetType;

public class CarteFactory {
	
	protected Carte carte = null;
	
	public Carte creerCarte(CarteType carte_type, int dimension) {
		switch(carte_type)
        {
            case FERMIERE:carte = new Carte(carte_type, dimension);
        		carte.setListeCases(creerCases(genererCoordonnees(dimension)));
            break;
            case MONTAGNEUSE:carte = new Carte(carte_type, dimension);
        		carte.setListeCases(creerCases(genererCoordonnees(dimension)));
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
			Case c = null;
			CaseType ct = randomCaseType();
			switch(ct)
			{
				case PLAINE:c = new Case(carte, listCoordonnees.get(i), true, CaseType.PLAINE);break;
				case CHAMP:c = new Case(carte, listCoordonnees.get(i), true, CaseType.CHAMP);break;
				case MONTAGNE:c = new Case(carte, listCoordonnees.get(i), false, CaseType.MONTAGNE);break;
			}
			EffetType et = randomEffetType();
			switch(et)
			{
				case ATTAQUEPLUS:c = new CaseAttaque(carte, c);break;
				case DEFENSEPLUS:c = new CaseDefense(carte, c);break;
				case SANTEPLUS:c = new CaseSante(carte, c);;break;
				default:break;
			}
			listCases.add(c);
		}
		return listCases;
	}
	
	//à restructurer intelligemment
	public CaseType randomCaseType() {
		int valeur = (int) (Math.random()*100);
		int nbChamps = this.carte.getCarte_type().getNbChamps();
		int nbPlaines = this.carte.getCarte_type().getNbPlaines();
		if (valeur < nbChamps) {
			return CaseType.values()[0];
		} else if (valeur < nbChamps + nbPlaines) {
			return CaseType.values()[1];
		} else {
			return CaseType.values()[2];
		}
	}
	
	public EffetType randomEffetType() {
		int valeur = (int) (Math.random()*100);
	    if(valeur > 70) {
	    	return EffetType.values()[new Random().nextInt(4)];
	    } else {
	    	return EffetType.values()[0];
	    }
	}
	
}
