package game.map.territoire;

import game.joueur.Joueur;
import game.map.tile.Case;
import java.util.ArrayList;
import java.util.List;

public class Territoire {

	private Joueur proprietaire;
	private List<Case> listeCases;
	
	public Territoire(Joueur proprietaire) {
		this.proprietaire = proprietaire;
		this.listeCases = new ArrayList<Case>();
	}

	public void ajouterCase(Case c) {
		this.listeCases.add(c);
	}
	
	public Joueur getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Joueur proprietaire) {
		this.proprietaire = proprietaire;
	}

	public List<Case> getListeCases() {
		return listeCases;
	}

	public void setListeCases(List<Case> listeCases) {
		this.listeCases = listeCases;
	}
	
	public void afficherTerritoire() {
		for (int i = 0; i < this.listeCases.size(); i++) {
			System.out.println(this.listeCases.get(i).getLibelle());
		}
	}

}
