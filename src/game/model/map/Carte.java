package game.model.map;

import game.model.Observable;
import game.model.Visiteur;
import game.model.map.factory.CarteType;
import game.model.map.tile.Case;
import game.model.partie.Partie;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe Carte Observable qui stocke les éléments d'une carte
 * @author roussellea
 *
 */
public class Carte extends Observable {

	private int id_carte;
	private Partie partie;
	private CarteType carte_type;
	private int dimension;
	protected List<Case> listeCases;

	/**
	 * Constructeur Carte
	 * @param carte_type
	 * @param dimension
	 */
	public Carte(CarteType carte_type, int dimension) {
		this.carte_type = carte_type;
		this.dimension = dimension;
		this.listeCases = new ArrayList<Case>();
	}
	
	/**
	 * Constructeur vide
	 */
	public Carte() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * La fonction toString() pour le précédent mode texte
	 */
	public String toString() {
		String res = "Carte " + this.carte_type.toString() + " de dimension : " + this.dimension + "\n";
		for (int i = 0; i < listeCases.size(); i++) {
			res += listeCases.get(i).getId_case() + ", " + listeCases.get(i).getLibelle() + "\n";
		}
		return res;
	}
	
	/**
	 * La fonction toString() pour le précédent mode texte
	 * Modélise la carte dans la console en un carré
	 */
	public String toStringModelise() {
		String res = "Carte n°" + this.id_carte + ", " + this.carte_type.toString() + " de dimension : " + this.dimension + "\n";
		for (int i = 1; i <= listeCases.size(); i++) {
			/*if(listeCases.get(i-1).getUnite() == null){
				res += "  |";
			} else {
				res += "V" + listeCases.get(i-1).getUnite().getProprietaire() + "|";
			}*/
			res += listeCases.get(i-1).getCase_type();
		 	if (i%this.dimension == 0) {
				res += "\n";
			}
		}
		return res;
	}
	
	/**
	 * Get l'id de la carte
	 * @return
	 */
	public int getId_carte() {
		return id_carte;
	}

	/**
	 * Set l'id de la carte
	 * @param id_carte
	 */
	public void setId_carte(int id_carte) {
		this.id_carte = id_carte;
		this.notifyUpdate();
	}

	/**
	 * Get l'id de la carte
	 * @return
	 */
	public Partie getPartie() {
		return partie;
	}
	
	/**
	 * Set l'id de la partie
	 * @param partie
	 */
	public void setPartie(Partie partie) {
		this.partie = partie;
		this.notifyUpdate();
	}
	
	/**
	 * Get la liste des cases
	 * @return
	 */
	public List<Case> getListeCases() {
		return listeCases;
	}
	
	/**
	 * Set la liste des cases avec une liste
	 * @param listeCases
	 */
	public void setListeCases(List<Case> listeCases) {
		this.listeCases = listeCases;
	}

	/**
	 * Get le type de carte
	 * @return
	 */
	public CarteType getCarte_type() {
		return carte_type;
	}

	/**
	 * Set le type de carte
	 * @param carte_type
	 */
	public void setCarte_type(CarteType carte_type) {
		this.carte_type = carte_type;
		this.notifyUpdate();
	}

	/**
	 * Get la dimension de la carte
	 * @return
	 */
	public int getDimension() {
		return dimension;
	}

	/**
	 * Set la dimension de la carte
	 * @param dimension
	 */
	public void setDimension(int dimension) {
		this.dimension = dimension;
		this.notifyUpdate();
	}

	/**
	 * Methode accept de notre classe Observable (dans le package game.model)
	 */
	@Override
	public void accept(Visiteur v) {
		// TODO Auto-generated method stub
		v.visit(this);
	}
	
}
