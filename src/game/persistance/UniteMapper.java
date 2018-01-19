package game.persistance;

import java.lang.ref.WeakReference;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import game.model.unite.Unite;
import game.model.unite.UniteType;

public class UniteMapper {
	
	private static int currentId;
	private static HashMap<Integer, WeakReference<Unite>> map = new HashMap<Integer, WeakReference<Unite>>();

	private static UniteMapper instance;

	//Constructor
	public UniteMapper() throws ClassNotFoundException, SQLException{
		currentId = this.getCurrentId();
	}

	//Methods
	public static UniteMapper getInstance() throws ClassNotFoundException, SQLException{
		if (instance == null)
			instance = new UniteMapper();
		return instance;
	}

	public int getCurrentId() throws ClassNotFoundException, SQLException{
		String query = "select max(id_unite) from coo_unite";
		PreparedStatement ps = DBconfig.getInstance().getConnection().prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			return rs.getInt(1)+1;
		}
		ps.close();
		rs.close();
		return 1;
	}

	public void insert(Unite u) throws ClassNotFoundException, SQLException{
		String query = "insert into coo_unite values (?,?,?,?)";
		PreparedStatement ps = DBconfig.getInstance().getConnection().prepareStatement(query);
		u.setId_unite(currentId);
		currentId++;
		ps.setInt(1, u.getId_unite());
		ps.setInt(2, u.getProprietaire().getId_joueur());
		ps.setInt(3, u.getId_case());
		ps.setString(4, u.getUnite_type().toString());
		ps.executeUpdate();
		map.put(u.getId_unite(), new WeakReference<Unite>(u));
		ps.close();
	}
	
	public List<Unite> findByIdCase(int id_case) throws ClassNotFoundException, SQLException {
		String query = "select id_unite, id_joueur, type_unite from coo_unite where id_case = ?";
		PreparedStatement ps = DBconfig.getInstance().getConnection().prepareStatement(query);
		ps.setInt(1, id_case);
		ResultSet rs = ps.executeQuery();
		Unite u = null;
		int id_unite, id_joueur;
		String type_unite;
		List<Unite> listUnites = new ArrayList<Unite>();
		while (rs.next()){
			id_unite = rs.getInt(1);
			id_joueur = rs.getInt(2);
			type_unite = rs.getString(3);
			u = new Unite(id_unite
					, UniteType.valueOf(type_unite)
					, JoueurMapper.getInstance().findById(id_joueur)
					, id_case);
			listUnites.add(u);
		}
		ps.close();
		rs.close();
		return listUnites;
	}

	public void update(Unite u) {
		// TODO Auto-generated method stub
	}

}
