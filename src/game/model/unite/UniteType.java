package game.model.unite;

public enum UniteType {
	VILLE (1000, 0, 200),
	FORT (500, 0, 300),
	ARMEE (500, 100, 50);
	
	private int pv;
	private int pattaque;
	private int pdefense;
	
	private UniteType(int pv, int pattaque, int pdefense) {
		this.pv = pv;
		this.pattaque = pattaque;
		this.pdefense = pdefense;
	}
	
	public int getPv() {
		return this.pv;
	}
	
	public int getPattaque() {
		return this.pattaque;
	}
	
	public int getPdefense() {
		return this.pdefense;
	}
	
}
