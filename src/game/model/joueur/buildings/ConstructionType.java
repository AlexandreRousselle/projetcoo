package game.model.joueur.buildings;

public enum ConstructionType {
	VILLE (1000),
	FORT (500);
	
	private int pv;
	
	private ConstructionType(int pv) {
		this.pv = pv;
	}
	
	public int getPv() {
		return this.pv;
	}
	
}
