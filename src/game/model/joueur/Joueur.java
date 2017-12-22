package game.model.joueur;

import game.model.Observable;
import game.model.Visiteur;
import game.model.partie.Partie;
import game.model.unite.Unite;
import game.persistance.UnitOfWorks;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Joueur extends Observable {

	protected int id_joueur;
	protected String pseudo;
	protected String mdp;
	protected int ressources;
	protected List<Partie> listeParties;
	protected List<Unite> listeUnites;
	
	public Joueur(int id_joueur, String pseudo, String mdp) {
		this.id_joueur = id_joueur;
		this.pseudo = pseudo;
		this.mdp = mdp;
		this.listeParties = new ArrayList<Partie>();
		this.listeUnites = new ArrayList<Unite>();
	}
	
	public Joueur(){
		
	}
	
	public void addPartie(Partie p) {
		this.listeParties.add(p);
	}	
	
	public void addUnite(Unite u) {
		this.listeUnites.add(u);
	}	
	
	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
		notifyUpdate();
	}
	
	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
		notifyUpdate();
	}
	
	public int getId_joueur() {
		return id_joueur;
	}

	public void setId_joueur(int id_joueur) {
		this.id_joueur = id_joueur;
		notifyUpdate();
	}
	
	public int getRessources() {
		return ressources;
	}

	public void setRessources(int ressources) {
		this.ressources = ressources;
		notifyUpdate();
	}

	public List<Unite> getListeUnites() {
		return listeUnites;
	}

	public void setListUnites(List<Unite> listeUnites) {
		this.listeUnites = listeUnites;
	}

	public List<Partie> getListeParties() {
		return listeParties;
	}

	public void setListParties(List<Partie> listeParties) {
		this.listeParties = listeParties;
	}
	
	@Override
	public void accept(Visiteur v) {
		v.visit(this);
	}
}
