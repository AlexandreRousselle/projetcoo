package game.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import game.main.EtatJeu;
import game.main.Jeu;
import game.model.joueur.Joueur;
import game.persistance.JoueurMapper;

public class AuthentificationController implements ActionListener {
	
	private String pseudo, mdp;

	public AuthentificationController(String pseudo, String mdp) {
		this.pseudo = pseudo;
		this.mdp = mdp;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
	    	if(JoueurMapper.getInstance().findByPseudoPassword(this.pseudo, this.mdp) != null) {
		    	JOptionPane.showMessageDialog(null,"Connexion reussie ! ","Success", JOptionPane.PLAIN_MESSAGE);
		    	Joueur j = new Joueur(JoueurMapper.getInstance().findByPseudoPassword(this.pseudo, this.mdp).getId_joueur(), this.pseudo, this.mdp);
		    	Jeu.getInstance().setCurrent_joueur(j);
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
