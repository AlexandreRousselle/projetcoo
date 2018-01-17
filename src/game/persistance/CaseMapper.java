package game.persistance;

import java.lang.ref.WeakReference;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import game.model.map.Carte;
import game.model.map.Coordonnees;
import game.model.map.factory.CarteType;
import game.model.map.tile.Case;
import game.model.map.tile.CaseType;
import game.model.map.tile.decorator.EffetType;
import game.model.unite.Unite;

public class CaseMapper {
	//Attributes
	private static int currentId;
	private static HashMap<Integer, WeakReference<Case>> map = new HashMap<Integer, WeakReference<Case>>();

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
		ps.close();
		rs.close();
		return 1;
	}

	public void insert(List<Case> list) throws ClassNotFoundException, SQLException{
		String query = "insert into coo_case values (?,?,?,?,?,?,?)";
		PreparedStatement ps = DBconfig.getInstance().getConnection().prepareStatement(query);
		for (Case ca : list) {
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
			map.put(ca.getId_case(), new WeakReference<Case>(ca));
			System.out.println(ca.getCoordonnees().getA() + "," + ca.getCoordonnees().getB());
		}
		ps.close();
	}

	public Case findById(int id) throws SQLException, ClassNotFoundException{
		String query = "select * from coo_case where id_case = ?";
		PreparedStatement ps = DBconfig.getInstance().getConnection().prepareStatement(query);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Case c= null;
		while (rs.next()){
			c = new VirtualCase();
			c.setId_case(rs.getInt(1));
			c.setCoordonnees(new Coordonnees(rs.getInt(3),rs.getInt(4)));
			c.setBuild_on(rs.getBoolean(5));
			c.setCase_type(CaseType.valueOf(rs.getString(6)));
			c.setEffet_type(EffetType.valueOf(rs.getString(7)));
		}
		ps.close();
		rs.close();
		return c;
	}

	public List<Case> findListeCases(int id_carte) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String query = "select * from coo_case where id_carte = ? order by posX, posY";
		PreparedStatement ps = DBconfig.getInstance().getConnection().prepareStatement(query);
		ps.setInt(1, id_carte);
		ResultSet rs = ps.executeQuery();
		List<Case> lca = new ArrayList<Case>();
		while (rs.next()){
			lca.add(findById(rs.getInt(1)));
		}
		ps.close();
		rs.close();
		return lca;
	}

}
