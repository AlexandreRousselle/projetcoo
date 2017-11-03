package game.model.unite;

import java.util.UUID;

import game.model.joueur.Joueur;
import game.model.map.Coordonnees;

public class Unite {

	protected UUID id_unite;
	protected Joueur proprietaire;
	protected UniteType unite_type;
	protected Coordonnees coordonnees;

	public Unite(UniteType unite_type, Joueur proprietaire, Coordonnees coordonnees) {
		this.id_unite = UUID.randomUUID();
		this.unite_type = unite_type;
		this.proprietaire = proprietaire;
		this.coordonnees = coordonnees;
	}

	public UUID getId_unite() {
		return id_unite;
	}

	public void setId_unite(UUID id_unite) {
		this.id_unite = id_unite;
	}

	public Joueur getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Joueur proprietaire) {
		this.proprietaire = proprietaire;
	}

	public UniteType getUnite_type() {
		return unite_type;
	}

	public void setUnite_type(UniteType unite_type) {
		this.unite_type = unite_type;
	}

	public Coordonnees getCoordonnees() {
		return coordonnees;
	}

	public void setCoordonnees(Coordonnees coordonnees) {
		this.coordonnees = coordonnees;
	}
	
}
