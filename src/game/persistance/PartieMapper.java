package game.persistance;

import game.main.Jeu;
import game.model.joueur.Joueur;
import game.model.partie.EtatPartie;
import game.model.partie.Partie;

import java.lang.ref.WeakReference;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class PartieMapper {
	
	private static int currentId;
	private static HashMap<Integer, WeakReference<Partie>> map = new HashMap<Integer, WeakReference<Partie>>();
	
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
		String query = "insert into coo_partie values (?,?,SYSDATE,?,?,?,?,?,?)";
		PreparedStatement ps = DBconfig.getInstance().getConnection().prepareStatement(query);
		p.setId_partie(currentId);
		currentId++;
		ps.setInt(1, p.getId_partie());
		ps.setString(2, p.getNom_partie());
		ps.setInt(3, p.getCreateur().getId_joueur());
		ps.setInt(4, p.getNb_joueurs());
		ps.setInt(5, p.getNb_tours());
		ps.setInt(6, p.getNb_ressources_initial());
		ps.setInt(7, p.getNb_ressources_tour());
		ps.setString(8, p.getEtat_partie().toString());
		ps.executeUpdate();
		CarteMapper.getInstance().insert(p.getCarte());
		PartieMapper.getInstance().insertRelationPartieJoueur(Jeu.getInstance().getCurrent_joueur(), p);
		String query2 = "insert into coo_partie_carte values (?,?)";
		PreparedStatement ps2 = DBconfig.getInstance().getConnection().prepareStatement(query2);
		ps2.setInt(1, p.getId_partie());
		ps2.setInt(2, p.getCarte().getId_carte());
		ps2.executeUpdate();
		map.put(p.getId_partie(), new WeakReference<Partie>(p));
	}
	
	public void insertRelationPartieJoueur(Joueur j, Partie p) throws ClassNotFoundException, SQLException {
		String query3 = "insert into coo_joueur_partie values (?,?,?)";
		PreparedStatement ps3 = DBconfig.getInstance().getConnection().prepareStatement(query3);
		ps3.setInt(1, j.getId_joueur());
		ps3.setInt(2, p.getId_partie());
		ps3.setInt(3, p.getNb_ressources_initial());
		ps3.executeUpdate();
		map.put(p.getId_partie(), new WeakReference<Partie>(p));
	}
	
	public void deleteRelationPartieJoueur(Joueur j, Partie p) throws ClassNotFoundException, SQLException {
		String query3 = "delete from coo_joueur_partie where id_joueur = ? and id_partie = ?";
		PreparedStatement ps3 = DBconfig.getInstance().getConnection().prepareStatement(query3);
		ps3.setInt(1, j.getId_joueur());
		ps3.setInt(2, p.getId_partie());
		ps3.executeUpdate();
		map.put(p.getId_partie(), new WeakReference<Partie>(p));
	}
	
	public Partie findById(int id_partie) throws SQLException, ClassNotFoundException {
		WeakReference<Partie> wr = null;
		wr = map.get(id_partie);
		if(wr != null && wr.get() != null) {
			System.out.println(id_partie);
			return wr.get();
		} else {
			String query = "select * from coo_partie where id_partie = ?";
			PreparedStatement ps = DBconfig.getInstance().getConnection().prepareStatement(query);
			ps.setInt(1, id_partie);
			ResultSet rs = ps.executeQuery();
			Partie p = new VirtualPartie();
			while(rs.next()){
				p.setId_partie(rs.getInt(1));
				p.setNom_partie(rs.getString(2));
				Joueur j = new VirtualJoueur();
				p.setDate(rs.getDate(3));
				j.setId_joueur(rs.getInt(4));
				p.setCreateur(j);
				p.setCarte(CarteMapper.getInstance().findById(id_partie));
				p.setNb_joueurs(rs.getInt(5));
				p.setNb_tours(rs.getInt(6));
				p.setNb_ressources_initial(rs.getInt(7));
				p.setNb_ressources_tour(rs.getInt(8));
				p.setEtat_partie(EtatPartie.valueOf(rs.getString(9)));
				map.put(id_partie, new WeakReference<Partie>(p));
			}
			p.addObserver(UnitOfWorks.getInstance());
			return p;
		}
	}
	
	public List<Partie> findByIdJoueur(int id_joueur) throws SQLException, ClassNotFoundException{
		List<Partie> lp = new ArrayList<Partie>();
		String query = "select cp.id_partie from coo_partie cp inner join coo_joueur_partie cjp"
				+ " on cp.id_partie = cjp.id_partie where id_joueur = ?";
		PreparedStatement ps = DBconfig.getInstance().getConnection().prepareStatement(query);
		ps.setInt(1, id_joueur);
		ResultSet rs = ps.executeQuery();
		while (rs.next()){
			lp.add(PartieMapper.getInstance().findById(rs.getInt(1)));
		}
		return lp;
	}
	
	public List<Partie> findInWait(Joueur j) throws SQLException, ClassNotFoundException {
		String query = "select cp.id_partie"
				+ " from coo_partie cp inner join coo_joueur_partie cjp on cp.id_partie = cjp.id_partie"
				+ " where cp.etat_partie = ? and cjp.id_joueur <> ? and cjp.id_partie NOT IN"
				+ " (select id_partie from coo_joueur_partie where id_joueur = ?)";
		PreparedStatement ps = DBconfig.getInstance().getConnection().prepareStatement(query);
		List<Partie> parties = new ArrayList<Partie>();
		ps.setString(1, "ATTENTE");
		ps.setInt(2, j.getId_joueur());
		ps.setInt(3, j.getId_joueur());
		ResultSet rs = ps.executeQuery();
			while (rs.next()){
				parties.add(PartieMapper.getInstance().findById(rs.getInt(1)));
			}
		return parties;
	}

	public void update(Partie p) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String query = "update coo_partie set etat_partie=? where id_partie=?";
		PreparedStatement ps = DBconfig.getInstance().getConnection().prepareStatement(query);
		ps.setString(1, p.getEtat_partie().toString());
		ps.setInt(2, p.getId_partie());
		ps.executeUpdate();
		
	}
		
}
