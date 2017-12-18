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
import java.util.List;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import game.controller.RetourMenuListener;
import game.main.EtatJeu;
import game.main.Jeu;
import game.model.joueur.Joueur;
import game.model.partie.Partie;
import game.persistance.JoueurMapper;
import game.persistance.PartieMapper;

public class ChoixPartieView extends JPanel {

	private static final long serialVersionUID = 1L;
	
	int mode_choix;
	String titledBorderName;
	//
	JList<Partie> listeParties = new JList<Partie>();
	//
	JLabel label_infos = new JLabel("Pas d'informations");
	//
	JButton selection = new JButton();
	JButton retour = new JButton("Retour");
	
	Font font = new Font("Arial",Font.BOLD,14);
	
	public ChoixPartieView(int mode){
		this.mode_choix = mode;
		this.setAttributes();
		TitledBorder tb = new TitledBorder(this.titledBorderName);
		tb.setTitleColor(Color.WHITE);
		this.setBorder(tb);
		
		label_infos.setForeground(Color.WHITE);
		label_infos.setFont(font);
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.weightx = 2;
		c.weighty = 3;
		c.gridwidth = 2;
		c.insets = new Insets(10, 20, 10, 20);
		c.gridx = 0;
		c.gridy = 1;
		c.anchor = GridBagConstraints.CENTER; 
		this.add(label_infos, c);
		c.gridx = 0;
		c.gridy = 0;
		c.fill = GridBagConstraints.BOTH;
		this.add(listeParties, c);
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		this.add(retour, c);
		retour.addActionListener(new RetourMenuListener());
		c.gridx = 1;
		c.gridy = 2;
		this.add(selection, c);

		this.setBounds(0, 0, 500, 700);
	}
	
	public void setAttributes(){
		List<Partie> p = null;
		if(this.mode_choix == 1) {
			this.titledBorderName = "Rejoindre une partie";
			Vector<Partie> parties = new Vector<Partie>();
			try {
				p = PartieMapper.getInstance().findInWait(Jeu.getInstance().getCurrent_user());
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
		} else {
			this.titledBorderName = "Voir mes parties";
			Vector<Partie> parties = new Vector<Partie>();
			try {
				p = PartieMapper.getInstance().findByIdUser(Jeu.getInstance().getCurrent_user().getId_user());
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
					Joueur j = new Joueur(Jeu.getInstance().getCurrent_user().getPseudo(),null,null);
					j.setPartie(listeParties.getSelectedValue());
					try {
						JoueurMapper.getInstance().insert(j);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
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
