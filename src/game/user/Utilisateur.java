package game.user;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import game.model.partie.Partie;

public class Utilisateur {

	protected UUID id_utilisateur;
	protected String pseudo;
	protected String mdp;
	protected List<Partie> listeParties;
	
	public Utilisateur(String pseudo, String mdp) {
		this.id_utilisateur = UUID.randomUUID();
		this.pseudo = pseudo;
		this.listeParties = new ArrayList<Partie>();
	}
	
	public List<Partie> getListeParties() {
		return listeParties;
	}

	public void setListeParties(List<Partie> listeParties) {
		this.listeParties = listeParties;
	}

	public UUID getId_utilisateur() {
		return id_utilisateur;
	}

	public void setId_utilisateur(UUID id_utilisateur) {
		this.id_utilisateur = id_utilisateur;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	
	
}
