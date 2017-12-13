package game.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import game.main.Jeu;
import game.model.partie.Partie;

public class AttenteCreationPartieView extends JPanel {

	private static final long serialVersionUID = 1L;
	
	JButton valider = new JButton("Valider");
	JButton retour = new JButton("Retour");
	
	Font font = new Font("Arial",Font.BOLD,14);
	
	public AttenteCreationPartieView(){
		this.setLayout(new GridBagLayout());
		System.out.println(Jeu.getInstance().getInfostmp().toString());
		TitledBorder tb = new TitledBorder("Salle d'attente");
		tb.setTitleColor(Color.WHITE);
		this.setBorder(tb);
		
		GridBagConstraints c = new GridBagConstraints();

		
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
