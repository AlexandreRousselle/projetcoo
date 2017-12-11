package game.persistance;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import game.model.User;
import game.model.joueur.Joueur;

public class UserMapper {

	//Attributes
	private static int currentId;
	private static HashMap<Integer, User> map = new HashMap<Integer, User>();

	private static UserMapper instance;
	
	//Constructor
	public UserMapper() throws ClassNotFoundException, SQLException{
		currentId = this.getCurrentId();
	}
	
	//Methods
	public static UserMapper getInstance() throws ClassNotFoundException, SQLException{
		if (instance == null)
			instance = new UserMapper();
		return instance;
	}
	
	public void insert(User u) throws ClassNotFoundException, SQLException{
		String query = "insert into coo_user values (?,?,?)";
		PreparedStatement ps = DBconfig.getInstance().getConnection().prepareStatement(query);
		u.setId_user(currentId);
		currentId++;
		ps.setInt(1, u.getId_user());
		ps.setString(2, u.getPseudo());
		ps.setString(3, u.getMdp());
		ps.executeUpdate();
		map.put(u.getId_user(), u);
	}
		
	public int getCurrentId() throws ClassNotFoundException, SQLException{
		String query = "select max(id_user) from coo_user";
		PreparedStatement ps = DBconfig.getInstance().getConnection().prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while (rs.next()){
			return rs.getInt(1)+1;
		}
		return 1;
	}
	
	public User findByPseudoPassword(String pseudo, String mdp) throws SQLException, ClassNotFoundException{
		String query = "select id_user from coo_user where pseudo = ? and mdp = ?";
		PreparedStatement ps = DBconfig.getInstance().getConnection().prepareStatement(query);
		ps.setString(1, pseudo);
		ps.setString(2, mdp);
		ResultSet rs = ps.executeQuery();
		while (rs.next()){
			int id_user = rs.getInt(1);
			if (map.containsKey(id_user))
				return map.get(id_user);
			User u = new VirtualUser();
			u.setPseudo(pseudo);
			u.setMdp(mdp);
			map.put(id_user, u);
			return u;
		}
		return null;
	}
	
}
