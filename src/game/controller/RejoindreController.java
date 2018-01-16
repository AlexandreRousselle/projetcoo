package game.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import game.main.EtatJeu;
import game.main.Jeu;
import game.model.partie.Partie;
import game.persistance.PartieMapper;

public class RejoindreController implements ActionListener {
	
	protected Partie partie;

	public RejoindreController (Partie p) {
		this.partie = p;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			PartieMapper.getInstance().insertRelationPartieJoueur(Jeu.getInstance().getCurrent_joueur(), partie);
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Jeu.getInstance().setCurrent_partie(partie);
		Jeu.getInstance().setEtat_jeu(EtatJeu.ATTENTE_PARTIE);
	}
	
}
