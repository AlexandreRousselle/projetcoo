package game.persistance;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import game.model.joueur.Joueur;
import game.model.map.Carte;

public class CarteMapper {

	//Attributes
		private static int currentId;
		private static HashMap<Integer, Carte> map = new HashMap<Integer, Carte>();

		private static CarteMapper instance;

		//Constructor
		public CarteMapper() throws ClassNotFoundException, SQLException{
			currentId = this.getCurrentId();
		}

		//Methods
		public static CarteMapper getInstance() throws ClassNotFoundException, SQLException{
			if (instance == null)
				instance = new CarteMapper();
			return instance;
		}

		public int getCurrentId() throws ClassNotFoundException, SQLException{
			String query = "select max(id) from coo_carte";
			PreparedStatement ps = DBconfig.getInstance().getConnection().prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				return rs.getInt(1)+1;
			}
			return 1;
		}

		public void insert(Carte c) throws ClassNotFoundException, SQLException{
			String query = "insert into coo_carte values (?,?,?,?)";
			PreparedStatement ps = DBconfig.getInstance().getConnection().prepareStatement(query);
			c.setId_carte(currentId);
			currentId++;
			ps.setInt(1, c.getId_carte());
			ps.setString(2, c.getCarte_type().toString());
			ps.setInt(3, c.getDimension());
			ps.setInt(4, c.getPartie().getId_partie());
			ps.executeUpdate();
			map.put(c.getId_carte(), c);
		}

		public Carte findById(int id) throws SQLException, ClassNotFoundException{
			return null;
		}
	
}
