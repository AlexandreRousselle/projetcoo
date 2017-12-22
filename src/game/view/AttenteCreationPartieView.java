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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import game.controller.RetourMenuListener;
import game.controller.SeDesinscrireController;
import game.main.EtatJeu;
import game.main.Jeu;
import game.model.partie.EtatPartie;
import game.model.partie.Partie;
import game.persistance.JoueurMapper;
import game.persistance.PartieMapper;
import game.persistance.UnitOfWorks;

public class AttenteCreationPartieView extends JPanel {

	private static final long serialVersionUID = 1L;
	
	JLabel nom_partie = new JLabel();
	
	SoulsButton demmarer = new SoulsButton("Demarrer", 200, 50);
	SoulsButton retour = new SoulsButton("Retour", 200, 50);
	SoulsButton se_desinscrire = new SoulsButton("Se desinscrire", 200, 50);
	
	Font font_name = new Font("Arial",Font.BOLD,20);
	Font font = new Font("Arial",Font.BOLD,14);
	
	public AttenteCreationPartieView(){
		
		System.out.println(Jeu.getInstance().getCurrent_joueur().getPseudo());
		System.out.println(Jeu.getInstance().getCurrent_partie());
		System.out.println(Jeu.getInstance().getCurrent_partie().getCreateur().getId_joueur());
		
		if(Jeu.getInstance().getCurrent_partie().getCreateur().getId_joueur() != Jeu.getInstance().getCurrent_joueur().getId_joueur()) {
			demmarer.setEnabled(false);
		} else {
			se_desinscrire.setEnabled(false);
		}
		
		this.setLayout(new GridBagLayout());
		
		nom_partie.setForeground(Color.WHITE);
		nom_partie.setFont(font_name);

		
		GridBagConstraints c = new GridBagConstraints();
		this.setLayout(new GridBagLayout());

		c.gridx = 0;
		c.insets = new Insets(10, 10, 50, 10);
		c.gridy = 0;
		c.gridwidth = 2;
		
		nom_partie.setText(Jeu.getInstance().getCurrent_partie().getNom_partie());
		
		this.add(nom_partie, c);
		
		c.gridwidth = 1;
		
		for (int i = 0; i < Jeu.getInstance().getCurrent_partie().getNb_joueurs(); i++) {
			c.gridy = i+1;
			JLabel jl = new JLabel("Joueur " + (i+1) + " : ");
			jl.setForeground(Color.WHITE);
			jl.setFont(font);
			this.add(jl, c);
		}
		
		List<String> lj = new ArrayList<String>();
		try {
			lj = JoueurMapper.getInstance().findUserNamesByJoueurPartie(
					Jeu.getInstance().getCurrent_partie().getId_partie());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		c.gridx = 1;
		c.gridy = 1;
		
		for (int i = 0; i < lj.size(); i++) {
			c.gridy = i+1;
			JLabel jl = new JLabel(lj.get(i));
			jl.setForeground(Color.WHITE);
			jl.setFont(font);
			this.add(jl, c);
		}
		
		c.insets = new Insets(10, 20, 10, 20);
		c.gridx = 0;
		c.gridy = Jeu.getInstance().getCurrent_partie().getNb_joueurs()+1;
		retour.addActionListener(new RetourMenuListener());
		this.add(retour, c);
		c.gridx = 1;
		this.add(demmarer, c);
		demmarer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Jeu.getInstance().setEtat_partie(EtatPartie.EN_COURS);
				Jeu.getInstance().setEtat_jeu(EtatJeu.PARTIE_EN_COURS);
			}
		});
		
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = Jeu.getInstance().getCurrent_partie().getNb_joueurs()+2;
		this.add(se_desinscrire, c);
		se_desinscrire.addActionListener(new SeDesinscrireController());

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