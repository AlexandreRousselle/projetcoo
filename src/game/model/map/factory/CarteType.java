package game.model.map.factory;

/**
 * Enumération de tous les types de carte
 * @author roussellea
 *
 */
public enum CarteType {
	FERMIERE (35,50,15),
	MONTAGNEUSE (15,50,35);
	
	private int nbChamps;
	private int nbPlaines;
	private int nbMontagnes;
	
	/**
	 * Constructeur
	 * @param nbChamps
	 * @param nbPlaines
	 * @param nbMontagnes
	 */
	private CarteType(int nbChamps, int nbPlaines, int nbMontagnes) {
		this.nbChamps = nbChamps;
		this.nbPlaines = nbPlaines;
		this.nbMontagnes = nbMontagnes;
	}
	
	/**
	 * Get pourcentage de champs
	 * @return
	 */
	public int getNbChamps() {
		return this.nbChamps;
	}
	
	/**
	 * Get pourcentage de plaines
	 * @return
	 */
	public int getNbPlaines() {
		return this.nbPlaines;
	}
	
	/**
	 * get pourcentage de montagnes
	 * @return
	 */
	public int getNbMontagnes() {
		return this.nbMontagnes;
	}
	
}
