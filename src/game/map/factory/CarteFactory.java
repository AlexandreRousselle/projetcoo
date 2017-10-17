package game.map.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import game.map.Carte;
import game.map.tile.Case;
import game.map.tile.CaseType;
import game.map.tile.Champ;
import game.map.tile.Foret;
import game.map.tile.Mer;
import game.map.tile.Montagne;
import game.map.tile.Plaine;
import game.map.tile.decorator.CaseAttaque;
import game.map.tile.decorator.CaseDefense;
import game.map.tile.decorator.CaseSante;
import game.map.tile.decorator.EffetType;
import game.utils.Coordonnees;

public class CarteFactory {
	
	public Carte creerCarte(CarteType carte_type, int dimension) {
		Carte carte = null;
		switch(carte_type)
        {
            case EXOTIQUE:carte = new Carte(carte_type, dimension);
            	carte.setListeCases(creerCases(genererCoordonnees(dimension)));
            break;
            case FORESTIERE:carte = new Carte(carte_type, dimension);
        		carte.setListeCases(creerCases(genererCoordonnees(dimension)));
            break;
            case DESERTIQUE:carte = new Carte(carte_type, dimension);
        		carte.setListeCases(creerCases(genererCoordonnees(dimension)));
            break;
            case OCEANIQUE:carte = new Carte(carte_type, dimension);
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
				case PLAINE:c = new Plaine(listCoordonnees.get(i));break;
				case FORET:c = new Foret(listCoordonnees.get(i));break;
				case CHAMP:c = new Champ(listCoordonnees.get(i));break;
				case MONTAGNE:c = new Montagne(listCoordonnees.get(i));break;
				case MER:c = new Mer(listCoordonnees.get(i));break;
			}
			EffetType et = randomEffetType();
			switch(et)
			{
				case ATTAQUEPLUS:c = new CaseAttaque(c);break;
				case DEFENSEPLUS:c = new CaseDefense(c);break;
				case SANTEPLUS:c = new CaseSante(c);;break;
				default:break;
			}
			listCases.add(c);
		}
		return listCases;
	}
	
	public EffetType randomEffetType() {
		int valeur = new Random().nextInt(EffetType.values().length);
	    return EffetType.values()[valeur];
	}
	
	//à restructurer intelligemment
	public CaseType randomCaseType() {
		int valeur = new Random().nextInt(CaseType.values().length);
	    return CaseType.values()[valeur];
	}
	
}
