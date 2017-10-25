package game.model.joueur.buildings;

import game.model.utils.Coordonnees;

public class Construction {
	
	protected int id_construction;
	protected ConstructionType construction_type;
	protected int pv;
	protected Coordonnees coordonnees;
	
	public Construction(ConstructionType construction_type, int pv, int posX, int posY) {
		this.construction_type = construction_type;
		this.pv = pv;
	}
	
	public int getId_construction() {
		return id_construction;
	}

	public void setId_construction(int id_construction) {
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

	public int getPv() {
		return pv;
	}

	public void setPv(int pv) {
		this.pv = pv;
	}

	public String toString() {
		return this.construction_type.toString() + " n°" + this.id_construction + ", PV : " + this.pv;
	}
	
}
