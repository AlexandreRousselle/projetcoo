package game.model.unite;


import game.model.joueur.Joueur;

/**
 * Classe Unite qui stocke les infos d'une unité
 * @author roussellea
 *
 */
public class Unite {

	protected int id_unite;
	protected Joueur proprietaire;
	protected UniteType unite_type;
	protected int id_case;

	/**
	 * Constructeur
	 * @param id_unite
	 * @param unite_type
	 * @param proprietaire
	 * @param id_case
	 */
	public Unite(int id_unite, UniteType unite_type, Joueur proprietaire, int id_case) {
		this.id_unite = id_unite;
		this.unite_type = unite_type;
		this.proprietaire = proprietaire;
		this.id_case = id_case;
	}
	
	/**
	 * Constructeur 2
	 * @param unite_type
	 * @param proprietaire
	 * @param id_case
	 */
	public Unite(UniteType unite_type, Joueur proprietaire, int id_case) {
		this.unite_type = unite_type;
		this.proprietaire = proprietaire;
		this.id_case = id_case;
	}

	/**
	 * Get l'id d'une unité
	 * @return
	 */
	public int getId_unite() {
		return id_unite;
	}

	/**
	 * Set l'id d'une unité
	 * @param id_unite
	 */
	public void setId_unite(int id_unite) {
		this.id_unite = id_unite;
	}

	/**
	 * Get le propriétaire
	 * @return
	 */
	public Joueur getProprietaire() {
		return proprietaire;
	}

	/**
	 * Set le propriétaire
	 * @param proprietaire
	 */
	public void setProprietaire(Joueur proprietaire) {
		this.proprietaire = proprietaire;
	}

	/**
	 * Get le type de l'unité
	 * @return
	 */
	public UniteType getUnite_type() {
		return unite_type;
	}

	/**
	 * Set le type de l'unité
	 * @param unite_type
	 */
	public void setUnite_type(UniteType unite_type) {
		this.unite_type = unite_type;
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
	 * toString() qui modélise une unité
	 */
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
