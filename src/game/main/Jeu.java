package game.main;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;

import game.model.User;
import game.model.joueur.Joueur;
import game.model.partie.Partie;

public class Jeu extends Observable {

	private String nom_jeu;
	private EtatJeu etat_jeu;
	private User current_user;
	private Partie current_partie;
	private Map<String, File> files;
	private static Jeu instance;
	
	public Jeu() {
		this.nom_jeu = "ALEXNASS_GAME";
		this.files = new HashMap<String, File>();
		this.files.put("fond", new File("ressources/fonds/general.jpg"));
	}
	
	public void addListeJoueursToPartie(List<Joueur> l) {
		this.current_partie.setListeJoueurs(l);
	}
	
	public void addPartieToUser(Partie p) {
		this.current_user.addPartie(p);
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

	public User getCurrent_user() {
		return current_user;
	}

	public void setCurrent_user(User current_user) {
		this.current_user = current_user;
	}

	public Partie getCurrent_partie() {
		return current_partie;
	}

	public void setCurrent_partie(Partie current_partie) {
		this.current_partie = current_partie;
	}

}
