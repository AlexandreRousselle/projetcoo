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
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import game.controller.RejoindreController;
import game.controller.RetourMenuListener;
import game.main.EtatJeu;
import game.main.Jeu;
import game.model.joueur.Joueur;
import game.model.partie.Partie;
import game.persistance.JoueurMapper;
import game.persistance.PartieMapper;
import game.persistance.UnitOfWorks;

public class ChoixPartieView extends JPanel {

	private static final long serialVersionUID = 1L;
	
	int mode_choix;
	String titledBorderName;
	//
	JList<Partie> listeParties = new JList<Partie>();
	//
	JLabel label_infos = new JLabel("Pas d'informations");
	//
	SoulsButton selection = new SoulsButton(200, 60);
	SoulsButton retour = new SoulsButton("Retour", 200, 60);
	
	Font font = new Font("Arial",Font.BOLD,14);
	
	public ChoixPartieView(int mode){
		this.mode_choix = mode;
		System.out.println(Jeu.getInstance().getCurrent_joueur().getPseudo());
		System.out.println(Jeu.getInstance().getCurrent_partie());
		this.setAttributes();
		
		label_infos.setForeground(Color.WHITE);
		label_infos.setFont(font);
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		listeParties.setPreferredSize(new Dimension(500, 400));
		listeParties.setBackground(new Color(180, 180, 180));
		c.gridwidth = 2;
		c.insets = new Insets(10, 20, 10, 20);
		c.gridx = 0;
		c.gridy = 1;
		this.add(label_infos, c);
		c.gridx = 0;
		c.gridy = 0;
		this.add(listeParties, c);
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 1;
		this.add(retour, c);
		retour.addActionListener(new RetourMenuListener());
		c.gridx = 1;
		c.gridy = 2;
		this.add(selection, c);

		this.setBounds(0, 0, 1280, 720);
	}
	
	public void setAttributes(){
		List<Partie> p = null;
		if(this.mode_choix == 1) {
			this.titledBorderName = "Rejoindre une partie";
			Vector<Partie> parties = new Vector<Partie>();
			try {
				p = PartieMapper.getInstance().findInWait(Jeu.getInstance().getCurrent_joueur());
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(p != null){
				for (int i = 0; i < p.size(); i++) {
					parties.add(p.get(i));
				}
			}
			this.listeParties.setListData(parties);
			selection.setText("Rejoindre");
			selection.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					RejoindreController rc = new RejoindreController(listeParties.getSelectedValue());
					rc.actionPerformed(e);
				}
			});
		} else {
			this.titledBorderName = "Voir mes parties";
			Vector<Partie> parties = new Vector<Partie>();
			try {
				p = PartieMapper.getInstance().findByIdJoueur(Jeu.getInstance().getCurrent_joueur().getId_joueur());
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(p != null){
				for (int i = 0; i < p.size(); i++) {
					parties.add(p.get(i));
				}
			}
			this.listeParties.setListData(parties);
			selection.setText("Continuer");
			selection.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Jeu.getInstance().setCurrent_partie(listeParties.getSelectedValue());
					Jeu.getInstance().setEtat_jeu(EtatJeu.ATTENTE_PARTIE);
				}
			});
		}
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
