package game.model.partie;

import game.model.Observable;
import game.model.Visiteur;
import game.model.joueur.Joueur;
import game.model.map.Carte;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Partie extends Observable {
	
	protected int id_partie;
	private String nom_partie;
	private Carte carte; 
	private Date date;
	protected List<Joueur> listeJoueurs;
	private EtatPartie etat_partie;
	
	public Partie() {
	}
	
	public Partie(String nom_partie, Carte carte) {
		this.nom_partie = nom_partie;
		this.carte = carte;
		this.carte.setPartie(this);
		this.date = Date.from(Instant.now());
		this.listeJoueurs = new ArrayList<Joueur>();
	}
	
	public Partie(String nom_partie, Carte carte, List<Joueur> listeJoueurs) {
		this.nom_partie = nom_partie;
		this.carte = carte;
		this.carte.setPartie(this);
		this.date = Date.from(Instant.now());
		this.listeJoueurs = listeJoueurs;
	}

	public void ajouterJoueur(Joueur joueur) {
		listeJoueurs.add(joueur);
	}
	
	public String toString() {
		String res = "Partie n°" + this.id_partie + " -> Nom de partie : " + this.nom_partie + " -> Créée le : " + this.date.toString() + "\n";
		for (int i = 0; i < this.listeJoueurs.size(); i++) {
			res += listeJoueurs.get(i).toString() + "\n";
		}
		return res;
	}
	
	public List<Joueur> getListeJoueurs() {
		return listeJoueurs;
	}

	public void setListeJoueurs(List<Joueur> listeJoueurs) {
		this.listeJoueurs = listeJoueurs;
	}

	public Carte getCarte() {
		return carte;
	}

	public void setCarte(Carte carte) {
		this.carte = carte;
	}

	public int getId_partie() {
		return id_partie;
	}

	public void setId_partie(int id_partie) {
		this.id_partie = id_partie;
	}

	public String getNom_partie() {
		return nom_partie;
	}

	public void setNom_partie(String nom_partie) {
		this.nom_partie = nom_partie;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public EtatPartie getEtat_partie() {
		return etat_partie;
	}

	public void setEtat_partie(EtatPartie etat_partie) {
		this.etat_partie = etat_partie;
	}

	@Override
	public void accept(Visiteur v) {
		v.visit(this);
	}
	
}
