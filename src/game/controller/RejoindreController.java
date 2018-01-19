package game.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import game.main.EtatJeu;
import game.main.Jeu;
import game.model.partie.Partie;
import game.persistance.PartieMapper;

/**
 * Classe ActionListener quand on clique sur le bouton "Rejoindre"
 * dans le menu RejoindrePartie de la vue ChoixPartie
 * @author roussellea
 *
 */
public class RejoindreController implements ActionListener {
	
	protected Partie partie;

	/**
	 * Constructeur RejoindreController avec une partie en parametre
	 * @param p
	 */
	public RejoindreController (Partie p) {
		this.partie = p;
	}
	
	/**
	 * Fonction actionPerformed() qui insère un relation entre la partie de la JList et le joueur courant enregistré
	 * dans le singleton Jeu.java
	 * Elle associe aussi la partie selectionnée à la partie courante dans le Jeu et change l'etat du jeu
	 * à la salle d'attente (ATTENTE_PARTIE)
	 */
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
