package game.utils;

public class Coordonnees {

	private int a, b;
	
	public Coordonnees(int a, int b) {
		this.a = a;
		this.b = b;
	}

	public String toString() {
		return this.a + "," + this.b;
	}
	
	public double getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}
	
	public double getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}
	
}
