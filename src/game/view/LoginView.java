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
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import game.persistance.UserMapper;

public class LoginView extends JPanel {

	private static final long serialVersionUID = 1L;

	JLabel pseudo = new JLabel("Pseudo");
	JLabel mdp = new JLabel("Mot de passe");
	JTextField pseudojtf = new JTextField("rousselle");
	JTextField mdpjtf = new JTextField("rousselle");
	JButton valider = new JButton("Valider");
	Font font = new Font("Arial",Font.BOLD,16);

	public LoginView() {
		
		this.setName("Login");
		TitledBorder tb = new TitledBorder("Connexion");
		tb.setTitleColor(Color.WHITE);
		this.setBorder(tb);
		pseudo.setForeground(Color.WHITE);
		mdp.setForeground(Color.WHITE);
		pseudo.setFont(font);
		mdp.setFont(font);		
		pseudojtf.setPreferredSize(new Dimension(150, 30));
		mdpjtf.setPreferredSize(new Dimension(150, 30));
		valider.setPreferredSize(new Dimension(200, 30));
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
        c.weightx = 3;
		c.weighty = 3;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.insets = new Insets(10, 20, 10, 20);
		this.add(pseudo, c);
		c.gridx = 0;
		c.gridy = 1;
		this.add(mdp, c);
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 2;
		c.anchor = GridBagConstraints.CENTER;
		c.fill = GridBagConstraints.HORIZONTAL;
		this.add(pseudojtf, c);
		c.gridx = 1;
		c.gridy = 1;
		this.add(mdpjtf, c);
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 3;
		c.fill = 0;
		valider.addActionListener(new ValiderListener());
		this.add(valider, c);

		this.setBounds(0, 0, 400, 300);
	}
	
    public void paintComponent(Graphics g) {
    	Image img = null;
		try {
			img = ImageIO.read(new File("ressources/fonds/fondromain.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
        g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), null);
        
    }

	class ValiderListener extends JFrame implements ActionListener {

    	private static final long serialVersionUID = 1L;

    	@Override
    	public void actionPerformed(ActionEvent e) {
    	// TODO Auto-generated method stub
	    	try {
		    	if(UserMapper.getInstance().findByPseudoPassword(pseudojtf.getText(), mdpjtf.getText()) != null) {
			    	JOptionPane.showMessageDialog(null,"Connexion réussie ! ","Success", JOptionPane.PLAIN_MESSAGE);
			    	
			    } else {
			    	JOptionPane.showMessageDialog(null,"Login ou mot de passe incorrect ! ", "Error", 1);
		    	}
	    	}
	    	catch (Exception ex) {
	    		ex.printStackTrace();
	    	}
    	}
	}

}