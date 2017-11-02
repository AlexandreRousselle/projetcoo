package game.model.joueur.buildings;

import java.util.UUID;

import game.model.joueur.Joueur;
import game.model.utils.Coordonnees;

public class Construction {
	
	protected UUID id_construction;
	protected Joueur proprietaire;
	protected ConstructionType construction_type;
	protected Coordonnees coordonnees;
	
	public Construction(ConstructionType construction_type, Joueur joueur, Coordonnees coordonnees) {
		this.id_construction = UUID.randomUUID();
		this.construction_type = construction_type;
		this.proprietaire = joueur;
		this.coordonnees = coordonnees;
	}
	
	public Joueur getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Joueur proprietaire) {
		this.proprietaire = proprietaire;
	}

	public UUID getId_construction() {
		return id_construction;
	}

	public void setId_construction(UUID id_construction) {
		this.id_construction = id_construction;
	}

	public Coordonnees getCoordonnees() {
		return coordonnees;
	}

	public void setCoordonnees(Coordonnees coordonnees) {
		this.coordonnees = coordonnees;
	}

	public ConstructionType getConstruction_type() {
		return construction_type;
	}

	public void setConstruction_type(ConstructionType construction_type) {
		this.construction_type = construction_type;
	}

	public String toString() {
		return this.construction_type.toString() + " n°" + this.id_construction + ", PV : " + this.getConstruction_type().getPv()
				+ ", Coord : " + this.coordonnees.getA() + ", " + this.coordonnees.getB() + ", Prop : " + this.proprietaire.getNom_joueur();
	}
	
}
