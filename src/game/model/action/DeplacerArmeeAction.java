package game.model.action;

import java.sql.SQLException;

import game.main.Jeu;
import game.model.unite.Unite;
import game.model.unite.UniteType;
import game.persistance.UniteMapper;
import game.persistance.VirtualCase;

public class DeplacerArmeeAction {

	public String doAction(VirtualCase fromCase, VirtualCase toCase) {
		// TODO Auto-generated method stub
		String message = "";
		if(fromCase.getUnite().isEmpty()){
			message = "FAIL, Pas d'armee à deplacer !";
		} else {
			for (int i = 0; i < fromCase.getUnite().size(); i++) {
				if (fromCase.getUnite().get(i).getProprietaire().getId_joueur() 
						!= Jeu.getInstance().getCurrent_joueur().getId_joueur()){
					message = "FAIL, Pas d'armee à deplacer !";
				} else if (fromCase.getUnite().get(i).getUnite_type().equals(UniteType.ARMEE)){
					
					message = "Armee deplacee !";
					break;
				} else {
					message = "FAIL, Pas d'armee à deplacer !";
				}
			}
		}
		return message; 
	}

}
