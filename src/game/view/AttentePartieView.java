package game.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import game.model.partie.Partie;

public class AttentePartieView extends JPanel {

	private static final long serialVersionUID = 1L;
	
	JButton valider = new JButton("Valider");
	JButton retour = new JButton("Retour");
	
	Font font = new Font("Arial",Font.BOLD,14);
	
	public AttentePartieView(Partie p){
		
		this.setLayout(new GridBagLayout());
		TitledBorder tb = new TitledBorder("Salle d'attente");
		tb.setTitleColor(Color.WHITE);
		this.setBorder(tb);
		
		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 2;
		c.weighty = p.getListeJoueurs().size()+1;
		c.gridwidth = 2;
		c.anchor = GridBagConstraints.CENTER;
		
		for (int i = 0; i < p.getListeJoueurs().size(); i++) {
			c.gridx = 0;
			c.gridy = i;
			JLabel jl = new JLabel(p.getListeJoueurs().get(i).getNom_joueur()
					+ "," + p.getListeJoueurs().get(i).getJoueur_tribu());
			jl.setFont(font);
			jl.setForeground(Color.WHITE);
			this.add(jl, c);
		}
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = p.getListeJoueurs().size()+1;
		this.add(retour, c);
		c.gridx = 1;
		c.gridy = p.getListeJoueurs().size()+1;
		this.add(valider, c);
		
	}
	
}
