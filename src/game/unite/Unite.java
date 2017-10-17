package game.unite;

public abstract class Unite {

	private int id_unite;
	private UniteType unite_type;
	
	public Unite(UniteType unite_type) {
		this.id_unite = 1;
		this.unite_type = unite_type;
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
	
}
