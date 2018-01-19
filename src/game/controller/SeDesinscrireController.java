package game.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import game.main.EtatJeu;
import game.main.Jeu;
import game.persistance.PartieMapper;
import game.persistance.UnitOfWorks;

/**
 * Classe ActionListener quand on clique sur le bouton "Se desinscrire"
 * dans le menu d'attente dans la vue AttenteCreationPartie
 * @author roussellea
 */
public class SeDesinscrireController implements ActionListener {
	
	/**
	 * Fonction actionPerformed() qui va juste passer la partie courante à null
	 * et passer l'etat du jeu à MENU_PRINCIPAL (retour au menu principal)
	 * Elle va aussi suppression la relation joueur/partie en BDD
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			PartieMapper.getInstance().deleteRelationPartieJoueur(Jeu.getInstance().getCurrent_joueur(), Jeu.getInstance().getCurrent_partie());
			Jeu.getInstance().setCurrent_partie(null);
		    Jeu.getInstance().setEtat_jeu(EtatJeu.MENU_PRINCIPAL);
			UnitOfWorks.getInstance().commit();
    	}
    	catch (Exception ex) {
    		ex.printStackTrace();
    	}
	}

}
