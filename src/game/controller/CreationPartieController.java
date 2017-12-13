package game.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import game.main.EtatJeu;
import game.main.Jeu;
import game.model.map.factory.CarteType;
import game.model.partie.Partie;
import game.persistance.PartieMapper;

public class CreationPartieController implements ActionListener {
	
	private String nom_partie;
	private int nb_joueurs;
	private CarteType type_carte;
	private int dimension_carte;

	public CreationPartieController(String nom_partie, int nb_joueurs, CarteType type_carte, int dimension_carte) {
		// TODO Auto-generated constructor stub
		this.nom_partie = nom_partie;
		this.nb_joueurs = nb_joueurs;
		this.type_carte = type_carte;
		this.dimension_carte = dimension_carte;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			Partie p = new Partie(this.nom_partie);
			PartieMapper.getInstance().insert(p);
			Jeu.getInstance().ajouterInfos(this.nom_partie);
			Jeu.getInstance().ajouterInfos(Integer.toString(this.nb_joueurs));
			Jeu.getInstance().ajouterInfos(this.type_carte.toString());
			Jeu.getInstance().ajouterInfos(Integer.toString(this.dimension_carte));
	    	Jeu.getInstance().setEtat_jeu(EtatJeu.ATTENTE_PARTIE);
    	}
    	catch (Exception ex) {
    		ex.printStackTrace();
    	}
	}

}
