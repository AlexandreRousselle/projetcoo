package game.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import game.main.EtatJeu;
import game.main.Jeu;
import game.persistance.UserMapper;

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
	    	if(UserMapper.getInstance().findByPseudoPassword(this.pseudo, this.mdp) != null) {
	    		System.out.println(this.pseudo);
	    		System.out.println(this.mdp);
		    	JOptionPane.showMessageDialog(null,"Connexion reussie ! ","Success", JOptionPane.PLAIN_MESSAGE);
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
