package game.model.map.factory;

public enum CarteType {
	FERMIERE (20,5,5),
	FORESTIERE (5,20,5),
	MONTAGNEUSE (5,5,20);
	
	private int nbChamps;
	private int nbForets;
	private int nbMontagnes;
	
	private CarteType(int nbChamps, int nbForets, int nbMontagnes) {
		this.nbChamps = nbChamps;
		this.nbForets = nbForets;
		this.nbMontagnes = nbMontagnes;
	}
	
	public int getNbChamps() {
		return this.nbChamps;
	}
	
	public int getNbForets() {
		return this.nbForets;
	}
	
	public int getNbMontagnes() {
		return this.nbMontagnes;
	}
	
}
