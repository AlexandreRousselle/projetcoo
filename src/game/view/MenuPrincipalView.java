package game.view;

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
import javax.swing.JFrame;
import javax.swing.JPanel;

import game.main.EtatJeu;
import game.main.Jeu;

public class MenuPrincipalView extends JPanel {
	
	private static final long serialVersionUID = 1L;

	SoulsButton nouvelle = new SoulsButton("Nouvelle partie", 500, 70);
	SoulsButton rejoindre = new SoulsButton("Rejoindre partie", 500, 70);
	SoulsButton voir = new SoulsButton("Voir mes parties", 500, 70);
	SoulsButton deco = new SoulsButton("Deconnexion", 500, 70);
	Font font = new Font("Arial",Font.BOLD,16);

	public MenuPrincipalView() {
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 1;
		c.weighty = 4;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(25, 50, 25, 50);
		c.gridx = 0;
		c.gridy = 0;
		this.add(nouvelle, c);
		nouvelle.addActionListener(new NouvelleListener());
		c.gridx = 0;
		c.gridy = 1;
		this.add(rejoindre, c);
		rejoindre.addActionListener(new RejoindreListener());
		c.gridx = 0;
		c.gridy = 2;
		this.add(voir, c);
		voir.addActionListener(new VoirListener());
		c.gridx = 0;
		c.gridy = 3;
		this.add(deco, c);
		deco.addActionListener(new DecoListener());
		
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

	class NouvelleListener extends JFrame implements ActionListener {

    	private static final long serialVersionUID = 1L;

    	@Override
    	public void actionPerformed(ActionEvent e) {
    		Jeu.getInstance().setEtat_jeu(EtatJeu.MENU_NOUVELLE);
    	}
	}
	
	class RejoindreListener extends JFrame implements ActionListener {

    	private static final long serialVersionUID = 1L;

    	@Override
    	public void actionPerformed(ActionEvent e) {
    		Jeu.getInstance().setEtat_jeu(EtatJeu.MENU_REJOINDRE);
    	}
	}
	
	class VoirListener extends JFrame implements ActionListener {

    	private static final long serialVersionUID = 1L;

    	@Override
    	public void actionPerformed(ActionEvent e) {
    		Jeu.getInstance().setEtat_jeu(EtatJeu.MENU_VOIR);
    	}
	}
	
	class DecoListener extends JFrame implements ActionListener {

    	private static final long serialVersionUID = 1L;

    	@Override
    	public void actionPerformed(ActionEvent e) {
    		Jeu.getInstance().setEtat_jeu(EtatJeu.PAGE_LOGIN);
    		Jeu.getInstance().setCurrent_joueur(null);
    	}
	}
    	
    

}
