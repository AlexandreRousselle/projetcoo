package game.persistance;

import game.main.Jeu;
import game.model.User;
import game.model.joueur.Joueur;
import game.model.partie.EtatPartie;
import game.model.partie.Partie;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
		String query = "select max(id_partie) from coo_partie";
		PreparedStatement ps = DBconfig.getInstance().getConnection().prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
				return rs.getInt(1)+1;
		}
		return 1;
	}
	
	public void insert(Partie p) throws ClassNotFoundException, SQLException{
		String query = "insert into coo_partie values (?,?,?,?,?,?,?,?)";
		PreparedStatement ps = DBconfig.getInstance().getConnection().prepareStatement(query);
		p.setId_partie(currentId);
		currentId++;
		ps.setInt(1, p.getId_partie());
		ps.setString(2, p.getNom_partie());
		ps.setDate(3, p.getDate());
		ps.setInt(4, p.getCreateur().getId_user());
		ps.setInt(5, p.getNb_joueurs());
		ps.setInt(6, p.getNb_tours());
		ps.setInt(7, p.getNb_ressources_tour());
		ps.setString(8, p.getEtat_partie().toString());
		ps.executeUpdate();
		CarteMapper.getInstance().insert(p.getCarte());
		String query2 = "insert into coo_partie_carte values (?,?)";
		PreparedStatement ps2 = DBconfig.getInstance().getConnection().prepareStatement(query2);
		ps2.setInt(1, p.getId_partie());
		ps2.setInt(2, p.getCarte().getId_carte());
		ps2.executeUpdate();
		for (int i = 0; i < p.getNb_joueurs(); i++) {
			Joueur j = new Joueur(null,null,null);
			j.setPartie(p);
			JoueurMapper.getInstance().insert(j);
		}
		map.put(p.getId_partie(), p);
	}
	
	public List<Partie> findByIdUser(int id_user) throws SQLException, ClassNotFoundException{
		String query = "select * from coo_partie where id_user = ?";
		PreparedStatement ps = DBconfig.getInstance().getConnection().prepareStatement(query);
		ps.setInt(1, id_user);
		ResultSet rs = ps.executeQuery();
		List<Partie> lp = new ArrayList<Partie>();
		while (rs.next()){
			if (map.containsKey(rs.getInt(1))) {
				lp.add(map.get(rs.getInt(1)));
			} else {
				Partie p = new VirtualPartie();
				p.setId_partie(rs.getInt(1));
				p.setNom_partie(rs.getString(2));
				p.setNb_joueurs(rs.getInt(5));
				p.setNb_tours(rs.getInt(6));
				p.setNb_ressources_tour(rs.getInt(7));
				p.setEtat_partie(EtatPartie.valueOf(rs.getString(8)));
				map.put(p.getId_partie(), p);
				lp.add(p);
			}
		}
		return lp;
	}
	
	public List<Partie> findInWait(User u) throws SQLException, ClassNotFoundException{
		String query = "select * from coo_partie where etat_partie = ? and id_user <> ?";
		PreparedStatement ps = DBconfig.getInstance().getConnection().prepareStatement(query);
		ps.setString(1, "ATTENTE");
		ps.setInt(2, u.getId_user());
		ResultSet rs = ps.executeQuery();
		List<Partie> lp = new ArrayList<Partie>();
		while (rs.next()){
			if (map.containsKey(rs.getInt(1))) {
				lp.add(map.get(rs.getInt(1)));
			} else {
				Partie p = new VirtualPartie();
				p.setId_partie(rs.getInt(1));
				p.setNom_partie(rs.getString(2));
				p.setNb_joueurs(rs.getInt(5));
				p.setNb_tours(rs.getInt(6));
				p.setNb_ressources_tour(rs.getInt(7));
				p.setEtat_partie(EtatPartie.valueOf(rs.getString(8)));
				map.put(p.getId_partie(), p);
				lp.add(p);
			}
		}
		return lp;
	}
		
}
