package game.model.map;

/**
 * Stocke les coordonnées d'une case
 * @author roussellea
 *
 */
public class Coordonnees {

	private int a, b;

	/**
	 * Constructeur de Coordonnees
	 * @param a
	 * @param b
	 */
	public Coordonnees(int a, int b) {
		this.a = a;
		this.b = b;
	}

	/**
	 * toString() permettant l'affichage des coordonnées sous un format
	 */
	public String toString() {
		return this.a + "," + this.b;
	}
	
	/**
	 * Get le posx
	 * @return
	 */
	public int getA() {
		return a;
	}

	/**
	 * Set le posx
	 * @param a
	 */
	public void setA(int a) {
		this.a = a;
	}
	
	/**
	 * Get le posy
	 * @return
	 */
	public int getB() {
		return b;
	}

	/**
	 * Set le posY
	 * @param b
	 */
	public void setB(int b) {
		this.b = b;
	}
	
}
