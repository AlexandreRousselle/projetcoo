package game.model.partie;

import java.util.ArrayList;
import java.util.HashMap;
import java.sql.Date;
import java.util.List;
import java.util.Map;

import game.model.Observable;
import game.model.Visiteur;
import game.model.joueur.Joueur;
import game.model.map.Carte;

/**
 * Classe Partie Observable qui stocke les informations d'une partie
 * @author roussellea
 *
 */
public class Partie extends Observable {
	
	protected int id_partie;
	private String nom_partie;
	protected Carte carte; 
	private Date date;
	private Joueur createur;
	private int nb_tours;
	private int nb_ressources_initial;
	private int nb_ressources_tour;
	private int nb_joueurs;
	protected List<Joueur> listeJoueurs;
	protected Map<Joueur, Integer> mapJoueurs;
	private EtatPartie etat_partie;
	
	/**
	 * Constructeur vide d'une partie
	 */
	public Partie() {
		this.listeJoueurs = new ArrayList<Joueur>();
		this.mapJoueurs = new HashMap<Joueur, Integer>();
	}
	
	/**
	 * Constructeur d'une partie avec les attributs possibles
	 * @param nom_partie
	 * @param createur
	 * @param nb_joueurs
	 * @param nb_tours
	 * @param nb_ressources_initial
	 * @param nb_ressources_tour
	 * @param carte
	 */
	public Partie(String nom_partie, Joueur createur, int nb_joueurs, int nb_tours, int nb_ressources_initial, int nb_ressources_tour, Carte carte) {
		this.nom_partie = nom_partie;
		this.createur = createur;
		this.setNb_joueurs(nb_joueurs);
		this.nb_tours = nb_tours;
		this.nb_ressources_initial = nb_ressources_initial;
		this.nb_ressources_tour = nb_ressources_tour;
		this.carte = carte;
		this.carte.setPartie(this);
		this.etat_partie = EtatPartie.ATTENTE;
		this.listeJoueurs = new ArrayList<Joueur>();
		this.mapJoueurs = new HashMap<Joueur, Integer>();
	}
	
	/**
	 * Get les ressources d'un joueur
	 * @param id_joueur
	 * @return
	 */
	public int getRessourcesByIdJoueur(int id_joueur){
		for (Map.Entry<Joueur,Integer> e : mapJoueurs.entrySet()){
			if(e.getKey().getId_joueur() == id_joueur)
				return e.getValue();
		}
		return 0;
	}

	/**
	 * Ajoute un joueur à la liste des joueurs
	 * @param joueur
	 */
	public void ajouterJoueur(Joueur joueur) {
		listeJoueurs.add(joueur);
	}
	
	/**
	 * Ajoute des ressources à un joueur dans la map
	 * @param joueur
	 * @param ressources
	 */
	public void ajouterMapJoueur(Joueur joueur, int ressources) {
		mapJoueurs.put(joueur, ressources);
	}
	
	/**
	 * toString() qui affiche les infos d'une partie
	 */
	public String toString() {
		String res = "";
		res = "Partie n° " + this.id_partie + ", Nom de partie : " + this.nom_partie + ", creee le : " + this.date.toString();
		return res;
	}
	
	/**
	 * Get créateur de la partie
	 * @return
	 */
	public Joueur getCreateur() {
		return createur;
	}

	/**
	 * Set créateur d'une partie
	 * @param createur
	 */
	public void setCreateur(Joueur createur) {
		this.createur = createur;
		this.notifyUpdate();
	}
	
	/**
	 * Get carte
	 * @return
	 */
	public Carte getCarte() {
		return carte;
	}

	/**
	 * Set la carte
	 * @param carte
	 */
	public void setCarte(Carte carte) {
		this.carte = carte;
		this.notifyUpdate();
	}

	/**
	 * Get l'id de la partie
	 * @return
	 */
	public int getId_partie() {
		return id_partie;
	}

	/**
	 * Set l'id de la partie
	 * @param id_partie
	 */
	public void setId_partie(int id_partie) {
		this.id_partie = id_partie;
		this.notifyUpdate();
	}

	/**
	 * Get le nom de la partie
	 * @return
	 */
	public String getNom_partie() {
		return nom_partie;
	}

	/**
	 * Set le nom de la partie
	 * @param nom_partie
	 */
	public void setNom_partie(String nom_partie) {
		this.nom_partie = nom_partie;
		this.notifyUpdate();
	}

	/**
	 * Get la date de creation
	 * @return
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Set la date de création
	 * @param date
	 */
	public void setDate(Date date) {
		this.date = date;
		this.notifyUpdate();
	}

	/**
	 * Get l'état de la partie
	 * @return
	 */
	public EtatPartie getEtat_partie() {
		return etat_partie;
	}

	/**
	 * Set l'état de la partie
	 * @param etat_partie
	 */
	public void setEtat_partie(EtatPartie etat_partie) {
		this.etat_partie = etat_partie;
		this.notifyUpdate();
	}

	/**
	 * Methode accept de notre classe Observable (dans le package game.model)
	 */
	@Override
	public void accept(Visiteur v) {
		v.visit(this);
	}

	/**
	 * Get nombre de tours
	 * @return
	 */
	public int getNb_tours() {
		return nb_tours;
	}

	/**
	 * Set nombre de tours
	 * @param nb_tours
	 */
	public void setNb_tours(int nb_tours) {
		this.nb_tours = nb_tours;
		this.notifyUpdate();
	}

	/**
	 * Get nombre de ressources par tour
	 * @return
	 */
	public int getNb_ressources_tour() {
		return nb_ressources_tour;
	}

	/**
	 * Set le nombre de ressources par tour
	 * @param nb_ressources_tour
	 */
	public void setNb_ressources_tour(int nb_ressources_tour) {
		this.nb_ressources_tour = nb_ressources_tour;
		this.notifyUpdate();
	}

	/**
	 * Get nombre de joueurs
	 * @return
	 */
	public int getNb_joueurs() {
		return nb_joueurs;
	}

	/**
	 * Set le nombre de joueurs
	 * @param nb_joueurs
	 */
	public void setNb_joueurs(int nb_joueurs) {
		this.nb_joueurs = nb_joueurs;
		this.notifyUpdate();
	}

	/**
	 * Get la liste des joueurs
	 * @return
	 */
	public List<Joueur> getListeJoueurs() {
		return listeJoueurs;
	}

	/**
	 * Set la liste des joueurs
	 * @param listeJoueurs
	 */
	public void setListeJoueurs(List<Joueur> listeJoueurs) {
		this.listeJoueurs = listeJoueurs;
	}

	/**
	 * Get la map des joueurs
	 * @return
	 */
	public Map<Joueur, Integer> getMapJoueurs() {
		return mapJoueurs;
	}

	/**
	 * Set la map des joueurs
	 * @param mapJoueurs
	 */
	public void setMapJoueurs(Map<Joueur, Integer> mapJoueurs) {
		this.mapJoueurs = mapJoueurs;
	}

	/**
	 * Get le nombre de ressources initial
	 * @return
	 */
	public int getNb_ressources_initial() {
		return nb_ressources_initial;
	}

	/**
	 * Set le nombre de ressources initial
	 * @param nb_ressources_initial
	 */
	public void setNb_ressources_initial(int nb_ressources_initial) {
		this.nb_ressources_initial = nb_ressources_initial;
	}
	
}
