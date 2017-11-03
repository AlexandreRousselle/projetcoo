package game.model.map.tile;

import java.util.UUID;

import game.model.map.Carte;
import game.model.map.Coordonnees;
import game.model.map.tile.decorator.EffetType;
import game.model.unite.Unite;

public class Case {

	private UUID id_case;
	private Carte carte;
	private Coordonnees coordonnees;
	private CaseAccessibilite case_access;
	private CaseType case_type;
	private Unite unite;
	private EffetType effet_type;
	
	public Case(Carte carte, Coordonnees coordonnees, CaseAccessibilite case_access, CaseType case_type) {
		this.id_case = UUID.randomUUID();
		this.carte = carte;
		this.coordonnees = coordonnees;
		this.case_access = case_access;
		this.case_type = case_type;
		this.effet_type = EffetType.DEFAULT;
	}
	
	public void retirerEffet() {
		this.setEffet_type(EffetType.DEFAULT);
	}

	public CaseAccessibilite getCase_access() {
		return case_access;
	}

	public void setCase_access(CaseAccessibilite case_access) {
		this.case_access = case_access;
	}

	public CaseType getCase_type() {
		return case_type;
	}

	public void setCase_type(CaseType case_type) {
		this.case_type = case_type;
	}

	public EffetType getEffet_type() {
		return effet_type;
	}

	public void setEffet_type(EffetType effet_type) {
		this.effet_type = effet_type;
	}
	
	public String getLibelle() {
		return "Case " + this.case_access.toString() + " de type " + this.case_type.toString() 
			+ " (" + this.coordonnees.getA() + ", " + this.coordonnees.getB() + ") ";
	}

	public Coordonnees getCoordonnees() {
		return coordonnees;
	}

	public void setCoordonnees(Coordonnees coordonnees) {
		this.coordonnees = coordonnees;
	}

	public Unite getUnite() {
		return unite;
	}

	public void setUnite(Unite unite) {
		this.unite = unite;
	}

	public Carte getCarte() {
		return carte;
	}

	public void setCarte(Carte carte) {
		this.carte = carte;
	}

	public UUID getId_case() {
		return id_case;
	}

	public void setId_case(UUID id_case) {
		this.id_case = id_case;
	}

}
