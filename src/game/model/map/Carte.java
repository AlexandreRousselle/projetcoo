package game.model.map;

import game.model.map.factory.CarteType;
import game.model.map.tile.Case;
import game.model.map.tile.decorator.EffetType;
import game.model.partie.Partie;

import java.util.ArrayList;
import java.util.List;

public class Carte {

	private int id_carte;
	private Partie partie;
	private CarteType carte_type;
	private int dimension;
	private List<Case> listeCases;
	//private String type_carte;
	
	public Carte(CarteType carte_type, int dimension) {
		this.id_carte = 0;
		this.carte_type = carte_type;
		this.partie = new Partie();
		this.dimension = dimension;
		this.listeCases = new ArrayList<Case>();
	}
	
	public String toString() {
		String res = "Carte " + this.carte_type.toString() + " de dimension : " + this.dimension + "\n";
		for (int i = 0; i < listeCases.size(); i++) {
			res += listeCases.get(i).getLibelle() + "\n";
		}
		return res;
	}
	
	public String toStringModelise() {
		String res = "Carte " + this.carte_type.toString() + " de dimension : " + this.dimension + "\n";
		for (int i = 1; i <= listeCases.size(); i++) {
			res += "[";
			if (listeCases.get(i-1).getEffet_type() != EffetType.DEFAULT){
				res += listeCases.get(i-1).getEffet_type().toString() + "]";
			} else {
				res += "         ]";
			}
		 	if (i%10 == 0) {
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
	}
	
	public Partie getPartie() {
		return partie;
	}
	
	public void setPartie(Partie partie) {
		this.partie = partie;
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
	}

	public int getDimension() {
		return dimension;
	}

	public void setDimension(int dimension) {
		this.dimension = dimension;
	}
	
}
