package game.model;

import java.util.ArrayList;
import java.util.List;

import game.model.partie.Partie;

public class User extends Observable {

	protected int id_user;
	protected String pseudo;
	protected String mdp;

	protected List<Partie> listeParties;
	
	public User() {
		this.listeParties = new ArrayList<Partie>();
	}
	
	public void addPartie(Partie p) {
		this.listeParties.add(p);
	}
	
	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public List<Partie> getListeParties() {
		return listeParties;
	}

	public void setListeParties(List<Partie> listeParties) {
		this.listeParties = listeParties;
	}

	@Override
	public void accept(Visiteur v) {
		v.visit(this);
	}
	
}
