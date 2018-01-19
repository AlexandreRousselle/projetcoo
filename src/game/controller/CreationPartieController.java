package game.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import game.main.EtatJeu;
import game.main.Jeu;
import game.model.joueur.Joueur;
import game.model.map.factory.CarteFactory;
import game.model.map.factory.CarteType;
import game.model.partie.Partie;
import game.persistance.JoueurMapper;
import game.persistance.PartieMapper;
import game.persistance.UnitOfWorks;

/**
 * Classe ActionListener quand on clique sur le bouton "Valider"
 * dans la vue de NouvellePartie
 * @author roussellea
 *
 */
public class CreationPartieController implements ActionListener {
	
	private String nom_partie;
	private int nb_ressources_initial;
	private int nb_ressources_tour;
	private int nb_tours;
	private int nb_joueurs;
	private CarteType type_carte;
	private int dimension_carte;

	/**
	 * Constructeur CreationPartieController avec les attributs en conséquence
	 * @param nom_partie
	 * @param nb_joueurs
	 * @param nb_tours
	 * @param nb_ressources_initial
	 * @param nb_ressources_tour
	 * @param type_carte
	 * @param dimension_carte
	 */
	public CreationPartieController(String nom_partie, int nb_joueurs, int nb_tours, int nb_ressources_initial,
			int nb_ressources_tour, CarteType type_carte, int dimension_carte) {
		// TODO Auto-generated constructor stub
		this.nom_partie = nom_partie;
		this.nb_joueurs = nb_joueurs;
		this.nb_ressources_initial = nb_ressources_initial;
		this.nb_tours = nb_tours;
		this.nb_ressources_tour = nb_ressources_tour;
		this.type_carte = type_carte;
		this.dimension_carte = dimension_carte;
	}

	/**
	 * Fonction actionPerformed() qui cree la partie avec les attributs de la vue
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			Partie p = new Partie(this.nom_partie, Jeu.getInstance().getCurrent_joueur(), this.nb_joueurs, this.nb_tours, this.nb_ressources_initial,
					this.nb_ressources_tour, new CarteFactory().creerCarte(this.type_carte, this.dimension_carte));
			p.setDate(new Date(System.currentTimeMillis()));
			PartieMapper.getInstance().insert(p);
			Jeu.getInstance().setCurrent_partie(p);
	    	Jeu.getInstance().setEtat_jeu(EtatJeu.ATTENTE_PARTIE);
    	}
    	catch (Exception ex) {
    		ex.printStackTrace();
    	}
	}

}
