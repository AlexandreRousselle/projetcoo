package game.model.joueur;

import game.model.Observable;
import game.model.Visiteur;
import game.model.map.territoire.Territoire;
import game.model.partie.Partie;
import game.model.unite.Unite;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Joueur extends Observable {

	protected int id_joueur;
	protected String nom_joueur;
	protected Territoire territoireConquis;
	protected JoueurTribu joueur_tribu;
	protected Color couleur;
	protected int ressources;
	protected List<Unite> listUnites;
	
	public Joueur(String nom_joueur, JoueurTribu joueur_tribu, Color couleur) {
		this.nom_joueur = nom_joueur;
		this.joueur_tribu = joueur_tribu;
		this.couleur = couleur;
		this.listUnites = new ArrayList<Unite>();
	}
	
	public Joueur(){
		
	}

	public Color getCouleur() {
		return couleur;
	}

	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}

	public String toString() {
		String str = "Nom du joueur : " + this.getNom_joueur() 
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

	@Override
	public void accept(Visiteur v) {
		v.visit(this);
	}	

}
