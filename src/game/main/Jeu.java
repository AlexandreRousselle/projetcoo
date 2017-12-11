package game.main;

import java.util.Observable;

public class Jeu extends Observable {

	private String nom_jeu;
	private EtatJeu etat_jeu;
	
	public Jeu() {
		this.nom_jeu = "ALEXNASS_GAME";
	}
	
	public EtatJeu getEtat_jeu() {
		return etat_jeu;
	}
	
	public void setEtat_jeu(EtatJeu etat_jeu) {
		this.etat_jeu = etat_jeu;
		setChanged();
		notify();
	}

	public String getNom_jeu() {
		return nom_jeu;
	}

	public void setNom_jeu(String nom_jeu) {
		this.nom_jeu = nom_jeu;
	}

}
