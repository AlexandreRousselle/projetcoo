package game.persistance;

import game.model.joueur.Joueur;
import game.model.map.Carte;
import game.model.partie.Partie;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class VirtualPartie extends Partie {

	public VirtualPartie(){
		super();
		this.mapJoueurs = null;
		this.listeJoueurs = null;
		this.carte = null;
	}
	
	public List<Joueur> getListeJoueurs() {
		if(this.listeJoueurs == null){
			try {
				this.listeJoueurs = PartieMapper.getInstance().findJoueursByIdList(this.id_partie);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return this.listeJoueurs;
	}
	
	@Override
	public Map<Joueur, Integer> getMapJoueurs() {
		if(this.mapJoueurs == null){
			try {
				this.mapJoueurs = PartieMapper.getInstance().findJoueursById(this.id_partie);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return this.mapJoueurs;
	}

	public Carte getCarte() {
		if(this.carte == null){
			try {
				this.carte = CarteMapper.getInstance().findById(this.id_partie);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return this.carte;
	}

}
