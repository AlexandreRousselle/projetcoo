package game.persistance;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import game.model.map.Carte;
import game.model.map.tile.Case;

public class CaseMapper {
	//Attributes
	private static int currentId;
	private static HashMap<Integer, Case> map = new HashMap<Integer, Case>();

	private static CaseMapper instance;

	//Constructor
	public CaseMapper() throws ClassNotFoundException, SQLException{
		currentId = this.getCurrentId();
	}

	//Methods
	public static CaseMapper getInstance() throws ClassNotFoundException, SQLException{
		if (instance == null)
			instance = new CaseMapper();
		return instance;
	}

	public int getCurrentId() throws ClassNotFoundException, SQLException{
		String query = "select max(id_case) from coo_case";
		PreparedStatement ps = DBconfig.getInstance().getConnection().prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			return rs.getInt(1)+1;
		}
		return 1;
	}

	public void insert(List<Case> lca) throws ClassNotFoundException, SQLException{
		String query = "insert into coo_case values (?,?,?,?,?,?,?)";
		PreparedStatement ps = DBconfig.getInstance().getConnection().prepareStatement(query);
		for (Case ca : lca) {
			ca.setId_case(currentId);
			currentId++;
			ps.setInt(1, ca.getId_case());
			ps.setInt(2, ca.getCarte().getId_carte());
			ps.setInt(3, ca.getCoordonnees().getA());
			ps.setInt(4, ca.getCoordonnees().getB());
			ps.setBoolean(5, ca.getBuild_on());
			ps.setString(6, ca.getCase_type().toString());
			ps.setString(7, ca.getEffet_type().toString());
			ps.executeUpdate();
			map.put(ca.getId_case(), ca);
		}
	}

	public Case findById(int id) throws SQLException, ClassNotFoundException{
		return null;
	}
}
