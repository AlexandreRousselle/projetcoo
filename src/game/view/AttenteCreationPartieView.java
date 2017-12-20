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
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import game.controller.RetourMenuListener;
import game.controller.SeDesinscrireController;
import game.main.EtatJeu;
import game.main.Jeu;
import game.model.partie.Partie;
import game.persistance.JoueurMapper;
import game.persistance.PartieMapper;

public class AttenteCreationPartieView extends JPanel {

	private static final long serialVersionUID = 1L;
	
	JLabel nom_partie = new JLabel();
	
	JButton demmarer = new JButton("Demarrer");
	JButton retour = new JButton("Retour");
	JButton se_desinscrire = new JButton("Se desinscrire");
	
	Font font = new Font("Arial",Font.BOLD,14);
	
	public AttenteCreationPartieView(){
		
		if(Jeu.getInstance().getCurrent_partie().getCreateur().getId_joueur() != Jeu.getInstance().getCurrent_joueur().getId_joueur()) {
			demmarer.setEnabled(false);
		} else {
			se_desinscrire.setEnabled(false);
		}
		
		this.setLayout(new GridBagLayout());
		TitledBorder tb = new TitledBorder("Salle d'attente");
		tb.setTitleColor(Color.WHITE);
		this.setBorder(tb);
		
		nom_partie.setForeground(Color.WHITE);
		nom_partie.setFont(font);
		
		GridBagConstraints c = new GridBagConstraints();
		this.setLayout(new GridBagLayout());

		c.weightx = 2;
		c.weighty = Jeu.getInstance().getCurrent_partie().getNb_joueurs()+2;
		c.gridx = 0;
		
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
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = Jeu.getInstance().getCurrent_partie().getNb_joueurs()+1;
		retour.addActionListener(new RetourMenuListener());
		this.add(retour, c);
		c.gridx = 1;
		this.add(demmarer, c);
		demmarer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Jeu.getInstance().setEtat_jeu(EtatJeu.PARTIE_EN_COURS);
			}
		});
		
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = Jeu.getInstance().getCurrent_partie().getNb_joueurs()+2;
		this.add(se_desinscrire, c);
		se_desinscrire.addActionListener(new SeDesinscrireController());

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