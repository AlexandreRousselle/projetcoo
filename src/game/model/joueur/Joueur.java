package game.model.joueur;

import game.model.joueur.buildings.Construction;
import game.model.map.territoire.Territoire;
import game.model.partie.Partie;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Joueur {

	protected UUID id_joueur;
	protected String nom_joueur;
	protected List<Partie> listeParties;
	protected Territoire territoireConquis;
	protected JoueurTribu joueur_tribu;
	protected int ressources;
	protected List<Construction> constructions;
	
	public Joueur(String nom_joueur, JoueurTribu joueur_tribu) {
		this.id_joueur = UUID.randomUUID();
		this.nom_joueur = nom_joueur;
		this.joueur_tribu = joueur_tribu;
		this.constructions = new ArrayList<Construction>();
	}

	public String toString() {
		String str = "ID du joueur : " + this.id_joueur
						 + ", Nom du joueur : " + this.getNom_joueur() 
							+ ", Tribu : " + this.getJoueur_tribu();
		return str;
	}   

	public List<Construction> getConstructions() {
		return constructions;
	}

	public void setConstructions(List<Construction> constructions) {
		this.constructions = constructions;
	}

	public UUID getId_joueur() {
		return id_joueur;
	}

	public void setId_joueur(UUID id_joueur) {
		this.id_joueur = id_joueur;
	}

	public int getRessources() {
		return ressources;
	}

	public void setRessources(int ressources) {
		this.ressources = ressources;
	}

	public String getNom_joueur() {
		return nom_joueur;
	}

	public void setNom_joueur(String nom_joueur) {
		this.nom_joueur = nom_joueur;
	}

	public List<Partie> getListeParties() {
		return listeParties;
	}

	public void setListeParties(List<Partie> listeParties) {
		this.listeParties = listeParties;
	}

	public Territoire getTerritoireConquis() {
		return territoireConquis;
	}

	public void setTerritoireConquis(Territoire territoireConquis) {
		this.territoireConquis = territoireConquis;
	}

	public JoueurTribu getJoueur_tribu() {
		return joueur_tribu;
	}

	public void setJoueur_tribu(JoueurTribu joueur_tribu) {
		this.joueur_tribu = joueur_tribu;
	}	

}
