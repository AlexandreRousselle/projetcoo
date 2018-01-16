package game.persistance;

import game.model.joueur.Joueur;
import game.model.map.Carte;
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
				this.listeJoueurs = PartieMapper.getInstance().findJoueursById(this.id_partie);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return this.listeJoueurs;
	}
}
