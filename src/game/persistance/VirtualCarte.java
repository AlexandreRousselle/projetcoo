package game.persistance;

import java.sql.SQLException;
import java.util.List;

import game.model.map.Carte;
import game.model.map.tile.Case;

public class VirtualCarte extends Carte {

	public VirtualCarte(){
		super();
		this.listeCases = null;
	}
	
	@Override
	public List<Case> getListeCases() {
		if(this.listeCases == null){
			try {
				this.listeCases = CaseMapper.getInstance().findListeCases(this.getId_carte());
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return this.listeCases;
	}
	
}
