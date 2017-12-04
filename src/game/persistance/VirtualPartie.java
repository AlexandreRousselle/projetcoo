package game.persistance;

import game.model.joueur.Joueur;
import game.model.partie.Partie;

import java.sql.SQLException;
import java.util.List;

public class VirtualPartie extends Partie{

	public VirtualPartie(){
		super();
		this.listeJoueurs = null;
	}

	@Override
	public List<Joueur> getListeJoueurs() {
		if(this.listeJoueurs == null){
			try {
				this.listeJoueurs = JoueurMapper.getInstance().findByIdPartie(this.id_partie);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return this.listeJoueurs;
	}
}
