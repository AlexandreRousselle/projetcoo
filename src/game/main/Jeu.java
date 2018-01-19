package game.main;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;

import game.model.joueur.Joueur;
import game.model.partie.EtatPartie;
import game.model.partie.Partie;

/**
 * Classe Jeu en singleton qui est en background de l'application et qui va garder
 * toutes les informations pour gérer les menus du jeu, les parties etc..
 * Un des classes les plus importantes
 * Elle est observable par JeuView.java
 * @author roussellea
 *
 */
public class Jeu extends Observable {

	private String nom_jeu;
	private EtatJeu etat_jeu;
	private Joueur current_joueur;
	private Partie current_partie;
	private Map<String, File> files;
	private static Jeu instance;
	
	/**
	 * Constructeur Jeu qui set le nom du jeu et la liste des fichiers
	 * et charge les fichiers
	 */
	public Jeu() {
		this.nom_jeu = "ALEXNASS_GAME";
		this.files = new HashMap<String, File>();
		this.loadFiles();
	}
	
	/**
	 * Charge les fichiers au lancement
	 */
	public void loadFiles(){
		this.files.put("fond_login", new File("ressources/auth_bg.png"));
		this.files.put("fond", new File("ressources/bg.png"));
		this.files.put("splash_screen", new File("ressources/splash_screen.png"));
		this.files.put("ville", new File("ressources/pixel_tower.png"));
	}
	
	/**
	 * Set l'etat de la partie du Jeu
	 * @param ep
	 */
	public void setEtat_partie(EtatPartie ep){
		this.current_partie.setEtat_partie(ep);
	}
	
	/**
	 * Ajoute la liste de joueurs à la partie
	 * @param l
	 */
	public void addListeJoueursToPartie(List<Joueur> l) {
		this.current_partie.setListeJoueurs(l);
	}
	
	/**
	 * Ajoute
	 * @param p
	 */
	public void addPartieToJoueur(Partie p) {
		this.current_joueur.addPartie(p);
	}
	
	/**
	 * Get l'etat de la partie du jeu
	 */
	public EtatJeu getEtat_jeu() {
		return etat_jeu;
	}
	
	/**
	 * Set l'etat du jeu
	 * @param etat_jeu
	 */
	public void setEtat_jeu(EtatJeu etat_jeu) {
		this.etat_jeu = etat_jeu;
		setChanged();
		notifyObservers(etat_jeu);
	}

	/**
	 * Get le nom du jeu
	 * @return
	 */
	public String getNom_jeu() {
		return nom_jeu;
	}

	/**
	 * Set le nom du jeu
	 * @param nom_jeu
	 */
	public void setNom_jeu(String nom_jeu) {
		this.nom_jeu = nom_jeu;
	}

	/**
	 * Retourne l'instance créé ou non qui est en parametre de la classe
	 * SINGLETON
	 * @return
	 */
	public static Jeu getInstance() {
		if (instance == null)
			instance = new Jeu();
		return instance;
	}
	
	/**
	 * Get fichiers en fonction d'une clé existante de la map
	 * @param key
	 * @return
	 */
	public File getFileByKey(String key) {
		for (Map.Entry<String, File> e : this.files.entrySet()) {
			if(e.getKey().equals(key)){
				return e.getValue();
			}
		}
		return null;
	}

	/**
	 * Get la map de fichiers
	 * @return
	 */
	public Map<String, File> getFiles() {
		return files;
	}

	/**
	 * Set la map de fichiers
	 * @param files
	 */
	public void setFiles(Map<String, File> files) {
		this.files = files;
	}

	/**
	 * Get le joueur courant
	 * @return
	 */
	public Joueur getCurrent_joueur() {
		return current_joueur;
	}

	/**
	 * Set le joueur courant
	 * @param current_joueur
	 */
	public void setCurrent_joueur(Joueur current_joueur) {
		this.current_joueur = current_joueur;
	}

	/**
	 * Get la partie courante
	 * @return
	 */
	public Partie getCurrent_partie() {
		return current_partie;
	}

	/**
	 * Set la partie courante
	 * @param current_partie
	 */
	public void setCurrent_partie(Partie current_partie) {
		this.current_partie = current_partie;
	}

}
