package game.model.partie;

import java.awt.Color;
import java.time.Instant;
import java.util.ArrayList;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import game.model.Observable;
import game.model.User;
import game.model.Visiteur;
import game.model.joueur.Joueur;
import game.model.map.Carte;
import game.persistance.UnitOfWorks;

public class Partie extends Observable {
	
	protected int id_partie;
	private String nom_partie;
	private Carte carte; 
	private Date date;
	private User createur;
	private int nb_tours;
	private int nb_ressources_tour;
	private int nb_joueurs;
	protected List<Joueur> listeJoueurs;
	private EtatPartie etat_partie;
	
	public Partie() {
	}
	
	public Partie(String nom_partie, User createur, int nb_joueurs, int nb_tours, int nb_ressources_tour, Carte carte) {
		this.nom_partie = nom_partie;
		this.createur = createur;
		this.setNb_joueurs(nb_joueurs);
		this.nb_tours = nb_tours;
		this.nb_ressources_tour = nb_ressources_tour;
		this.carte = carte;
		this.carte.setPartie(this);
		this.date.toInstant();
		this.etat_partie = EtatPartie.ATTENTE;
		this.listeJoueurs = new ArrayList<Joueur>();
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
	
	public User getCreateur() {
		return createur;
	}

	public void setCreateur(User createur) {
		this.createur = createur;
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

	public int getNb_tours() {
		return nb_tours;
	}

	public void setNb_tours(int nb_tours) {
		this.nb_tours = nb_tours;
	}

	public int getNb_ressources_tour() {
		return nb_ressources_tour;
	}

	public void setNb_ressources_tour(int nb_ressources_tour) {
		this.nb_ressources_tour = nb_ressources_tour;
	}

	public int getNb_joueurs() {
		return nb_joueurs;
	}

	public void setNb_joueurs(int nb_joueurs) {
		this.nb_joueurs = nb_joueurs;
	}

	public List<Joueur> getListeJoueurs() {
		return listeJoueurs;
	}

	public void setListeJoueurs(List<Joueur> listeJoueurs) {
		this.listeJoueurs = listeJoueurs;
	}
	
}
