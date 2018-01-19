package game.view.mapView;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import game.main.Jeu;
import game.model.map.tile.Case;
import game.view.SoulsButton;

public class ControlView extends JPanel {

	private static final long serialVersionUID = 1L;
	//
	private GeneralView o;
	
	JPanel actions = new JPanel();
	SoulsButton construire = new SoulsButton("Construire ville", 150, 40);
	SoulsButton creer = new SoulsButton("Creer armee", 150, 40);
	SoulsButton deplacer = new SoulsButton("Deplacer armee", 150, 40);
	SoulsButton attaquer = new SoulsButton("Attaquer ville", 150, 40);
	//
	JPanel infos_joueurs = new JPanel();
	JLabel pseudo = new JLabel(Jeu.getInstance().getCurrent_joueur().getPseudo());
	JLabel ressources = new JLabel("Ressources disponibles");
	JLabel ressources_joueur = new JLabel();
	//
	JPanel infos_case = new JPanel();
	JLabel coordonnees = new JLabel("Coordonnees");
	JLabel type = new JLabel("Type");
	JLabel unites = new JLabel("Unites presentes");
	JLabel coordonnees_case = new JLabel();
	JLabel type_case = new JLabel();
	JLabel unites_case = new JLabel();
	//
	JPanel messages = new JPanel();
	JLabel message = new JLabel("Cases Alentours");
	JList<Case> message_case = new JList<Case>();

	public ControlView (){
		
		Jeu.getInstance().getCurrent_partie().getMapJoueurs();
		ressources_joueur = new JLabel("" + Jeu.getInstance().getCurrent_partie().getRessourcesByIdJoueur(
				Jeu.getInstance().getCurrent_joueur().getId_joueur()));
		
		this.setLayout(new GridBagLayout());
		actions.setLayout(new GridBagLayout());
		infos_joueurs.setLayout(new GridBagLayout());
		infos_case.setLayout(new GridBagLayout());
		messages.setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.weightx = 1;
		c.weighty = 4;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 0;
		construire.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				notifyObserver("construire");
			}
		});
		actions.add(construire, c);
		c.gridx = 0;
		c.gridy = 1;
		creer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				notifyObserver("creer");
			}
		});
		actions.add(creer, c);
		c.gridx = 0;
		c.gridy = 2;
		deplacer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				notifyObserver("deplacer");
			}
		});
		deplacer.setEnabled(false);
		actions.add(deplacer, c);
		c.gridx = 0;
		c.gridy = 3;
		actions.add(attaquer, c);
		
		c.weightx = 1;
		c.weighty = 2;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 0;
		infos_joueurs.add(ressources, c);
		c.gridx = 0;
		c.gridy = 1;
		infos_joueurs.add(ressources_joueur, c);
		
		c.weightx = 1;
		c.weighty = 6;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 0;
		infos_case.add(coordonnees, c);
		c.gridx = 0;
		c.gridy = 1;
		infos_case.add(coordonnees_case, c);
		c.gridx = 0;
		c.gridy = 2;
		infos_case.add(type, c);
		c.gridx = 0;
		c.gridy = 3;
		infos_case.add(type_case, c);
		c.gridx = 0;
		c.gridy = 4;
		infos_case.add(unites, c);
		c.gridx = 0;
		c.gridy = 5;
		infos_case.add(unites_case, c);
		
		c.weightx = 1;
		c.weighty = 2;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 0;
		messages.add(message, c);
		c.gridx = 0;
		c.gridy = 1;
		message_case.setEnabled(false);
		messages.add(message_case, c);
		
		c.weightx = 1;
		c.weighty = 4;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 0;
		c.fill = GridBagConstraints.BOTH;
		this.add(actions, c);
		c.gridx = 1;
		c.gridy = 0;
		this.add(infos_joueurs, c);
		c.gridx = 2;
		c.gridy = 0;
		this.add(infos_case, c);
		c.gridx = 3;
		c.gridy = 0;
		this.add(messages, c);

		this.setBounds(0, 0, 1280, 900);
		
	}

	public GeneralView getObserver() {
		return o;
	}

	public void setObserver(GeneralView o) {
		this.o = o;
	}
	
	public void notifyObserver(Object arg){
		this.o.update(arg);
	}
	
}