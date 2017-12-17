package game.persistance;

import java.sql.SQLException;
import java.util.List;

import game.model.User;
import game.model.joueur.Joueur;
import game.model.partie.Partie;

public class VirtualUser extends User {
	
	public VirtualUser(String pseudo, String mdp){
		super(pseudo, mdp);
		this.listeParties = null;
	}
	
	@Override
	public List<Partie> getListeParties() {
		if (this.listeParties == null){
			try {
				PartieMapper.getInstance().findByIdJoueur(this.id_user);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return this.listeParties;
	}
	
}
