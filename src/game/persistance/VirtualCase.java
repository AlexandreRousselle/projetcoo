package game.persistance;

import java.sql.SQLException;
import java.util.List;

import game.model.map.tile.Case;
import game.model.unite.Unite;

public class VirtualCase extends Case {
	
	public VirtualCase(){
		super();
		this.unite = null;
	}
	
	@Override
	public List<Unite> getUnite() {
		if (this.unite == null){
			try {
				this.unite = UniteMapper.getInstance().findByIdCase(this.getId_case());
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return this.unite;
	}
}
