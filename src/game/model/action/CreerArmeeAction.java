package game.model.action;

import java.sql.SQLException;

import game.main.Jeu;
import game.model.unite.Unite;
import game.model.unite.UniteType;
import game.persistance.UniteMapper;
import game.persistance.VirtualCase;

public class CreerArmeeAction implements Action {

	@Override
	public String doAction(VirtualCase c) {
		// TODO Auto-generated method stub
		String message = "";
		if(c.getUnite().isEmpty()){
			message = "Impossible, ville necessaire a la construction d'une armee";
		} else {
			for (int i = 0; i < c.getUnite().size(); i++) {
				if(c.getUnite().get(i).getUnite_type().equals(UniteType.VILLE)){
					Unite u = new Unite(UniteType.ARMEE, Jeu.getInstance().getCurrent_joueur(), c.getId_case());
					try {
						UniteMapper.getInstance().insert(u);
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					message = "Unite (armee) ajoutee";
					break;
				} else {
					message = "Impossible, ville necessaire a la construction d'une armee";
				}
			}
		}
		return message;
	}

}
