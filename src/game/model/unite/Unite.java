package game.model.unite;


import game.model.joueur.Joueur;

public class Unite {

	protected int id_unite;
	protected Joueur proprietaire;
	protected UniteType unite_type;
	protected int id_case;

	public Unite(int id_unite, UniteType unite_type, Joueur proprietaire, int id_case) {
		this.id_unite = id_unite;
		this.unite_type = unite_type;
		this.proprietaire = proprietaire;
		this.id_case = id_case;
	}
	
	public Unite(UniteType unite_type, Joueur proprietaire, int id_case) {
		this.unite_type = unite_type;
		this.proprietaire = proprietaire;
		this.id_case = id_case;
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

	public int getId_case() {
		return id_case;
	}

	public void setId_case(int id_case) {
		this.id_case = id_case;
	}

	@Override
	public String toString() {
		if (this.getUnite_type().equals(UniteType.VILLE)) {
			return "Unite de " + this.getProprietaire().getPseudo() + ", " + this.getUnite_type().toString()
					+ ", PV : " + this.getUnite_type().getPv() + ", PDef : " + this.getUnite_type().getPdefense();
		}
		return "Unite de " + this.getProprietaire().getPseudo() + ", " + this.getUnite_type().toString()
				+ ", PV : " + this.getUnite_type().getPv() + ", PDef : " + this.getUnite_type().getPdefense()
				+ ", PAtt : " + this.getUnite_type().getPattaque();
	}

}
