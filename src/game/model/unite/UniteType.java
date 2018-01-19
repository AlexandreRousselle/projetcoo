package game.model.unite;

/**
 * Enumérationde tous les types d'unités
 * @author roussellea
 *
 */
public enum UniteType {
	VILLE (1000, 0, 200),
	FORT (500, 0, 300),
	ARMEE (500, 100, 50);
	
	private int pv;
	private int pattaque;
	private int pdefense;
	
	/**
	 * Constructeur
	 * @param pv
	 * @param pattaque
	 * @param pdefense
	 */
	private UniteType(int pv, int pattaque, int pdefense) {
		this.pv = pv;
		this.pattaque = pattaque;
		this.pdefense = pdefense;
	}
	
	/**
	 * Get PV
	 * @return
	 */
	public int getPv() {
		return this.pv;
	}
	
	/**
	 * Get Points attaque
	 * @return
	 */
	public int getPattaque() {
		return this.pattaque;
	}
	
	/**
	 * Get Points défense
	 * @return
	 */
	public int getPdefense() {
		return this.pdefense;
	}
	
}
