package game.persistance;

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
		String query = "insert into coo_partie values (?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = DBconfig.getInstance().getConnection().prepareStatement(query);
		p.setId_partie(currentId);
		currentId++;
		ps.setInt(1, p.getId_partie());
		ps.setString(2, p.getNom_partie());
		ps.setDate(3, p.getDate());
		ps.setInt(4, p.getCreateur().getId_joueur());
		ps.setInt(5, p.getNb_joueurs());
		ps.setInt(6, p.getNb_tours());
		ps.setInt(7, p.getNb_ressources_initial());
		ps.setInt(8, p.getNb_ressources_tour());
		ps.setString(9, p.getEtat_partie().toString());
		ps.executeUpdate();
		CarteMapper.getInstance().insert(p.getCarte());
		String query2 = "insert into coo_partie_carte values (?,?)";
		PreparedStatement ps2 = DBconfig.getInstance().getConnection().prepareStatement(query2);
		ps2.setInt(1, p.getId_partie());
		ps2.setInt(2, p.getCarte().getId_carte());
		ps2.executeUpdate();
		for (int i = 0; i < p.getNb_joueurs(); i++) {
			Joueur j = new Joueur();
			
			JoueurMapper.getInstance().insert(j);
		}
		map.put(p.getId_partie(), p);
	}
	
	public List<Partie> findByIdJoueur(int id_joueur) throws SQLException, ClassNotFoundException{
		String query = "select cp.id_partie, cp.nom_partie, cp.date_creation, cp.createur, cp.nb_joueurs"
				+ ", cp.nb_tours, cp.nb_ressources_initial, cp.nb_ressources_tour, cp.etat_partie"
				+ " from coo_partie cp join coo_joueur_partie cjp where id_joueur = ?";
		PreparedStatement ps = DBconfig.getInstance().getConnection().prepareStatement(query);
		ps.setInt(1, id_joueur);
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
				p.setNb_ressources_initial(rs.getInt(7));
				p.setNb_ressources_tour(rs.getInt(8));
				p.setEtat_partie(EtatPartie.valueOf(rs.getString(9)));
				map.put(p.getId_partie(), p);
				lp.add(p);
			}
		}
		return lp;
	}
	
	public List<Partie> findInWait(Joueur j) throws SQLException, ClassNotFoundException {
		String query = "select cp.id_partie, cp.nom_partie, cp.date_creation, cp.createur, cp.nb_joueurs"
				+ ", cp.nb_tours, cp.nb_ressources_initial, cp.nb_ressources_tour, cp.etat_partie"
				+ " from coo_partie cp join coo_joueur_partie cjp"
				+ " where cp.etat_partie = ? and cjp.id_joueur <> ?";
		PreparedStatement ps = DBconfig.getInstance().getConnection().prepareStatement(query);
		ps.setString(1, "ATTENTE");
		ps.setInt(2, j.getId_joueur());
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
				p.setNb_ressources_initial(rs.getInt(7));
				p.setNb_ressources_tour(rs.getInt(8));
				p.setEtat_partie(EtatPartie.valueOf(rs.getString(9)));
				map.put(p.getId_partie(), p);
				lp.add(p);
			}
		}
		return lp;
	}
		
}
