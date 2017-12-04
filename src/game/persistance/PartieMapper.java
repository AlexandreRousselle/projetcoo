package game.persistance;

import game.model.partie.Partie;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class PartieMapper {
	
	private static int currentId;
	private static HashMap<Integer, Partie> map = new HashMap<Integer, Partie>();
	
	private static PartieMapper instance;
	
	//Constructor
	public PartieMapper() throws ClassNotFoundException, SQLException{
		currentId = this.getCurrentId();
	}
	
	//Methods
	public static PartieMapper getInstance() throws ClassNotFoundException, SQLException{
		if (instance == null)
			instance = new PartieMapper();
		return instance;
	}
	
	public int getCurrentId() throws ClassNotFoundException, SQLException{
		String query = "select max(id) from coo_partie";
		PreparedStatement ps = DBconfig.getInstance().getConnection().prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
				return rs.getInt(1)+1;
		}
		return 1;
	}
	
	public void insert(Partie p) throws ClassNotFoundException, SQLException{
		String query = "insert into coo_partie values (?)";
		PreparedStatement ps = DBconfig.getInstance().getConnection().prepareStatement(query);
			p.setId_partie(currentId);
			currentId++;
				ps.setInt(1, p.getId_partie());
				ps.executeUpdate();
				map.put(p.getId_partie(), p);
	}
	
	public Partie findById(int id) throws SQLException, ClassNotFoundException{
		if (map.containsKey(id))
			return map.get(id);
		String query = "select * from coo_joueur where id = ?";
		PreparedStatement ps = DBconfig.getInstance().getConnection().prepareStatement(query);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()){
			Partie p = new VirtualPartie();
			p.setId_partie(id);
			
			map.put(id, p);
			return p;
		}
		return null;
	}

	public ArrayList<Partie> findByIdJoueur(int id_joueur) throws ClassNotFoundException, SQLException {
		
		String query = "select id_partie from coo_jeu_partie where id_joueur = ?";
		PreparedStatement ps = DBconfig.getInstance().getConnection().prepareStatement(query);
		ps.setInt(1, id_joueur);
		ResultSet rs = ps.executeQuery();
		ArrayList<Partie> parties = new ArrayList<Partie>();
		while (rs.next()){
			 int id_p = rs.getInt(1);
			 Partie p = PartieMapper.getInstance().findById(id_p);
			 parties.add(p);
		}
		
		return parties;
	}

		
		
}
