package game.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import game.model.User;
import game.persistance.UserMapper;

public class LoginView extends JPanel {

	private static final long serialVersionUID = 1L;

	JLabel pseudo = new JLabel("Pseudo");
	JLabel mdp = new JLabel("Mot de passe");
	JTextField pseudojtf = new JTextField();
	JTextField mdpjtf = new JTextField();
	JButton valider = new JButton("Valider");
	JButton annuler = new JButton("Annuler");

	public LoginView() {

		this.setName("Login");
		this.setBorder(new TitledBorder("Connexion"));

		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		
		this.add(pseudo, c);
		this.add(pseudojtf, c);
		this.add(mdp, c);
		this.add(mdpjtf, c);
		valider.addActionListener(new ValiderListener());
		this.add(valider, c);
		this.add(annuler, c);

		this.setBounds(0, 0, 200, 400);
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