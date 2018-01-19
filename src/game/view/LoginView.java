package game.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import game.controller.AuthentificationController;
import game.main.Jeu;

public class LoginView extends JPanel {

	private static final long serialVersionUID = 1L;

	JLabel authText = new JLabel("Authentification");
	JLabel logo = new JLabel("", new ImageIcon("ressources/soulSplit_logo_short.png"), SwingConstants.CENTER);
	JLabel pseudo = new JLabel("Pseudo");
	JLabel mdp = new JLabel("Mot de passe");
	JTextField pseudojtf = new JTextField("rousselle");
	JTextField mdpjtf = new JTextField("rousselle");
	SoulsButton valider = new SoulsButton("Connexion", 140, 30);
    Font font_auth = new Font("Arial", Font.BOLD, 16);
	Font font = new Font("Arial",Font.BOLD,14);
	
	public LoginView() {	
		authText.setForeground(Color.WHITE);
		pseudo.setForeground(Color.WHITE);
		mdp.setForeground(Color.WHITE);
		authText.setFont(font_auth);
		pseudo.setFont(font);
		mdp.setFont(font);		
		this.setLayout(null);
		this.logo.setBounds((1280/2)- 200, 10, 400, 126);
		this.authText.setBounds((1280/2)- 80, (720/2)-120, 160, 30);
		this.pseudojtf.setBounds((1280/2), (720/2)-50, 120, 30);
		this.mdpjtf.setBounds((1280/2), (720/2)+20, 120, 30);
		this.pseudo.setBounds((1280/2)-105, (720/2)-50, 160, 30);
		this.mdp.setBounds((1280/2)-125, (720/2)+20, 160, 30);
		this.valider.setBounds((1280/2)-75, (720/2)+100, 140, 30);
		this.add(logo);
		this.add(pseudo);
		this.add(mdp);
		this.add(pseudojtf);
		this.add(mdpjtf);
		this.add(authText);
		this.add(valider);
		valider.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AuthentificationController au = new AuthentificationController(pseudojtf.getText(), mdpjtf.getText());
				au.actionPerformed(e);
			}
		});
		this.setBounds(0, 0, 1280, 720);
	}
	
    public void paintComponent(Graphics g) {
    	Image img = null;
		try {
			img = ImageIO.read(Jeu.getInstance().getFileByKey("fond_login"));
		} catch (IOException e) {
			e.printStackTrace();
		}
        g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), null);
    }

}