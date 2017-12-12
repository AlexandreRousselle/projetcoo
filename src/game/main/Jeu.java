package game.main;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class Jeu extends Observable {

	private String nom_jeu;
	private EtatJeu etat_jeu;
	private Map<String, File> files;
	private static Jeu instance;
	
	public Jeu() {
		this.nom_jeu = "ALEXNASS_GAME";
		this.files = new HashMap<String, File>();
		this.files.put("fond", new File("ressources/fonds/general.jpg"));
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

}
