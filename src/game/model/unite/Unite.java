package game.model.unite;

public abstract class Unite {

	private int id_unite;
	private UniteType unite_type;
	int pv;
	int degats;

	public Unite(UniteType unite_type, int pv, int degats) {
		this.unite_type = unite_type;
		this.pv = pv;
		this.degats = degats;
	}
	
	public int getId_unite() {
		return id_unite;
	}
	
	public void setId_unite(int id_unite) {
		this.id_unite = id_unite;
	}

	public UniteType getUnite_type() {
		return unite_type;
	}

	public void setUnite_type(UniteType unite_type) {
		this.unite_type = unite_type;
	}
	
	public int getPv() {
		return pv;
	}

	public void setPv(int pv) {
		this.pv = pv;
	}
	
}
