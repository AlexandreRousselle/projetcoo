package game.persistance;

import game.model.joueur.Joueur;

import java.lang.ref.WeakReference;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JoueurMapper {

	//Attributes
	private static int currentId;
	private static HashMap<Integer, WeakReference<Joueur>> map = new HashMap<Integer, WeakReference<Joueur>>();

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
		String query = "insert into coo_joueur values (?,?,?)";
		PreparedStatement ps = DBconfig.getInstance().getConnection().prepareStatement(query);
		j.setId_joueur(currentId);
		currentId++;
		ps.setInt(1, j.getId_joueur());
		ps.setString(2, j.getPseudo());
		ps.setString(3, j.getMdp());
		ps.executeUpdate();
		map.put(j.getId_joueur(), new WeakReference<Joueur>(j));
	}

	public Joueur findById(int id) throws SQLException, ClassNotFoundException{
		if (map.get(id) != null)
			return map.get(id).get();
		String query = "select * from coo_joueur where id_joueur = ?";
		PreparedStatement ps = DBconfig.getInstance().getConnection().prepareStatement(query);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()){
			String pseudo = rs.getString("pseudo");
			Joueur j = new Joueur();
			j.setPseudo(pseudo);
			j.setId_joueur(id);
			map.put(id, new WeakReference<Joueur>(j));
			return j;
		}
		return null;
	}
	
	public Joueur findByPseudoPassword(String pseudo, String mdp) throws SQLException, ClassNotFoundException{
			String query = "select id_joueur from coo_joueur where pseudo = ? and mdp = ?";
			PreparedStatement ps = DBconfig.getInstance().getConnection().prepareStatement(query);
			ps.setString(1, pseudo);
			ps.setString(2, mdp);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				int id_joueur = rs.getInt(1);
				Joueur j = new VirtualJoueur();
				j.setId_joueur(id_joueur);
				j.setPseudo(pseudo);
				j.setMdp(mdp);
				map.put(id_joueur, new WeakReference<Joueur>(j));
				return j;
			}
		return null;
	}

	public List<String> findUserNamesByJoueurPartie(int id_partie) throws ClassNotFoundException, SQLException {
		String query = "select cj.pseudo "
				+ "from coo_joueur cj "
				+ "inner join coo_joueur_partie cjp on cj.id_joueur = cjp.id_joueur"
				+ " where cjp.id_partie = ?";
		PreparedStatement ps = DBconfig.getInstance().getConnection().prepareStatement(query);
		ps.setInt(1, id_partie);
		ResultSet rs = ps.executeQuery();
		ArrayList<String> pseudos = new ArrayList<String>(); 
		while(rs.next()){
			System.out.println(rs.getString(1));
			String pseudo = rs.getString(1);
			pseudos.add(pseudo);
		}
		return pseudos;
	}

	public void update(Joueur j) {
		// TODO Auto-generated method stub
	}

}
