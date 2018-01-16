package game.model.unite;


import game.model.joueur.Joueur;
import game.model.map.tile.Case;

public class Unite {

	protected int id_unite;
	protected Joueur proprietaire;
	protected UniteType unite_type;
	protected Case case_;

	public Unite(int id_unite, UniteType unite_type, Joueur proprietaire, Case case_) {
		this.id_unite = id_unite;
		this.unite_type = unite_type;
		this.proprietaire = proprietaire;
		this.case_ = case_;
	}
	
	public Unite(UniteType unite_type, Joueur proprietaire, Case case_) {
		this.unite_type = unite_type;
		this.proprietaire = proprietaire;
		this.case_ = case_;
	}

	public int getId_unite() {
		return id_unite;
	}

	public void setId_unite(int id_unite) {
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

	public Case getCase_() {
		return case_;
	}

	public void setCase_(Case case_) {
		this.case_ = case_;
	}
	
	@Override
	public String toString() {
		return "Unite de : " + this.getProprietaire().getId_joueur() + " - " + this.getUnite_type().toString()
				+ " - " + this.getUnite_type().getPv();
	}

}
