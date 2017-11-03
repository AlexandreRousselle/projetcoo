package game.model.joueur;

import game.model.map.territoire.Territoire;
import game.model.partie.Partie;
import game.model.unite.Unite;
import game.user.Utilisateur;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Joueur {

	protected UUID id_joueur;
	protected Utilisateur utilisateur;
	protected Territoire territoireConquis;
	protected JoueurTribu joueur_tribu;
	protected int ressources;
	protected List<Unite> listUnites;
	
	public Joueur(Utilisateur utilisateur, JoueurTribu joueur_tribu) {
		this.id_joueur = UUID.randomUUID();
		this.utilisateur = utilisateur;
		this.joueur_tribu = joueur_tribu;
		this.ressources = 1000;
		this.listUnites = new ArrayList<Unite>();
	}

	public String toString() {
		String str = "ID du joueur : " + this.id_joueur
						 + ", Nom du joueur : " + this.utilisateur.getPseudo() 
							+ ", Tribu : " + this.getJoueur_tribu();
		return str;
	}   
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public List<Unite> getListUnites() {
		return listUnites;
	}

	public void setListUnites(List<Unite> listUnites) {
		this.listUnites = listUnites;
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
