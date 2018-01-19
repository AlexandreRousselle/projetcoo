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

/**
 * La classe CarteFactory qui permet la génération de la carte
 * @author roussellea
 *
 */
public class CarteFactory {
	
	protected Carte carte = null;
	
	/**
	 * Fonction creer la carte et qui la stocke dans l'objet Carte
	 * Revoie la carte en question
	 * @param carte_type
	 * @param dimension
	 * @return
	 */
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
	
	/**
	 * Generer les coordonnees par rapport à une dimension de carte
	 * @param dimension
	 * @return
	 */
	public List<Coordonnees> genererCoordonnees(int dimension) {
		List<Coordonnees> listCoordonnees = new ArrayList<Coordonnees>();
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				listCoordonnees.add(new Coordonnees(i, j));
			}
		}
		return listCoordonnees;
	}
	
	/**
	 * Creer les case de la map avec la liste des coordonnées générées
	 * et la fonction random case type
	 * @param listCoordonnees
	 * @return
	 */
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
	
	/**
	 * Renvoie un type de case aléatoire
	 * @return
	 */
	public CaseType randomCaseType() {
		int valeur = (int) (Math.random()*100);
		int nbChamps = this.carte.getCarte_type().getNbChamps();
		int nbPlaines = this.carte.getCarte_type().getNbPlaines();
		if (valeur < nbPlaines) {
			return CaseType.values()[0];
		} else if (valeur < nbChamps + nbPlaines) {
			return CaseType.values()[1];
		} else {
			return CaseType.values()[2];
		}
	}
	
	/**
	 * Renvoie un effet de case aléatoire
	 * @return
	 */
	public EffetType randomEffetType() {
		int valeur = (int) (Math.random()*100);
	    if(valeur > 70) {
	    	return EffetType.values()[new Random().nextInt(4)];
	    } else {
	    	return EffetType.values()[0];
	    }
	}
	
}
