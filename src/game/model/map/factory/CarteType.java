package game.model.map.factory;

public enum CarteType {
	FERMIERE (70,15,15),
	FORESTIERE (15,70,15),
	MONTAGNEUSE (15,15,70);
	
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
