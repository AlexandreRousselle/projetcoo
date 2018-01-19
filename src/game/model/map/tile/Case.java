package game.model.map.tile;

import java.util.ArrayList;
import java.util.List;

import game.model.map.Carte;
import game.model.map.Coordonnees;
import game.model.map.tile.decorator.EffetType;
import game.model.unite.Unite;

/**
 * Classe Case qui stocke les informations d'une case
 * @author roussellea
 *
 */
public class Case {

	private int id_case;
	private Carte carte;
	private Coordonnees coordonnees;
	private Boolean build_on;
	private CaseType case_type;
	protected List<Unite> unite;
	private EffetType effet_type;
	
	/**
	 * Constructeur Case
	 * @param carte
	 * @param coordonnees
	 * @param build_on
	 * @param case_type
	 */
	public Case(Carte carte, Coordonnees coordonnees, Boolean build_on, CaseType case_type) {
		this.carte = carte;
		this.setBuild_on(build_on);
		this.coordonnees = coordonnees;
		this.case_type = case_type;
		this.effet_type = EffetType.DEFAULT;
		this.unite = new ArrayList<Unite>();
	}
	/**
	 * Constructeur vide
	 */
	public Case() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * retire l'effet d'une case
	 */
	public void retirerEffet() {
		this.setEffet_type(EffetType.DEFAULT);
	}

	/**
	 * Get le type de case
	 * @return
	 */
	public CaseType getCase_type() {
		return case_type;
	}

	/**
	 * Set le type de case
	 * @param case_type
	 */
	public void setCase_type(CaseType case_type) {
		this.case_type = case_type;
	}

	/**
	 * Get l'effet d'une case
	 * @return
	 */
	public EffetType getEffet_type() {
		return effet_type;
	}

	/**
	 * Set l'effet d'une case
	 * @param effet_type
	 */
	public void setEffet_type(EffetType effet_type) {
		this.effet_type = effet_type;
	}
	
	/**
	 * Une sorte de toString() qui retourne un libellé de Case
	 * @return
	 */
	public String getLibelle() {
		return "Case " + this.build_on.toString() + " de type " + this.case_type.toString() 
			+ " (" + this.coordonnees.getA() + ", " + this.coordonnees.getB() + ") ";
	}

	/**
	 * Get les coordonnées
	 * @return
	 */
	public Coordonnees getCoordonnees() {
		return coordonnees;
	}

	/**
	 * Set les coordonnées
	 * @param coordonnees
	 */
	public void setCoordonnees(Coordonnees coordonnees) {
		this.coordonnees = coordonnees;
	}

	/**
	 * Get les unités présentes sur la case
	 * @return
	 */
	public List<Unite> getUnite() {
		return unite;
	}

	/**
	 * Set la liste des unités de la case
	 * @param unite
	 */
	public void setUnite(List<Unite> unite) {
		this.unite = unite;
	}

	/**
	 * Get la carte
	 * @return
	 */
	public Carte getCarte() {
		return carte;
	}

	/**
	 * Set la carte
	 * @param carte
	 */
	public void setCarte(Carte carte) {
		this.carte = carte;
	}

	/**
	 * Get l'id de la case
	 * @return
	 */
	public int getId_case() {
		return id_case;
	}

	/**
	 * Set l'id de la case
	 * @param id_case
	 */
	public void setId_case(int id_case) {
		this.id_case = id_case;
	}

	/**
	 * Get si on peut construire ou pas (true ou false)
	 * @return
	 */
	public Boolean getBuild_on() {
		return build_on;
	}

	/**
	 * Set un booléen true pour pouvoir contruire ou false non
	 * @param build_on
	 */
	public void setBuild_on(Boolean build_on) {
		this.build_on = build_on;
	}

}
