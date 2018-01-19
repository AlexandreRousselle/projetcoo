package game.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import game.main.EtatJeu;
import game.main.Jeu;

/**
 * Classe ActionListener quand on clique sur le bouton "Retour"
 * dans le menu d'attente dans la vue AttenteCreationPartie
 * @author roussellea
 *
 */
public class RetourMenuListener implements ActionListener {

	/**
	 * Fonction actionPerformed() qui va juste passer la partie courante à null
	 * et passer l'etat du jeu à MENU_PRINCIPAL (retour au menu principal)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Jeu.getInstance().setCurrent_partie(null);
		Jeu.getInstance().setEtat_jeu(EtatJeu.MENU_PRINCIPAL);
	}
   
}
