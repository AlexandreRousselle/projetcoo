package game.persistance;

import java.sql.SQLException;
import java.util.List;

import game.model.joueur.Joueur;
import game.model.partie.Partie;

public class VirtualJoueur extends Joueur{
	
	public VirtualJoueur(){
		super();
		this.listeParties = null;
	}
	
	@Override
	public List<Partie> getListeParties() {
		if (this.listeParties == null){
			try {
				PartieMapper.getInstance().findByIdJoueur(this.id_joueur);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return this.listeParties;
	}
}
