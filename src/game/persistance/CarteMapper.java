package game.persistance;

import java.lang.ref.WeakReference;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import game.model.joueur.Joueur;
import game.model.map.Carte;
import game.model.map.factory.CarteType;
import game.model.map.tile.Case;

public class CarteMapper {

	//Attributes
		private static int currentId;
		private static HashMap<Integer, WeakReference<Carte>> map = new HashMap<Integer, WeakReference<Carte>>();

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
			String query = "select max(id_carte) from coo_carte";
			PreparedStatement ps = DBconfig.getInstance().getConnection().prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				return rs.getInt(1)+1;
			}
			ps.close();
			rs.close();
			return 1;
		}

		public void insert(Carte c) throws ClassNotFoundException, SQLException{
			String query = "insert into coo_carte values (?,?,?)";
			PreparedStatement ps = DBconfig.getInstance().getConnection().prepareStatement(query);
			c.setId_carte(currentId);
			currentId++;
			ps.setInt(1, c.getId_carte());
			ps.setString(2, c.getCarte_type().toString());
			ps.setInt(3, c.getDimension());
			ps.executeUpdate();
			CaseMapper.getInstance().insert(c.getListeCases());
			map.put(c.getId_carte(), new WeakReference<Carte>(c));
			ps.close();
		}

		public Carte findById(int id) throws SQLException, ClassNotFoundException{
			String query = "select * from coo_carte c inner join coo_partie_carte cpc on c.ID_CARTE = cpc.ID_CARTE "
					+ "where cpc.id_partie = ?";
			PreparedStatement ps = DBconfig.getInstance().getConnection().prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			Carte c = null;
			while (rs.next()){
				c = new VirtualCarte();
				c.setId_carte(rs.getInt(1));
				c.setCarte_type(CarteType.valueOf(rs.getString(2)));
				c.setDimension(rs.getInt(3));
			}
			ps.close();
			rs.close();
			return c;
		}
	
}
