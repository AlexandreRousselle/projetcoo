package game.joueur;

import game.map.territoire.Territoire;
import game.partie.Partie;
import java.util.List;

public abstract class Joueur {

	protected int id_joueur;
	protected String nom_joueur;
	protected List<Partie> listeParties;
	protected Territoire territoireConquis;
	protected JoueurType joueur_type;
	protected JoueurTribu joueur_tribu;
	
	public Joueur(String nom_joueur, JoueurType joueur_type, JoueurTribu joueur_tribu) {
		this.nom_joueur = nom_joueur;
		this.joueur_type = joueur_type;
		this.joueur_tribu = joueur_tribu;
	}
	
	public String toString() {
		String str = "Nom du joueur : " + this.getNom_joueur() 
						+ ", Type : " + this.joueur_type
							+ ", Tribu : " + this.getJoueur_tribu();
		return str;
	}   
	
	public int getId_joueur() {
		return id_joueur;
	}

	public void setId_joueur(int id_joueur) {
		this.id_joueur = id_joueur;
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
