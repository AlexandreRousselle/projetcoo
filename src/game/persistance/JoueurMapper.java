package game.persistance;

import game.model.joueur.Joueur;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JoueurMapper {

	//Attributes
	private static int currentId;
	private static HashMap<Integer, Joueur> map = new HashMap<Integer, Joueur>();

	private static JoueurMapper instance;

	//Constructor
	public JoueurMapper() throws ClassNotFoundException, SQLException{
		currentId = this.getCurrentId();
	}

	//Methods
	public static JoueurMapper getInstance() throws ClassNotFoundException, SQLException{
		if (instance == null)
			instance = new JoueurMapper();
		return instance;
	}

	public int getCurrentId() throws ClassNotFoundException, SQLException{
		String query = "select max(id_joueur) from coo_joueur";
		PreparedStatement ps = DBconfig.getInstance().getConnection().prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			return rs.getInt(1)+1;
		}
		return 1;
	}

	public void insert(Joueur j) throws ClassNotFoundException, SQLException{
		String query = "insert into coo_joueur(id_joueur, nom_joueur, id_partie) values (?,?,?)";
		PreparedStatement ps = DBconfig.getInstance().getConnection().prepareStatement(query);
		j.setId_joueur(currentId);
		currentId++;
		ps.setInt(1, j.getId_joueur());
		ps.setString(2, j.getNom_joueur());
		ps.setInt(3, j.getPartie().getId_partie());
		ps.executeUpdate();
		map.put(j.getId_joueur(), j);
	}

	public Joueur findById(int id) throws SQLException, ClassNotFoundException{
		if (map.containsKey(id))
			return map.get(id);
		String query = "select * from coo_joueur where id = ?";
		PreparedStatement ps = DBconfig.getInstance().getConnection().prepareStatement(query);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()){
			String pseudo = rs.getString("pseudo");
			Joueur j = new Joueur();
			j.setNom_joueur(pseudo);
			j.setId_joueur(id);
			map.put(id, j);
			return j;
		}
		return null;
	}

	public List<Joueur> findByIdPartie(int id_partie) throws ClassNotFoundException, SQLException {
		String query = "select * from coo_joueur where id_partie = ?";
		PreparedStatement ps = DBconfig.getInstance().getConnection().prepareStatement(query);
		ps.setInt(1, id_partie);
		ResultSet rs = ps.executeQuery();
		ArrayList<Joueur> joueurs = new ArrayList<Joueur>(); 
		while(rs.next()){
			int id_joueur = rs.getInt(1);
			Joueur j = findById(id_joueur);
			joueurs.add(j);
		}
		return joueurs;
	}

}
