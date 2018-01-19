package game.model.map.tile;

/**
 * Enumération de tous les types de cases
 * @author roussellea
 *
 */
public enum CaseType {
	PLAINE (0),
	CHAMP (1),
	MONTAGNE (2);
	
	private int value;
	
	/**
	 * Constructeur
	 * @param value
	 */
	private CaseType(int value) {
		this.value = value;
	}

	/**
	 * Get la valeur du type de case (comme un id)
	 * @return
	 */
	public int getValue() {
		return value;
	}
	
}
