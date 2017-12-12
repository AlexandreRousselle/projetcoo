package game.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import game.view.MenuPrincipalView.DecoListener;
import game.view.MenuPrincipalView.NouvelleListener;
import game.view.MenuPrincipalView.RejoindreListener;
import game.view.MenuPrincipalView.VoirListener;

public class NouvellePartieView extends JPanel {

	private static final long serialVersionUID = 1L;

	JButton nouvelle = new JButton("Nouvelle partie");
	JButton rejoindre = new JButton("Rejoindre partie");
	JButton voir = new JButton("Voir mes parties");
	JButton deco = new JButton("Deconnexion");
	Font font = new Font("Arial",Font.BOLD,16);

	public NouvellePartieView() {
		
		this.setName("Nouvelle Partie");
		TitledBorder tb = new TitledBorder("Choix");
		tb.setTitleColor(Color.WHITE);
		this.setBorder(tb);
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 1;
		c.weighty = 4;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(50, 100, 50, 100);
		c.gridx = 0;
		c.gridy = 0;
		
		
		this.setBounds(0, 0, 400, 600);
	}
}
