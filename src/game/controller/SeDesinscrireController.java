package game.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import game.main.EtatJeu;
import game.main.Jeu;
import game.persistance.PartieMapper;
import game.persistance.UnitOfWorks;

public class SeDesinscrireController implements ActionListener {
	
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
