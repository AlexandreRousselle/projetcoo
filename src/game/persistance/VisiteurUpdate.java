package game.persistance;

import java.sql.SQLException;

import game.model.Visiteur;
import game.model.joueur.Joueur;
import game.model.partie.Partie;

public class VisiteurUpdate extends Visiteur{

	@Override
	public void visit(Joueur j) {
		try {
			JoueurMapper.getInstance().update(j);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void visit(Partie p) {
		try {
			PartieMapper.getInstance().update(p);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
