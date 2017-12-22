package game.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;

import game.controller.CreationPartieController;
import game.controller.RetourMenuListener;
import game.main.EtatJeu;
import game.main.Jeu;
import game.model.map.factory.CarteType;
import game.view.MenuPrincipalView.DecoListener;

public class NouvellePartieView extends JPanel {

	private static final long serialVersionUID = 1L;

	JPanel partie = new JPanel();
	JPanel carte = new JPanel();
	JPanel boutons = new JPanel();
	//
	JLabel nom_partie = new JLabel("Nom de la partie");
	JLabel nb_joueurs = new JLabel("Nombre de joueurs");
	JLabel nb_tours = new JLabel("Nombre de tours");
	JLabel nb_ressources_initial = new JLabel("Nombre de ressources initial");
	JLabel nb_ressources_tour = new JLabel("Nombre de ressources par tour");
	JTextField nom_partiejtf = new JTextField();
	JSpinner nb_joueurs_spin = new JSpinner(new SpinnerNumberModel(2, 2, 4, 1));
	JSpinner nb_tours_slider = new JSpinner(new SpinnerNumberModel(10, 5, 50, 5));
	JSpinner nb_ressources_initial_slider = new JSpinner(new SpinnerNumberModel(500, 100, 1000, 100));
	JSpinner nb_ressources_tour_slider = new JSpinner(new SpinnerNumberModel(500, 100, 1000, 100));
	//
	JLabel type_carte = new JLabel("Type de carte");
	JLabel dimension_carte = new JLabel("Dimension de la carte");
	JSpinner type_carte_spin = new JSpinner(new SpinnerListModel(CarteType.values()));
	JSpinner dimension_carte_spin = new JSpinner(new SpinnerNumberModel(30, 20, 30, 2));
	//
	SoulsButton valider = new SoulsButton("Valider", 200, 60);
	SoulsButton retour = new SoulsButton("Retour", 200, 60);
	Font font = new Font("Arial",Font.BOLD,14);

	public NouvellePartieView() {
		
		this.setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		
		nom_partie.setForeground(Color.WHITE);
		nb_joueurs.setForeground(Color.WHITE);
		nb_tours.setForeground(Color.WHITE);
		nb_ressources_initial.setForeground(Color.WHITE);
		nb_ressources_tour.setForeground(Color.WHITE);
		nom_partie.setFont(font);
		nb_joueurs.setFont(font);
		nb_tours.setFont(font);
		nb_ressources_initial.setFont(font);
		nb_ressources_tour.setFont(font);
		type_carte.setForeground(Color.WHITE);
		dimension_carte.setForeground(Color.WHITE);
		type_carte.setFont(font);
		dimension_carte.setFont(font);
		
		((JSpinner.DefaultEditor) nb_joueurs_spin.getEditor()).getTextField().setEditable(false);
		((JSpinner.DefaultEditor) nb_tours_slider.getEditor()).getTextField().setEditable(false);
		((JSpinner.DefaultEditor) nb_ressources_initial_slider.getEditor()).getTextField().setEditable(false);
		((JSpinner.DefaultEditor) nb_ressources_tour_slider.getEditor()).getTextField().setEditable(false);
		((JSpinner.DefaultEditor) type_carte_spin.getEditor()).getTextField().setEditable(false);
		((JSpinner.DefaultEditor) dimension_carte_spin.getEditor()).getTextField().setEditable(false);
		
		nom_partiejtf.setPreferredSize(new Dimension(150, 30));
		nb_joueurs_spin.setPreferredSize(new Dimension(150, 30));
		type_carte_spin.setPreferredSize(new Dimension(150, 30));
		dimension_carte_spin.setPreferredSize(new Dimension(150, 30));
		
		nb_tours_slider.setPreferredSize(new Dimension(150, 30));
		nb_ressources_initial_slider.setPreferredSize(new Dimension(150, 30));
		nb_ressources_tour_slider.setPreferredSize(new Dimension(150, 30));
		
		partie.setLayout(new GridBagLayout());
		c.gridwidth = 1;
		c.insets = new Insets(10, 20, 10, 20);
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 0;
		partie.add(nom_partie, c);
		c.gridx = 0;
		c.gridy = 1;
		partie.add(nb_joueurs, c);
		c.gridx = 0;
		c.gridy = 2;
		partie.add(nb_tours, c);
		c.gridx = 0;
		c.gridy = 3;
		partie.add(nb_ressources_initial, c);
		c.gridx = 0;
		c.gridy = 4;
		partie.add(nb_ressources_tour, c);
		c.gridx = 1;
		c.gridy = 0;
		partie.add(nom_partiejtf, c);
		c.gridx = 1;
		c.gridy = 1;
		partie.add(nb_joueurs_spin, c);
		c.gridx = 1;
		c.gridy = 2;
		partie.add(nb_tours_slider, c);
		c.gridx = 1;
		c.gridy = 3;
		partie.add(nb_ressources_initial_slider, c);
		c.gridx = 1;
		c.gridy = 4;
		partie.add(nb_ressources_tour_slider, c);
		
		c.fill = 0;
		
		carte.setLayout(new GridBagLayout());
		c.weightx = 2;
		c.weighty = 2;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 0;
		carte.add(type_carte, c);
		c.gridx = 0;
		c.gridy = 1;
		carte.add(dimension_carte, c);
		c.gridx = 1;
		c.gridy = 0;
		carte.add(type_carte_spin, c);
		c.gridx = 1;
		c.gridy = 1;
		carte.add(dimension_carte_spin, c);	
		
		boutons.setLayout(new GridBagLayout());
		c.gridwidth = 1;
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 0;
		boutons.add(retour, c);
		retour.addActionListener(new RetourMenuListener());
		c.gridx = 1;
		c.gridy = 0;
		boutons.add(valider, c);
		valider.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CreationPartieController cpc = new CreationPartieController(nom_partiejtf.getText()
						, (int) nb_joueurs_spin.getValue()
						, (int) nb_tours_slider.getValue()
						, (int) nb_ressources_tour_slider.getValue()
						, (int) nb_ressources_tour_slider.getValue()
						, (CarteType) type_carte_spin.getValue()
						, (int) dimension_carte_spin.getValue());
				cpc.actionPerformed(e);
			}
		});
		
		partie.setBackground(new Color(0, 0, 0, 0));
		carte.setBackground(new Color(0, 0, 0, 0));
		boutons.setBackground(new Color(0, 0, 0, 0));
		
		c.insets = new Insets(0, 0, 0, 0);
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 0;
		this.add(partie, c);
		c.gridx = 0;
		c.gridy = 1;
		this.add(carte, c);
		c.gridx = 0;
		c.gridy = 2;
		this.add(boutons, c);
		
		this.setBounds(0, 0, 1280, 720);
	}
	
	 public void paintComponent(Graphics g) {
	    Image img = null;
		try {
			img = ImageIO.read(Jeu.getInstance().getFileByKey("fond"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	    g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), null);
	 }
	
}
