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

public class Jeu extends Observable {

	private String nom_jeu;
	private EtatJeu etat_jeu;
	private Joueur current_joueur;
	private Partie current_partie;
	private Map<String, File> files;
	private static Jeu instance;
	
	public Jeu() {
		this.nom_jeu = "ALEXNASS_GAME";
		this.files = new HashMap<String, File>();
		this.loadFiles();
	}
	
	public void loadFiles(){
		this.files.put("fond_login", new File("ressources/auth_bg.png"));
		this.files.put("fond", new File("ressources/bg.png"));
		this.files.put("splash_screen", new File("ressources/splash_screen.png"));
	}
	
	public void setEtat_partie(EtatPartie ep){
		this.current_partie.setEtat_partie(ep);
	}
	
	public void addListeJoueursToPartie(List<Joueur> l) {
		this.current_partie.setListeJoueurs(l);
	}
	
	public void addPartieToJoueur(Partie p) {
		this.current_joueur.addPartie(p);
	}
	
	public EtatJeu getEtat_jeu() {
		return etat_jeu;
	}
	
	public void setEtat_jeu(EtatJeu etat_jeu) {
		this.etat_jeu = etat_jeu;
		setChanged();
		notifyObservers(etat_jeu);
	}

	public String getNom_jeu() {
		return nom_jeu;
	}

	public void setNom_jeu(String nom_jeu) {
		this.nom_jeu = nom_jeu;
	}

	public static Jeu getInstance() {
		if (instance == null)
			instance = new Jeu();
		return instance;
	}
	
	public File getFileByKey(String key) {
		for (Map.Entry<String, File> e : this.files.entrySet()) {
			if(e.getKey().equals(key)){
				return e.getValue();
			}
		}
		return null;
	}

	public Map<String, File> getFiles() {
		return files;
	}

	public void setFiles(Map<String, File> files) {
		this.files = files;
	}

	public Joueur getCurrent_joueur() {
		return current_joueur;
	}

	public void setCurrent_joueur(Joueur current_joueur) {
		this.current_joueur = current_joueur;
	}

	public Partie getCurrent_partie() {
		return current_partie;
	}

	public void setCurrent_partie(Partie current_partie) {
		this.current_partie = current_partie;
	}

}
