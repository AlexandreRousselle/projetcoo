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
	JTextField nom_partiejtf = new JTextField();
	JSpinner nb_joueurs_spin = new JSpinner(new SpinnerNumberModel(2, 2, 4, 1));
	//
	JLabel type_carte = new JLabel("Type de carte");
	JLabel dimension_carte = new JLabel("Dimension de la carte");
	JSpinner type_carte_spin = new JSpinner(new SpinnerListModel(CarteType.values()));
	JSpinner dimension_carte_spin = new JSpinner(new SpinnerNumberModel(10, 10, 20, 2));
	//
	JButton valider = new JButton("Valider");
	JButton retour = new JButton("Retour");
	Font font = new Font("Arial",Font.BOLD,14);

	public NouvellePartieView() {
		
		this.setLayout(new GridBagLayout());
		
		TitledBorder tb = new TitledBorder("Configuration Partie");
		tb.setTitleColor(Color.WHITE);
		partie.setBorder(tb);
		
		TitledBorder tb2 = new TitledBorder("Configuration Carte");
		tb2.setTitleColor(Color.WHITE);
		carte.setBorder(tb2);
		
		GridBagConstraints c = new GridBagConstraints();
		
		nom_partie.setForeground(Color.WHITE);
		nb_joueurs.setForeground(Color.WHITE);
		nom_partie.setFont(font);
		nb_joueurs.setFont(font);
		type_carte.setForeground(Color.WHITE);
		dimension_carte.setForeground(Color.WHITE);
		type_carte.setFont(font);
		dimension_carte.setFont(font);
		
		((JSpinner.DefaultEditor) nb_joueurs_spin.getEditor()).getTextField().setEditable(false);
		((JSpinner.DefaultEditor) type_carte_spin.getEditor()).getTextField().setEditable(false);
		((JSpinner.DefaultEditor) dimension_carte_spin.getEditor()).getTextField().setEditable(false);
		
		nom_partiejtf.setPreferredSize(new Dimension(150, 30));
		nb_joueurs_spin.setPreferredSize(new Dimension(150, 30));
		type_carte_spin.setPreferredSize(new Dimension(150, 30));
		dimension_carte_spin.setPreferredSize(new Dimension(150, 30));
		
		partie.setLayout(new GridBagLayout());
		c.weightx = 2;
		c.weighty = 2;
		c.gridwidth = 1;
		c.insets = new Insets(10, 20, 10, 20);
		c.gridx = 0;
		c.gridy = 0;
		partie.add(nom_partie, c);
		c.gridx = 0;
		c.gridy = 1;
		partie.add(nb_joueurs, c);
		c.anchor = GridBagConstraints.CENTER;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		partie.add(nom_partiejtf, c);
		c.gridx = 1;
		c.gridy = 1;
		partie.add(nb_joueurs_spin, c);
		
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
		c.anchor = GridBagConstraints.CENTER;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		carte.add(type_carte_spin, c);
		c.gridx = 1;
		c.gridy = 1;
		carte.add(dimension_carte_spin, c);	
		
		boutons.setLayout(new GridBagLayout());
		c.weightx = 2;
		c.weighty = 1;
		c.gridwidth = 1;
		c.anchor = GridBagConstraints.CENTER;
		c.fill = GridBagConstraints.HORIZONTAL;
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
						, (CarteType) type_carte_spin.getValue()
						, (int) dimension_carte_spin.getValue());
				cpc.actionPerformed(e);
			}
		});
		
		partie.setBackground(new Color(0, 0, 0, 0));
		carte.setBackground(new Color(0, 0, 0, 0));
		boutons.setBackground(new Color(0, 0, 0, 0));
		
		c.insets = new Insets(0, 0, 0, 0);
		c.weightx = 1;
		c.weighty = 3;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		this.add(partie, c);
		c.gridx = 0;
		c.gridy = 1;
		this.add(carte, c);
		c.gridx = 0;
		c.gridy = 2;
		this.add(boutons, c);
		
		this.setBounds(0, 0, 500, 700);
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
