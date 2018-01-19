package game.model.joueur;

import game.model.Observable;
import game.model.Visiteur;
import game.model.partie.Partie;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe Joueur Observable par l'UnitOfWork
 * qui permet de stocker les joueurs du jeu, leurs listes de parties etc..
 * @author roussellea
 *
 */
public class Joueur extends Observable {

	protected int id_joueur;
	protected String pseudo;
	protected String mdp;
	protected List<Partie> listeParties;
	
	/**
	 * Contructeur
	 * @param id_joueur
	 * @param pseudo
	 * @param mdp
	 */
	public Joueur(int id_joueur, String pseudo, String mdp) {
		this.id_joueur = id_joueur;
		this.pseudo = pseudo;
		this.mdp = mdp;
		this.listeParties = new ArrayList<Partie>();
	}
	
	/**
	 * Constructeur vide
	 */
	public Joueur(){
		
	}
	
	/**
	 * Ajoute un partie à un joueur
	 * @param p
	 */
	public void addPartie(Partie p) {
		this.listeParties.add(p);
	}	
	
	/**
	 * Get le pseudo
	 * @return
	 */
	public String getPseudo() {
		return pseudo;
	}

	/**
	 * Set le pseudo
	 * @param pseudo
	 */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
		notifyUpdate();
	}
	
	/**
	 * Get le mot de passe
	 * @return
	 */
	public String getMdp() {
		return mdp;
	}

	/**
	 * Set le mot de passe
	 * @param mdp
	 */
	public void setMdp(String mdp) {
		this.mdp = mdp;
		notifyUpdate();
	}
	
	/**
	 * Get l'id du joueur
	 * @return
	 */
	public int getId_joueur() {
		return id_joueur;
	}

	/**
	 * Set l'id du joueur
	 * @param id_joueur
	 */
	public void setId_joueur(int id_joueur) {
		this.id_joueur = id_joueur;
		notifyUpdate();
	}

	/**
	 * Get liste des parties
	 * @return
	 */
	public List<Partie> getListeParties() {
		return listeParties;
	}

	/**
	 * Set la liste des parties
	 * @param listeParties
	 */
	public void setListParties(List<Partie> listeParties) {
		this.listeParties = listeParties;
	}
	
	/**
	 * Methode accept de notre classe Observable (dans le package game.model)
	 */
	@Override
	public void accept(Visiteur v) {
		v.visit(this);
	}
}
