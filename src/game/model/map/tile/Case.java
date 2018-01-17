package game.model.map.tile;

import java.util.ArrayList;
import java.util.List;

import game.model.map.Carte;
import game.model.map.Coordonnees;
import game.model.map.tile.decorator.EffetType;
import game.model.unite.Unite;

public class Case {

	private int id_case;
	private Carte carte;
	private Coordonnees coordonnees;
	private Boolean build_on;
	private CaseType case_type;
	protected List<Unite> unite;
	private EffetType effet_type;
	
	public Case(Carte carte, Coordonnees coordonnees, Boolean build_on, CaseType case_type) {
		this.carte = carte;
		this.setBuild_on(build_on);
		this.coordonnees = coordonnees;
		this.case_type = case_type;
		this.effet_type = EffetType.DEFAULT;
		this.unite = new ArrayList<Unite>();
	}
	
	public Case() {
		// TODO Auto-generated constructor stub
	}

	public void retirerEffet() {
		this.setEffet_type(EffetType.DEFAULT);
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
		return "Case " + this.build_on.toString() + " de type " + this.case_type.toString() 
			+ " (" + this.coordonnees.getA() + ", " + this.coordonnees.getB() + ") ";
	}

	public Coordonnees getCoordonnees() {
		return coordonnees;
	}

	public void setCoordonnees(Coordonnees coordonnees) {
		this.coordonnees = coordonnees;
	}

	public List<Unite> getUnite() {
		return unite;
	}

	public void setUnite(List<Unite> unite) {
		this.unite = unite;
	}

	public Carte getCarte() {
		return carte;
	}

	public void setCarte(Carte carte) {
		this.carte = carte;
	}

	public int getId_case() {
		return id_case;
	}

	public void setId_case(int id_case) {
		this.id_case = id_case;
	}

	public Boolean getBuild_on() {
		return build_on;
	}

	public void setBuild_on(Boolean build_on) {
		this.build_on = build_on;
	}

}
