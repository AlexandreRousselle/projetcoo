package game.model.map;

import game.model.Observable;
import game.model.Visiteur;
import game.model.map.factory.CarteType;
import game.model.map.tile.Case;
import game.model.partie.Partie;
import game.persistance.UnitOfWorks;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Carte extends Observable {

	private int id_carte;
	private Partie partie;
	private CarteType carte_type;
	private int dimension;
	private List<Case> listeCases;
	
	public Carte(CarteType carte_type, int dimension) {
		this.carte_type = carte_type;
		this.dimension = dimension;
		this.listeCases = new ArrayList<Case>();
	}
	
	public Carte() {
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		String res = "Carte " + this.carte_type.toString() + " de dimension : " + this.dimension + "\n";
		for (int i = 0; i < listeCases.size(); i++) {
			res += listeCases.get(i).getId_case() + ", " + listeCases.get(i).getLibelle() + "\n";
		}
		return res;
	}
	
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
	
	public int getId_carte() {
		return id_carte;
	}

	public void setId_carte(int id_carte) {
		this.id_carte = id_carte;
		this.notifyUpdate();
	}

	public Partie getPartie() {
		return partie;
	}
	
	public void setPartie(Partie partie) {
		this.partie = partie;
		this.notifyUpdate();
	}
	
	public List<Case> getListeCases() {
		return listeCases;
	}
	
	public void setListeCases(List<Case> listeCases) {
		this.listeCases = listeCases;
	}

	public CarteType getCarte_type() {
		return carte_type;
	}

	public void setCarte_type(CarteType carte_type) {
		this.carte_type = carte_type;
		this.notifyUpdate();
	}

	public int getDimension() {
		return dimension;
	}

	public void setDimension(int dimension) {
		this.dimension = dimension;
		this.notifyUpdate();
	}

	@Override
	public void accept(Visiteur v) {
		// TODO Auto-generated method stub
		v.visit(this);
	}
	
}
