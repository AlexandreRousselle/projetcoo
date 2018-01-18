package game.model.action;

import java.sql.SQLException;

import game.main.Jeu;
import game.model.unite.Unite;
import game.model.unite.UniteType;
import game.persistance.PartieMapper;
import game.persistance.UniteMapper;
import game.persistance.VirtualCase;

public class ConstruireVilleAction implements Action {
	
	@Override
	public String doAction(VirtualCase c) {
		// TODO Auto-generated method stub
		String message = "";
		if(c.getBuild_on()){
			if(Jeu.getInstance().getCurrent_partie()
		    			.getRessourcesByIdJoueur(Jeu.getInstance().getCurrent_joueur().getId_joueur()) >= 400) {
				if(c.getUnite().isEmpty()){
					Unite u = new Unite(UniteType.VILLE, Jeu.getInstance().getCurrent_joueur(), c.getId_case());
					try {
						UniteMapper.getInstance().insert(u);
						PartieMapper.getInstance().updateRessources(Jeu.getInstance().getCurrent_partie().getId_partie()
								, Jeu.getInstance().getCurrent_joueur().getId_joueur()
								, Jeu.getInstance().getCurrent_partie()
				    			.getRessourcesByIdJoueur(Jeu.getInstance().getCurrent_joueur().getId_joueur()) - 400);
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					message = "Unite (ville) ajoutee";
				} else {
					for (int i = 0; i < c.getUnite().size(); i++) {
						if(c.getUnite().get(i).getUnite_type().equals(UniteType.VILLE)){
							message = "FAIL, Deja une ville sur cette case";
							break;
						} else {
							Unite u = new Unite(UniteType.VILLE, Jeu.getInstance().getCurrent_joueur(), c.getId_case());
							try {
								UniteMapper.getInstance().insert(u);
								PartieMapper.getInstance().updateRessources(Jeu.getInstance().getCurrent_partie().getId_partie()
										, Jeu.getInstance().getCurrent_joueur().getId_joueur()
										, Jeu.getInstance().getCurrent_partie()
						    			.getRessourcesByIdJoueur(Jeu.getInstance().getCurrent_joueur().getId_joueur()) - 600);
							} catch (ClassNotFoundException | SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							message = "Unite (ville) ajoutee";
						}
					}
				}
			} else { 
				message = "Pas assez de ressources";
			}
		} else {
			message = "On ne peut pas construire sur un(e) " + c.getCase_type().toString();
		}
		return message;
	}

}
