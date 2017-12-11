package game.persistance;

import java.sql.SQLException;

import game.model.User;
import game.model.Visiteur;
import game.model.joueur.Joueur;
import game.model.partie.Partie;

public class VisiteurCreate extends Visiteur{

	@Override
	public void visit(Joueur j) {
		try {
			JoueurMapper.getInstance().insert(j);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void visit(Partie p) {
		try {
			PartieMapper.getInstance().insert(p);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void visit(User u) {
		try {
			UserMapper.getInstance().insert(u);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
