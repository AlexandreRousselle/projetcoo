package game.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import game.main.EtatJeu;
import game.main.Jeu;


public class RetourMenuListener extends JFrame implements ActionListener {

   private static final long serialVersionUID = 1L;

   @Override
   public void actionPerformed(ActionEvent e) {
	   Jeu.getInstance().setCurrent_partie(null);
	   Jeu.getInstance().setEtat_jeu(EtatJeu.MENU_PRINCIPAL);
   }
   
}
