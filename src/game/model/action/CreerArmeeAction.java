package game.model.action;

import java.sql.SQLException;

import game.main.Jeu;
import game.model.unite.Unite;
import game.model.unite.UniteType;
import game.persistance.PartieMapper;
import game.persistance.UniteMapper;
import game.persistance.VirtualCase;

/**
 * Classe Action qui permet la creation d'une armée
 * @author roussellea
 *
 */
public class CreerArmeeAction implements Action {

	/**
	 * Creer une armée en BDD sur la case en question
	 * et retourne un message en fonction des conditions
	 */
	@Override
	public String doAction(VirtualCase c) {
		// TODO Auto-generated method stub
		String message = "";
		if(c.getBuild_on()){
			if(Jeu.getInstance().getCurrent_partie()
	    			.getRessourcesByIdJoueur(Jeu.getInstance().getCurrent_joueur().getId_joueur()) >= 200) {
				if(c.getUnite().isEmpty()){
					message = "FAIL, Impossible, ville necessaire a la construction d'une armee";
				} else {
					for (int i = 0; i < c.getUnite().size(); i++) {
						if (c.getUnite().get(i).getProprietaire().getId_joueur() == Jeu.getInstance().getCurrent_joueur().getId_joueur()) {
							if(c.getUnite().get(i).getUnite_type().equals(UniteType.VILLE)){
								Unite u = new Unite(UniteType.ARMEE, Jeu.getInstance().getCurrent_joueur(), c.getId_case());
								try {
									UniteMapper.getInstance().insert(u);
									PartieMapper.getInstance().updateRessources(Jeu.getInstance().getCurrent_partie().getId_partie()
											, Jeu.getInstance().getCurrent_joueur().getId_joueur()
											, Jeu.getInstance().getCurrent_partie()
							    			.getRessourcesByIdJoueur(Jeu.getInstance().getCurrent_joueur().getId_joueur()) - 200);
								} catch (ClassNotFoundException | SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								System.out.println(c.getUnite().get(i).getProprietaire().getId_joueur() + "" + Jeu.getInstance().getCurrent_joueur().getId_joueur());
								message = "Unite (armee) ajoutee";
								break;
							} else {
								message = "FAIL, Impossible, ville necessaire a la construction d'une armee";
							}
						} else {
							message = "FAIL, Ville adversaire !!";
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
