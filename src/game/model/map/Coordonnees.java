package game.model.map;

public class Coordonnees {

	private int a, b;
	
	public Coordonnees(int a, int b) {
		this.a = a;
		this.b = b;
	}

	public String toString() {
		return this.a + "," + this.b;
	}
	
	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}
	
	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}
	
}