package game.model.map.factory;

public enum CarteType {
	FERMIERE (35,50,15),
	MONTAGNEUSE (15,50,35);
	
	private int nbChamps;
	private int nbPlaines;
	private int nbMontagnes;
	
	private CarteType(int nbChamps, int nbPlaines, int nbMontagnes) {
		this.nbChamps = nbChamps;
		this.nbPlaines = nbPlaines;
		this.nbMontagnes = nbMontagnes;
	}
	
	public int getNbChamps() {
		return this.nbChamps;
	}
	
	public int getNbPlaines() {
		return this.nbPlaines;
	}
	
	public int getNbMontagnes() {
		return this.nbMontagnes;
	}
	
}
