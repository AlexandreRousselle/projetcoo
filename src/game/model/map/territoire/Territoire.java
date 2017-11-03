package game.model.map.territoire;

import game.model.joueur.Joueur;
import game.model.map.tile.Case;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Territoire {

	private UUID id_territoire;
	private Joueur proprietaire;
	private List<Case> listeCases;
	
	public Territoire(Joueur proprietaire) {
		this.id_territoire = UUID.randomUUID();
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

	public UUID getId_territoire() {
		return id_territoire;
	}

	public void setId_territoire(UUID id_territoire) {
		this.id_territoire = id_territoire;
	}

}
