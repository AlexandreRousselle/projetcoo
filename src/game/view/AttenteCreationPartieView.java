package game.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.io.IOException;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import game.controller.RetourMenuListener;
import game.main.Jeu;
import game.model.partie.Partie;
import game.persistance.JoueurMapper;
import game.persistance.PartieMapper;
import game.persistance.UserMapper;

public class AttenteCreationPartieView extends JPanel {

	private static final long serialVersionUID = 1L;
	
	JLabel nom_partie = new JLabel();
	
	JButton valider = new JButton("Valider");
	JButton retour = new JButton("Retour");
	
	Font font = new Font("Arial",Font.BOLD,14);
	
	public AttenteCreationPartieView(){
		this.setLayout(new GridBagLayout());
		TitledBorder tb = new TitledBorder("Salle d'attente");
		tb.setTitleColor(Color.WHITE);
		this.setBorder(tb);
		
		nom_partie.setForeground(Color.WHITE);
		nom_partie.setFont(font);
		
		GridBagConstraints c = new GridBagConstraints();
		this.setLayout(new GridBagLayout());

		c.weightx = 2;
		c.weighty = Jeu.getInstance().getCurrent_partie().getNb_joueurs()+1;
		c.gridx = 0;
		
		c.gridy = 0;
		c.gridwidth = 2;
		
		nom_partie.setText(Jeu.getInstance().getCurrent_partie().getNom_partie());
		
		this.add(nom_partie, c);
		
		for (int i = 0; i < Jeu.getInstance().getCurrent_partie().getNb_joueurs(); i++) {
			c.gridy = i+1;
			JLabel jl = new JLabel("User " + (i+1) + " : ");
			try {
				JLabel jl2 = new JLabel(UserMapper.getInstance().findUserNamesByJoueurPartie(
						Jeu.getInstance().getCurrent_partie().getId_partie()).get(i)
						);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				JLabel jl2 = new JLabel();
			}
			jl.setForeground(Color.WHITE);
			jl.setFont(font);
			this.add(jl, c);
		}
		
		c.insets = new Insets(10, 20, 10, 20);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = Jeu.getInstance().getCurrent_partie().getNb_joueurs()+1;
		retour.addActionListener(new RetourMenuListener());
		this.add(retour, c);
		c.gridx = 1;
		this.add(valider, c);
		
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
