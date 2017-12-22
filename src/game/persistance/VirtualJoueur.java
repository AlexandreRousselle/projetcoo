package game.persistance;

import java.sql.SQLException;
import java.util.List;

import game.model.joueur.Joueur;
import game.model.partie.Partie;
import game.model.unite.Unite;

public class VirtualJoueur extends Joueur {
	
	public VirtualJoueur(){
		super();
		this.listeParties = null;
		this.listeUnites = null;
	}
	
	@Override
	public List<Partie> getListeParties() {
		if (this.listeParties == null){
			try {
				this.listeParties = PartieMapper.getInstance().findByIdJoueur(this.id_joueur);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return this.listeParties;
	}

	/*@Override
	/*public List<Unite> getListeUnites() {
		if (this.listeUnites == null){
			try {
				this.listeUnites = PartieMapper.getInstance().findByIdUser(this.id_joueur);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return this.listeUnites;
	}*/
	
}
