package game.unite;

import java.util.ArrayList;
import java.util.List;

public class Armee extends Unite {

	private List<Unite> listeUnites;
	
	public Armee() {
		super(UniteType.ARMEE);
		this.listeUnites = new ArrayList<Unite>();
	}
	
	public void ajouterUnite(Unite unite) {
		this.listeUnites.add(unite);
	}
	
	public void retirerUnite(Unite unite) {
		this.listeUnites.remove(unite);
	}

	public List<Unite> getListeUnites() {
		return listeUnites;
	}

	public void setListeUnites(List<Unite> listeUnites) {
		this.listeUnites = listeUnites;
	}
	
}
