package game.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import game.main.EtatJeu;
import game.main.Jeu;
import game.model.joueur.Joueur;
import game.persistance.JoueurMapper;

/**
 * Classe ActionListener quand on clique sur le bouton "Connexion"
 * dans la vue de Login
 * @author roussellea
 *
 */
public class AuthentificationController implements ActionListener {
	
	private String pseudo, mdp;

	/**
	 * Constructeur AuthentificationController avec un pseudo et un mot de passe
	 * en parametres
	 * @param pseudo
	 * @param mdp
	 */
	public AuthentificationController(String pseudo, String mdp) {
		this.pseudo = pseudo;
		this.mdp = mdp;
	}
	
	/**
	 * Fonction actionPerformed() qui verifie la coherence en BDD entre le pseudo et le mot de passe
	 * Elle change l'etat du jeu (MENU_PRINCIPAL) si c'est OK et affiche un message
	 * Si ce n'est PAS OK, elle affiche un message d'erreur
	 * message affiche en JOptionPane
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
	    	if(JoueurMapper.getInstance().findByPseudoPassword(this.pseudo, this.mdp) != null) {
		    	JOptionPane.showMessageDialog(null,"Connexion reussie ! ","Success", JOptionPane.PLAIN_MESSAGE);
		    	Jeu.getInstance().setCurrent_joueur(JoueurMapper.getInstance().findByPseudoPassword(this.pseudo, this.mdp));
		    	Jeu.getInstance().setEtat_jeu(EtatJeu.MENU_PRINCIPAL);
	    	} else {
		    	JOptionPane.showMessageDialog(null,"Login ou mot de passe incorrect ! ", "Error", 1);
	    	}
    	}
    	catch (Exception ex) {
    		ex.printStackTrace();
    	}
	}

}
