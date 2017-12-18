package game.view;

import java.awt.Color;
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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.border.TitledBorder;

import game.controller.RetourMenuListener;
import game.main.EtatJeu;
import game.main.Jeu;
import game.model.joueur.JoueurTribu;

public class CreationJoueurView extends JPanel {
	
private static final long serialVersionUID = 1L;
	
	JLabel nom_partie = new JLabel();
	//
	JButton pret = new JButton("Pret");
	JButton demarrer = new JButton("Demarrer !");
	JButton retour = new JButton("Retour");
	
	Font font = new Font("Arial",Font.BOLD,14);
	
	public CreationJoueurView(){
		this.setLayout(new GridBagLayout());
		TitledBorder tb = new TitledBorder("Creation des joueurs");
		tb.setTitleColor(Color.WHITE);
		this.setBorder(tb);
		
		nom_partie.setForeground(Color.WHITE);
		nom_partie.setFont(font);
		
		GridBagConstraints c = new GridBagConstraints();
		this.setLayout(new GridBagLayout());

		c.weightx = 0;
		c.weighty = Jeu.getInstance().getCurrent_partie().getNb_joueurs()+1;
		c.gridx = 0;
		
		c.gridy = 0;
		c.gridwidth = 2;
		
		nom_partie.setText(Jeu.getInstance().getCurrent_partie().getNom_partie());
		
		this.add(nom_partie, c);
		
		for (int i = 0; i < Jeu.getInstance().getCurrent_partie().getNb_joueurs(); i++) {
			c.gridy = i+1;
			JLabel type_joueur = new JLabel("Tribu");
			type_joueur.setForeground(Color.WHITE);
			type_joueur.setFont(font);
			this.add(type_joueur, c);
			JSpinner type_joueur_spin = new JSpinner(new SpinnerListModel(JoueurTribu.values()));
			this.add(type_joueur_spin, c);
		}
		
		c.insets = new Insets(10, 20, 10, 20);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = Jeu.getInstance().getCurrent_partie().getNb_joueurs()+1;
		retour.addActionListener(new RetourMenuListener());
		this.add(retour, c);
		c.gridx = 1;
		this.add(pret, c);
		c.gridy = Jeu.getInstance().getCurrent_partie().getNb_joueurs()+2;
		c.gridwidth = 2;
		c.gridx = 0;
		this.add(demarrer, c);
		demarrer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Jeu.getInstance().addListeJoueursToPartie(l);
				Jeu.getInstance().setEtat_jeu(EtatJeu.PARTIE_EN_COURS);
			}
		});
		
		this.setBounds(0, 0, 500, 500);
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
